/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.appturmas.dto;

/**
 *
 * @author Joao
 */
public class Instituicao {
    
    private Integer instituicaoId;
    private String  instituicaoNome;

    public Integer getInstituicaoId() {
        return instituicaoId;
    }

    public void setInstituicaoId(Integer instituicaoId) {
        this.instituicaoId = instituicaoId;
    }

    public String getInstituicaoNome() {
        return instituicaoNome;
    }

    public void setInstituicaoNome(String instituicaoNome) {
        this.instituicaoNome = instituicaoNome;
    }

    @Override
    public String toString() {
        return "Instituicao{" 
                + "instituicaoId=" 
                + instituicaoId + ", instituicaoNome=" 
                + instituicaoNome + '}';
    }  
}
