package co.edu.unab.api.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.api.models.ClienteModel;
import co.edu.unab.api.services.ClienteService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public ArrayList<ClienteModel> obtenerClientes(){
        return  clienteService.obtenerClientes();
    }

    @PostMapping()
    public ClienteModel guardarCliente(@RequestBody ClienteModel cliente){
        
        return clienteService.guardarCliente(cliente);
    }
    
    @DeleteMapping(path = "/{id}")
    public String eliminarClientePorId(@PathVariable("id") String id){
        boolean resultadoEliminar=this.clienteService.eliminarCliente(id);
        if (resultadoEliminar){
            return "Se eliminó el usuario con id: "+id;
        }else{
            return "No se pudo eliminar el usuario con el id: "+id;
        }
    }
    
    @GetMapping(path = "/{id}")
    public Optional<ClienteModel> obtenerClientePorId(@PathVariable("id") String id){
        return this.clienteService.obtenerClientePorId(id);
    }

    @GetMapping(path = "/nombre/{nombre}")
    public ArrayList<ClienteModel> obtenerClienteporNombre(@PathVariable("nombre") String nombre){
        return this.clienteService.obtenerClienteporNombre(nombre);
    }

    @GetMapping(path = "/ubicacion/{ciudad}/{departamento}")
    public ArrayList<ClienteModel> obtenerporUbicacion(@PathVariable("ciudad") String ciudad,@PathVariable("departamento") String departamento ){
        return this.clienteService.clienteporCiudad(ciudad,departamento);
    }

    @GetMapping(path = "/puntos/{puntos}")
    public ArrayList<ClienteModel> obtenerporpuntosmayores(@PathVariable("puntos") Long puntos){
        return this.clienteService.clienteporpuntosmayores(puntos);
    }

    @GetMapping(path = "/puntosmen/{puntos}")
    public ArrayList<ClienteModel> obtenerporpuntosmenores(@PathVariable("puntos") Long puntos){
        return this.clienteService.clienteporpuntosmenores(puntos);
    }

    @GetMapping(path = "/productos/{nombre}")
    public ArrayList<ClienteModel> obtenerpornombreproducto(@PathVariable("nombre") String nombre){
        return this.clienteService.clienteporproducto(nombre);
    }




  
}