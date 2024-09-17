package com.prueba2.repositories;

import com.prueba2.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepository extends JpaRepository <Persona, Long> {
}
