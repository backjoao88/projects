package br.web.appturmas.junit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.web.appturmas.dao.AlunoDAO;
import br.web.appturmas.dao.InstituicaoDAO;
import br.web.appturmas.dto.Aluno;
import br.web.appturmas.dto.Instituicao;
import java.util.Date;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Joao
 */
public class AlunoTestCase extends TestCase {
    
    @Test
    public void testExecutouUpdateInserirAluno(){
        Aluno aluno = new Aluno();
        
        aluno.setAlunoCodigo(1000);
        aluno.setAlunoNome("João");
        aluno.setAlunoScore((float)1);
        aluno.setAlunoSubmissoes(1);
        aluno.setAlunoPosicao((float)12.3);
        aluno.setAlunoDesde(new Date());
        aluno.setAlunoResolvidos(1);
        aluno.setAlunoTentados(1);
        
        Instituicao instituicao = new Instituicao();
        
        instituicao.setInstituicaoId(1);
        
        aluno.setAlunoInstituicao(instituicao);
        AlunoDAO alunoDAO = new AlunoDAO();
        
        boolean certo = alunoDAO.inserir(aluno);
        
        assertEquals(true, certo);
    }
    
    @Test
    public void testExecutouUpdateDeleteAluno(){
        Aluno aluno = new Aluno();
        
        aluno.setAlunoId(1);
        AlunoDAO alunoDAO = new AlunoDAO();
        boolean certo = alunoDAO.deletar(aluno);
        
        assertEquals(true, certo);
        
    }
    
    @Test
    public void testExecutouUpdateAtualizarAluno(){
        Aluno aluno = new Aluno();
        
        aluno.setAlunoId(5);
        aluno.setAlunoNome("oloko");
        aluno.setAlunoCodigo(1001);
        aluno.setAlunoScore((float) 1);
        aluno.setAlunoSubmissoes(1);
        aluno.setAlunoPosicao((float) 1);
        aluno.setAlunoDesde(new Date());
        aluno.setAlunoResolvidos(1);
        aluno.setAlunoTentados(1);
        
        Instituicao inst = new Instituicao();
        inst.setInstituicaoId(1);

        Instituicao instituicao = new InstituicaoDAO().procurarPorCodigo(inst);
        aluno.setAlunoInstituicao(instituicao);
        AlunoDAO alunoDAO = new AlunoDAO();
        boolean certo = alunoDAO.atualizar(aluno);
        
        assertEquals(true, certo);
        
    }
    
}
