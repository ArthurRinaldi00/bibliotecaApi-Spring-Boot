package br.gov.sp.fatec.frases.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;


import br.gov.sp.fatec.frases.entity.Livro;
import br.gov.sp.fatec.frases.service.LivroService;


import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping(value = "/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    @JsonView(View.LivroComum.class)
    public List<Livro> buscarTodosLivros() {
        return livroService.buscarTodosLivros();
    }

    @PostMapping
    @JsonView(View.LivroCompleto.class)
    public Livro novoLivro(@RequestBody Livro livro){
        return livroService.novoLivro(livro.getTitulo(), livro.getIsbn(), "nome teste");
    }
}