package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Servico;
import com.example.demo.services.ServicoServices;


@RestController
@RequestMapping("/serviços")
public class ServicoController<servicoservices> {
   
    private final ServicoServices servicoservices;
   
    @Autowired
    public ServicoController(ServicoServices servicoservices) {
        this.servicoservices = servicoservices;
       
    }
    @PostMapping
    public Servico createServico(@RequestBody Servico servico) {
        return servicoservices.saveServico(servico);
       
    }
   
    @GetMapping
    public List<Servico> getAllServico(){
        return servicoservices.getAllServicos();
       
       
    }
    @GetMapping("{/id}")
    public Servico getServico(@PathVariable Long id) {
        return servicoservices.getservicoById(id);
    }
   
    @DeleteMapping("{/id}")
    public void deleteServico(@PathVariable Long id) {
    	servicoservices.deleteServico(id);
    }
    
    //fazer o endpoint de update
    public Servico updateServico(@PathVariable Long id, @RequestBody Servico servico) {
    	return servicoservices.updateServico(id, servico);
    }
}