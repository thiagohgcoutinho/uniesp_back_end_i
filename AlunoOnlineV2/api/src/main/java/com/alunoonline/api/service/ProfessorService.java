package com.alunoonline.api.service;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.model.Professor;
import com.alunoonline.api.repository.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository repository;

    public Professor create(Professor professor){
        return repository.save(professor);
    }

    public List<Professor> findAll(){
        return repository.findAll();
    }

    public Optional<Professor> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Professor update(Professor professor) {
        if (professor.getNome() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nome não pode ser nulo");
        }
        if (professor.getEmail() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail não pode ser nulo");
        }
        return repository.save(professor);
    }
}
