package com.prueba2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.prueba2.models.Persona;
import com.prueba2.repositories.IPersonaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private IPersonaRepository personaRepository;


    public Persona createPersona(Persona persona) {
        return personaRepository.save(persona);
    }


    public List<Persona> getAllPersonas() {
        try {
            return personaRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Can not retrieve all personas ", e);
        }
    }


    public Optional<Persona> getPersonaById(Long id) {
        try {
            return personaRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Can not retrieve that persona", e);
        }
    }


    public Persona updatePersona(Persona updatedPersona) {
        Optional<Persona> existingPersona = personaRepository.findById(updatedPersona.getId());
        if (existingPersona.isPresent()) {
            Persona persona = existingPersona.get();
            persona.setName(updatedPersona.getName());
            persona.setSurname(updatedPersona.getSurname());
            persona.setEmail(updatedPersona.getEmail());
            persona.setAge(updatedPersona.getAge());
            persona.setDOB(updatedPersona.getDOB());
            persona.setAddress(updatedPersona.getAddress());
            return personaRepository.save(persona);
        }
        return null;
    }


    public void deletePersonaById(Long id) {
        personaRepository.deleteById(id);
    }


    public void deleteAllPersonas() {
        personaRepository.deleteAll();
    }
}

