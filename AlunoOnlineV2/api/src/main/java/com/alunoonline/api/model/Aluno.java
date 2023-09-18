package com.alunoonline.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Identificador de classe como entidade no BD
@Entity
// Criador de GETS e STES
@Data
// Construtores com todos e nenhum argumento
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {

    // Primeira coluna da tabela gerados números automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String curso;
}
