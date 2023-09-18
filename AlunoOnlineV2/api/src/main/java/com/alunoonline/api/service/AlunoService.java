package com.alunoonline.api.service;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Identificação do Service do Spring
@Service
public class AlunoService {

    // Injeção dos métodos do repository
    @Autowired
    AlunoRepository repository;
    
    public Aluno create(Aluno aluno){
        return repository.save(aluno);
    }
    
}
