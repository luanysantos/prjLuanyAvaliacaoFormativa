package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cliente;
import com.example.demo.repositories.ClienteRepository;



@Service
public class ClienteService {
   
    @Autowired
    private final ClienteRepository clienterepository;
	private Optional<Cliente> clienteOptional;
    @Autowired
    public ClienteService(ClienteRepository clienterepository) {
        this.clienterepository = clienterepository;
    }
   
    public Cliente saveCliente(Cliente cliente) {
        return clienterepository.save(cliente);
       
    }
   
    public Cliente getclienteById(Long id) {
        return clienterepository.findById(id).orElse(null);
    }

    public List<Cliente> getAllClientes(){
        return clienterepository.findAll();
    }
   
    public void deleteCliente(Long id) {
    	clienterepository.deleteById(id);
    }
   
    public Cliente updateCliente(Long id, Cliente clienteAtualizado) {
    	//criando o optional para receber o cliente
    	Optional<Cliente> clienteOptional = clienterepository.findById(id);
    	if(clienteOptional.isPresent()) {
    		//se encontrou
    		Cliente clienteExistente = clienteOptional.get();
    		clienteExistente.setName(clienteAtualizado.getName());
    		clienteExistente.setEndereco(clienteAtualizado.getEndereco());
    		return clienterepository.save(clienteExistente);
    	}else {
    		//se não encontrou
    		return null;
    	}
    }
}