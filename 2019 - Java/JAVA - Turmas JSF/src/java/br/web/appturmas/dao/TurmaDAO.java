/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.appturmas.dao;

import br.web.appturmas.conexao.Conexao;
import br.web.appturmas.dto.Aluno;
import br.web.appturmas.dto.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matt
 */
public class TurmaDAO implements GenericDAO<Turma> {

    @Override
    public boolean inserir(Turma elemento) {
                Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = Conexao.conectar();
            String sql = "INSERT INTO TURMA(nome) VALUES (?)";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, elemento.getTurmaNome());

            stmt.executeUpdate();
            
            Turma turma = listarUltimaTurmaInserida();
            
            for(Aluno k : elemento.getListaAlunos()){
               try {
                    String sql2 = "INSERT INTO TURMAALUNO VALUES(?, ?);";
                    stmt = conn.prepareStatement(sql2);
                    stmt.setInt(1, turma.getTurmaId());
                    stmt.setInt(2, k.getAlunoId());
                    
                    stmt.executeUpdate();
                   
                } catch (SQLException ex) {
                    Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            }
            
            elemento.getListaAlunos().forEach((a) ->{

            });
            return true;

        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizar(Turma elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(Turma elemento) {
        Connection conn = null;
        PreparedStatement stmt = null; 
        try{   
            
            conn = Conexao.conectar();
            String sql = "DELETE FROM TURMA WHERE IDTURMA = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, elemento.getTurmaId());
            
                        
            for(Aluno k : elemento.getListaAlunos()){
               try {
                    String sql2 = "DELETE FROM TURMAALUNO WHERE IDALUNO = ?;";
                    stmt = conn.prepareStatement(sql2);
                    stmt.setInt(1, k.getAlunoId());
                    
                    stmt.executeUpdate();
                   
                } catch (SQLException ex) {
                    Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            }
            
            stmt.executeUpdate();
            return true;
            
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return false;
      }

    @Override
    public Turma procurarPorCodigo(Turma elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Turma> listar() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM TURMA";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Turma> turmas = montarLista(rs);
            return turmas;
        } catch (SQLException ex) {
            System.err.println("Erro -> " + ex.getMessage());
        }
        return null;
    }
    
    public List<Aluno> listarAlunoTurma(Turma turma){
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT AL.* FROM TURMA T INNER JOIN TURMAALUNO TA ON T.IDTURMA = TA.IDTURMA INNER JOIN ALUNO AL  ON TA.IDALUNO = AL.IDALUNO WHERE T.IDTURMA = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, turma.getTurmaId());
            ResultSet rs = stmt.executeQuery();
            List<Aluno> alunos = new AlunoDAO().montarLista(rs);
            return alunos;
        } catch (SQLException ex) {
            System.err.println("Erro -> " + ex.getMessage());
        }
        return null;
    }

    private List<Turma> montarLista(ResultSet rs) {
        List<Turma> listObj = new ArrayList<Turma>();
        try {
            while (rs.next()) {
                Turma obj = new Turma();
                obj.setTurmaId(rs.getInt(1));
                obj.setTurmaNome(rs.getString(2));
                Turma turma = new Turma();
                turma.setTurmaId(obj.getTurmaId());
                obj.setListaAlunos(this.listarAlunoTurma(turma));
                
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }
    
    private Turma montarObj(ResultSet rs){
        try{
            Turma obj = new Turma();
            while(rs.next()){
                obj.setTurmaId(rs.getInt(1));
                obj.setTurmaNome(rs.getString(2));
                obj.setListaAlunos(this.listarAlunoTurma(obj));
            }
            return obj;
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    public Turma listarUltimaTurmaInserida(){
        Connection conn = Conexao.conectar();
        String sql = "select * from turma t order by t.idTurma desc limit 1";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);        
            ResultSet rs = stmt.executeQuery();
            Turma turma = montarObj(rs);
            return turma;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    } 
    
}