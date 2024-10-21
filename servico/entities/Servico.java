package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "serviço")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private double valor;
  
    public Long getId() {
        return id;
    }
   
    public void setId(Long id) {
        this.id = id;
    }
   
    public String getDescricao() {
        return descricao;
    }
   
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
   
    public double getValor() {
        return valor;
       
    }
   
    public void setValor(double valor) {
        this.valor = valor;
    }
		
}