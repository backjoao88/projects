package br.web.appturmas.junit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.web.appturmas.dao.InstituicaoDAO;
import br.web.appturmas.dto.Instituicao;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Joao
 */
public class InstituicaoTestCase extends TestCase{
    
    @Test
    public void testExecutouUpdateInserirInstituicao(){
        Instituicao i = new Instituicao();
        
        i.setInstituicaoId(1);
        i.setInstituicaoNome("a1");

        InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
        
        boolean inseriu = instituicaoDAO.inserir(i);
        
        assertEquals(true, inseriu);
    }
    
    @Test
    public void testExecutouUpdateUpdateInstituicao(){
        Instituicao i = new Instituicao();
        
        i.setInstituicaoId(2);
        i.setInstituicaoNome("aaa1");

        InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
        
        boolean inseriu = instituicaoDAO.atualizar(i);
        
        assertEquals(true, inseriu);
    }
    
    @Test
    public void testExecutouUpdateDeletarInstituicao(){
        Instituicao i = new Instituicao();
        
        i.setInstituicaoId(5);

        InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
        
        boolean inseriu = instituicaoDAO.deletar(i);
        
        assertEquals(true, inseriu);
    }
    
        
   
}
