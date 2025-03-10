package com.example.crudlivros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudlivros.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
