package br.web.appturmas.junit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.web.appturmas.dao.AlunoDAO;
import br.web.appturmas.dao.InstituicaoDAO;
import br.web.appturmas.dao.TurmaDAO;
import br.web.appturmas.dto.Aluno;
import br.web.appturmas.dto.Instituicao;
import br.web.appturmas.dto.Turma;
import java.util.Date;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Joao
 */
public class TurmaTestCase extends TestCase {
    
    @Test
    public void testExecutouUpdateInserirTurma(){
        
        Turma turma = new Turma();
        
       Turma turma2 = new Turma();
       turma2.setTurmaId(1);
       
       turma.setListaAlunos(new TurmaDAO().listarAlunoTurma(turma2));
       turma.setTurmaNome("teste");
       
       boolean certo = new TurmaDAO().inserir(turma);
       
        assertEquals(true, certo);
       
    }
    
    @Test
    public void testExecutouUpdateAtualizarTurma(){

    }
    
    @Test
    public void testExecutouUpdateDeletarTurma(){

        Turma turma = new Turma();
        
        turma.setTurmaId(1);
        TurmaDAO turmaDAO = new TurmaDAO();
        boolean certo = turmaDAO.deletar(turma);
        
        assertEquals(true, certo);
        
    }
    
}
