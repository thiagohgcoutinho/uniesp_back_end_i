package com.alunoonline.api.service;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Identificação do Service do Spring
@Service
public class AlunoService {

    // Injeção dos métodos do repository
    @Autowired
    AlunoRepository repository;

    // método para criar aluno
    public Aluno create(Aluno aluno){
        return repository.save(aluno);
    }

    // método para buscar todos os alunos
    public List<Aluno> findAll(){
        return repository.findAll();
    }

    //método para buscar um aluno pelo Id
    public Optional<Aluno> findById(Long id){
        return repository.findById(id);
    }

    // método para deletar um aluno pelo Id
    public void delete(Long id){
        repository.deleteById(id);
    }

    //método para atualizar um aluno pelo Id
    public Aluno update(Long id, Aluno alunoUpdated){
        Aluno aluno = repository.findById(id).get();
        if (alunoUpdated.getNome() != null) {
            aluno.setNome(alunoUpdated.getNome());
        }
        if (alunoUpdated.getCurso() != null) {
            aluno.setCurso(alunoUpdated.getCurso());
        }
        if (alunoUpdated.getEmail() != null) {
            aluno.setEmail(alunoUpdated.getEmail());
        }
        return repository.save(aluno);
    }
}
