/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.appturmas.beans;

import br.web.appturmas.dao.AlunoDAO;
import br.web.appturmas.dto.Aluno;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Joao
 */
@ManagedBean
@SessionScoped
public class AlunoBean {
    
    private Aluno aluno;

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public String editarAluno(Aluno aluno){
        this.aluno = aluno;
        return "aluno.xhtml?faces-redirect=true";
    }
    
    public List<Aluno> listar(){
       AlunoDAO alunoDAO = new AlunoDAO();
       return alunoDAO.listar();
    }
    
}
