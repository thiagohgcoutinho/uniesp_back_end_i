package com.alunoonline.api.service;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
     public Aluno update(Long id, Aluno aluno){
        Aluno alunoUpdated = repository.findById(id).get();
        if (aluno.getNome() != null) {
            alunoUpdated.setNome(aluno.getNome());
        }
        if (aluno.getCurso() != null) {
            alunoUpdated.setCurso(aluno.getCurso());
        }
        if (aluno.getEmail() != null) {
            alunoUpdated.setEmail(aluno.getEmail());
        }
        return repository.save(alunoUpdated);
    }

    public Aluno update2(Aluno aluno) {

        if (aluno.getNome() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não pode ser nulo");
        }

        if (aluno.getEmail() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não pode ser nulo");
        }

        if (aluno.getCurso() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não pode ser nulo");
        }

        return repository.save(aluno);
    }
}
