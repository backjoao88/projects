/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.appturmas.dto;

import java.util.Date;

/**
 *
 * @author Joao
 */
public class Aluno {
    
    private Integer alunoId;
    private Integer alunoCodigo;
    private String  alunoNome;
    private Float   alunoScore;
    private Float alunoPosicao;
    private Date    alunoDesde;
    private Integer alunoResolvidos;
    private Integer alunoTentados;
    private Integer alunoSubmissoes;
    private Instituicao alunoInstituicao;

    public Integer getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Integer alunoId) {
        this.alunoId = alunoId;
    }

    public Integer getAlunoCodigo() {
        return alunoCodigo;
    }

    public void setAlunoCodigo(Integer alunoCodigo) {
        this.alunoCodigo = alunoCodigo;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public Float getAlunoScore() {
        return alunoScore;
    }

    public void setAlunoScore(Float alunoScore) {
        this.alunoScore = alunoScore;
    }

    public Float getAlunoPosicao() {
        return alunoPosicao;
    }

    public void setAlunoPosicao(Float alunoPosicao) {
        this.alunoPosicao = alunoPosicao;
    }

    public Date getAlunoDesde() {
        return alunoDesde;
    }

    public void setAlunoDesde(Date alunoDesde) {
        this.alunoDesde = alunoDesde;
    }

    public Integer getAlunoResolvidos() {
        return alunoResolvidos;
    }

    public void setAlunoResolvidos(Integer alunoResolvidos) {
        this.alunoResolvidos = alunoResolvidos;
    }

    public Integer getAlunoTentados() {
        return alunoTentados;
    }

    public void setAlunoTentados(Integer alunoTentados) {
        this.alunoTentados = alunoTentados;
    }

    public Integer getAlunoSubmissoes() {
        return alunoSubmissoes;
    }

    public void setAlunoSubmissoes(Integer alunoSubmissoes) {
        this.alunoSubmissoes = alunoSubmissoes;
    }

    public Instituicao getAlunoInstituicao() {
        return alunoInstituicao;
    }

    public void setAlunoInstituicao(Instituicao alunoInstituicao) {
        this.alunoInstituicao = alunoInstituicao;
    }

    @Override
    public String toString() {
        return "Aluno{" 
                + "alunoId=" 
                + alunoId 
                + ", alunoCodigo=" 
                + alunoCodigo 
                + ", alunoNome=" 
                + alunoNome 
                + ", alunoScore=" 
                + alunoScore + ", alunoPosicao=" 
                + alunoPosicao + ", alunoDesde=" 
                + alunoDesde + ", alunoResolvidos=" 
                + alunoResolvidos + ", alunoTentados=" 
                + alunoTentados + ", alunoSubmissoes=" 
                + alunoSubmissoes + ", alunoInstituicao=" 
                + alunoInstituicao 
                + '}';
    }
    
    
    
}
