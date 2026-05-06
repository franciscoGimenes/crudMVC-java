package com.example.crudmvc.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
    void deveCriarAlunoComConstrutor() {
        Aluno aluno = new Aluno("Ana", "ana@email.com", "Java");

        assertEquals("Ana", aluno.getNome());
        assertEquals("ana@email.com", aluno.getEmail());
        assertEquals("Java", aluno.getCurso());
    }

    @Test
    void deveAlterarDadosDoAluno() {
        Aluno aluno = new Aluno();

        aluno.setId(1L);
        aluno.setNome("Carlos");
        aluno.setEmail("carlos@email.com");
        aluno.setCurso("Spring Boot");

        assertEquals(1L, aluno.getId());
        assertEquals("Carlos", aluno.getNome());
        assertEquals("carlos@email.com", aluno.getEmail());
        assertEquals("Spring Boot", aluno.getCurso());
    }
}