/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.appturmas.testes;

import br.web.appturmas.dao.AlunoDAO;

/**
 *
 * @author Joao
 */
public class AlunoTesteListar {
    
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.listar().forEach((x) ->{
            System.out.println(x);
        });
    }
    
}
