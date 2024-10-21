package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Servico;
import com.example.demo.repositories.ServicoRepository;

@Service
public class ServicoServices {
   
    @Autowired
    private final ServicoRepository servicorepository;
	private Optional<Servico> servicoOptional;
	private Servico servicoExistente;
    @Autowired
    public ServicoServices(ServicoRepository servicorepository) {
        this.servicorepository = servicorepository;
    }
   
    public Servico saveServico(Servico cliente) {
        return servicorepository.save(cliente);
       
    }
   
    public Servico getservicoById(Long id) {
        return servicorepository.findById(id).orElse(null);
    }

    public List<Servico> getAllServicos(){
        return servicorepository.findAll();
    }
   
    public void deleteServico(Long id) {
    	servicorepository.deleteById(id);
    }
   
    public Servico updateServico(Long id, Servico servicoAtualizado) {
    	//criando o optional para receber o serviço
    	Optional<Servico> servicoOptional = servicorepository.findById(id);
    	if(servicoOptional.isPresent()) {
    		//se encontrou
    		Servico clienteExistente = servicoOptional.get();
    		servicoExistente.setDescricao(servicoAtualizado.getDescricao());
    		servicoExistente.setValor(servicoAtualizado.getValor());
    		return servicorepository.save(servicoExistente);
    	}else {
    		//se não encontrou
    		return null;
    	}
    }
}