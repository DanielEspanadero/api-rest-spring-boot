package com.api.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rest.models.Persona;

public interface PersonaDAO extends JpaRepository<Persona, Integer> {

}
