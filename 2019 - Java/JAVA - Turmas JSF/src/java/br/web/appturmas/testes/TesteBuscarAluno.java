/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.appturmas.testes;

import br.web.appturmas.beans.TurmaBean;

/**
 *
 * @author Matt
 */
public class TesteBuscarAluno {
    
    public static void main(String[] args) {
        
        TurmaBean t = new TurmaBean();
        System.out.println(t.buscarInfoAluno(34355));
    }
}