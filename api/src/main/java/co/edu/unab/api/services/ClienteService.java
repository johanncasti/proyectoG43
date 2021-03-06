package co.edu.unab.api.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.api.models.ClienteModel;
import co.edu.unab.api.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public ArrayList<ClienteModel> obtenerClientes(){
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

    public ClienteModel guardarCliente(ClienteModel cliente){
        cliente.setNombre(cliente.getNombre().toLowerCase()); //Opcional, convertir la cadena a minúscula para facilitar buscar por nombre , esto normalmente se hace desde el frontend 
        return clienteRepository.save(cliente);
    }

    public boolean eliminarCliente(String id){

        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return true;
        }else{
            return false;
        }      
                             
    }      
    public Optional<ClienteModel> obtenerClientePorId(String id){
        
        return clienteRepository.findById(id);
    }  
    
    public ArrayList<ClienteModel> obtenerClienteporNombre(String nombre){

        return clienteRepository.findByNombre(nombre);
    }

    public ArrayList<ClienteModel> clienteporCiudad(String ciudad, String departamento) {
        return clienteRepository.clientexciudad(ciudad,departamento);
    }

    public ArrayList<ClienteModel> clienteporpuntosmayores(Long puntos) {
        return clienteRepository.findBypuntosGreaterThanEqual(puntos);
    }

    public ArrayList<ClienteModel> clienteporpuntosmenores(Long puntos) {
        return clienteRepository.clientexmenorpuntaje(puntos);
    }

    public ArrayList<ClienteModel> clienteporproducto(String nombre) {
        return clienteRepository.clientexproducto(nombre);
    }
   

}