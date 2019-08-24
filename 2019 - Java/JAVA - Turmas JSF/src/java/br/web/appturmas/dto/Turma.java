/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.appturmas.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matt
 */
public class Turma {
    
    private Integer turmaId;
    private String turmaNome;
    private List<Aluno> listaAlunos = new ArrayList<>();

    public Integer getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Integer turmaId) {
        this.turmaId = turmaId;
    }

    public String getTurmaNome() {
        return turmaNome;
    }

    public void setTurmaNome(String turmaNome) {
        this.turmaNome = turmaNome;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    @Override
    public String toString() {
        return "Turma{" 
                + "turmaId=" + turmaId 
                + ", turmaNome=" + turmaNome 
                + ", listaAlunos=" + listaAlunos 
                + '}';
    }
}