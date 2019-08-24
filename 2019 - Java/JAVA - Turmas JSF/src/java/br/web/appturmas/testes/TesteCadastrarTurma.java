/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.appturmas.testes;

import br.web.appturmas.beans.TurmaBean;
import br.web.appturmas.dao.AlunoDAO;
import br.web.appturmas.dao.InstituicaoDAO;
import br.web.appturmas.dao.TurmaDAO;
import br.web.appturmas.dto.Aluno;
import br.web.appturmas.dto.Instituicao;
import br.web.appturmas.dto.Turma;

/**
 *
 * @author Matt
 */
public class TesteCadastrarTurma {
    
    public static Turma turma = new Turma();
    
    public static void main(String[] args) {
        
        TurmaBean t = new TurmaBean();
        
        turma.setTurmaNome("Turma 01");
        
        Aluno aluno = new Aluno();
        aluno = t.buscarInfoAluno(123);
        turma.getListaAlunos().add(aluno);
        
        aluno = new Aluno();
        aluno = t.buscarInfoAluno(456);
        turma.getListaAlunos().add(aluno);
        
        aluno = new Aluno();
        aluno = t.buscarInfoAluno(4044);
        turma.getListaAlunos().add(aluno);
        
        cadastrar();
        
    }
    
    public static void cadastrar()
    {
        System.out.println("cadastrar...");
        if (turma.getTurmaNome().length() > 0 && turma.getListaAlunos().size() > 0) {
            for (int i = 0; i < turma.getListaAlunos().size(); i++) {
                System.out.println("Aluno " + (i+1));
                AlunoDAO alunoDAO = new AlunoDAO();
                InstituicaoDAO instituicaoDAO = new InstituicaoDAO();

                Aluno alunoAtual = turma.getListaAlunos().get(i);
                Instituicao instituicaoAtual = alunoAtual.getAlunoInstituicao();

                // PEGO O ID DA INSTITUICAO
                Instituicao instituicao = instituicaoDAO.verificaExisteByName(instituicaoAtual.getInstituicaoNome());
                if (instituicao.getInstituicaoId() == null) {
                    System.out.println("entrou para inserir instituicao...");
                    // INSTITUICAO AINDA NÃO FOI CADASTRADA
                    instituicaoDAO.inserir(instituicaoAtual);
                    instituicao = instituicaoDAO.verificaExisteByName(instituicaoAtual.getInstituicaoNome());
                }
                alunoAtual.getAlunoInstituicao().setInstituicaoId(instituicao.getInstituicaoId());

                System.out.println("Instituição: " + instituicao.toString());
                System.out.println("Aluno: " + alunoAtual.toString());
                // PEGO O ID DO ALUNO
                System.out.println("codigo aluno = " + alunoAtual.getAlunoCodigo());
                Aluno aluno = alunoDAO.verificaExisteByCodigo(alunoAtual.getAlunoCodigo());
                System.out.println("idaluno = " + aluno.toString());
                if (aluno == null) {
                    System.out.println("tentou cadastrar aluno...");
                    // ALUNO AINDA NÃO FOI CADASTRADO
                    alunoDAO.inserir(alunoAtual);
                    aluno = alunoDAO.verificaExisteByCodigo(alunoAtual.getAlunoCodigo());
                }

                // SETO OS ID DE ALUNO E INSTITUICAO CRIADOS
                turma.getListaAlunos().get(i).setAlunoId(aluno.getAlunoId());
                turma.getListaAlunos().get(i).getAlunoInstituicao().setInstituicaoId(instituicao.getInstituicaoId());
            }

            // DEPOIS DE CADASTRAR OS ALUNOS E AS INSTITUICOES CADASTRA A TURMA
            TurmaDAO turmaDAO = new TurmaDAO();
            turmaDAO.inserir(turma);
        }
    }
}
