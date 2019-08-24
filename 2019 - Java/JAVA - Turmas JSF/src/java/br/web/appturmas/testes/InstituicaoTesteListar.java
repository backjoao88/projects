package br.web.appturmas.testes;


import br.web.appturmas.dao.InstituicaoDAO;
import br.web.appturmas.dto.Aluno;
import br.web.appturmas.dto.Instituicao;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Joao
 */
public class InstituicaoTesteListar {
    
    public static void main(String[] args) {
        
        InstituicaoDAO dao = new InstituicaoDAO();
        
        List<Instituicao> insts = dao.listar();
        
        insts.forEach((x) ->{
            System.out.println(x);
        });
        
        Instituicao i = new Instituicao();
        i.setInstituicaoId(2);
        i = dao.procurarPorCodigo(i);
        System.out.println(i);
        
        List<Aluno> al = dao.listarAlunosPorScore(i);
        
        al.forEach((x) ->{
            System.out.println(x);
        });
        

    }
    
}
