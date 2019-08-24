/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.appturmas.testes;

import br.web.appturmas.dao.AlunoDAO;
import br.web.appturmas.dto.Aluno;

/**
 *
 * @author Matt
 */
public class TesteBuscarAlunoByCodigo {
    
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();
        Aluno aluno = alunoDAO.verificaExisteByCodigo(123);
        System.out.println(aluno);
    }
}
