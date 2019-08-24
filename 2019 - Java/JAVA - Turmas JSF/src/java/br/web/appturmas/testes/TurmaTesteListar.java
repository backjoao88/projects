/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.appturmas.testes;

import br.web.appturmas.dao.AlunoDAO;
import br.web.appturmas.dao.TurmaDAO;
import br.web.appturmas.dto.Turma;

/**
 *
 * @author Joao
 */
public class TurmaTesteListar {
    
    public static void main(String[] args) {
        TurmaDAO turmaDAO = new TurmaDAO();
        turmaDAO.listar().forEach((x) ->{
            System.out.println(x);
        });
        
        Turma turma = new TurmaDAO().listarUltimaTurmaInserida();
        
        System.out.print(turma);
        
    }
    
}
