package com.example.crudlivros.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudlivros.model.Livro;
import com.example.crudlivros.repository.LivroRepository;

@RestController
@RequestMapping("/api/livros")
public class LivroController {
    
    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    public Livro addLivro(@RequestBody Livro livro) {
        return  livroRepository.save(livro);
    }

    @GetMapping
    public List<Livro> getLivros() {
        return livroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Livro getLivroById(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.orElse(null);
    }

    @PutMapping("/{id}")
    public Livro updateLivro(@PathVariable Long id, @RequestBody Livro livroDetails) {
        Optional<Livro> livroOptional= livroRepository.findById(id);
        if(livroOptional.isPresent()) {
            Livro livro = livroOptional.get();
            livro.setTitulo(livroDetails.getTitulo());
            livro.setAutor(livroDetails.getAutor());
            livro.setAnoPublicacao(livroDetails.getAnoPublicacao());

            return livroRepository.save(livro);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteLivro(@PathVariable Long id){
        livroRepository.deleteById(id);
    }
}
