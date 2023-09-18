package com.alunoonline.api.controller;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Identificação da classe Controller no Spring com a arquitetura REST
@RestController
// Mapeamento das requisições do FrontEnd
@RequestMapping("/aluno")
public class AlunoController {

    // Injeção dos métodos dos service
    @Autowired
    AlunoService service;

    // Requisição do tipo POST
    @PostMapping
    // Resposta da requisição
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno) {
        Aluno alunoCreated = service.create(aluno);

        return ResponseEntity.status(201).body(alunoCreated);
    }

}
