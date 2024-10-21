package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Animal;
import com.example.demo.repositories.AnimalRepository;

@Service
public class AnimalService {
   
    @Autowired
    private final AnimalRepository animalrepository;
	private Optional<Animal> animalOptional;
    @Autowired
    public AnimalService(AnimalRepository animalrepository) {
        this.animalrepository = animalrepository;
    }
   
    public Animal saveAnimal(Animal animal) {
        return animalrepository.save(animal);
       
    }
   
    public Animal getanimalById(Long id) {
        return animalrepository.findById(id).orElse(null);
    }

    public List<Animal> getAllAnimals(){
        return animalrepository.findAll();
    }
   
    public void deleteAnimal(Long id) {
    	animalrepository.deleteById(id);
    }
   
    public Animal updateAnimal(Long id, Animal animalAtualizado) {
    	//criando o optional para receber o animal
    	Optional<Animal> animalOptional = animalrepository.findById(id);
    	if(animalOptional.isPresent()) {
    		//se encontrou
    		Animal animalExistente = animalOptional.get();
    		animalExistente.setName(animalAtualizado.getName());
    		animalExistente.setIdade(animalAtualizado.getIdade());
    		return animalrepository.save(animalExistente);
    	}else {
    		//se não encontrou
    		return null;
    	}
    }
}