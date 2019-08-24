/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.appturmas.dao;

import br.web.appturmas.conexao.Conexao;
import br.web.appturmas.dto.Aluno;
import br.web.appturmas.dto.Instituicao;
import com.classes.util.DataUtil;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joao
 */
public class InstituicaoDAO implements GenericDAO<Instituicao> {

    @Override
    public boolean inserir(Instituicao elemento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            
            conn = Conexao.conectar();
            String sql = "INSERT INTO INSTITUICAO (nome) VALUES (?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, elemento.getInstituicaoNome());
            stmt.executeUpdate();
            return true;
            
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizar(Instituicao elemento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = Conexao.conectar();
            String sql = "UPDATE INSTITUICAO SET nome = ? WHERE idInstituicao = ?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, elemento.getInstituicaoNome());
            stmt.setInt(2, elemento.getInstituicaoId());
            
            stmt.executeUpdate();
            
            return true;

        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deletar(Instituicao elemento) {
        Connection conn = null;
        PreparedStatement stmt = null; 
        try{   
            
            conn = Conexao.conectar();
            String sql = "DELETE FROM INSTITUICAO WHERE IDINSTITUICAO = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, elemento.getInstituicaoId());
            stmt.executeUpdate();
            return true;
            
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return false;
   
    }

    public List<Aluno> listarAlunosPorScore(Instituicao instituicao) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM ALUNO AL WHERE AL.IDINSTITUICAO = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, instituicao.getInstituicaoId());
            ResultSet rs = stmt.executeQuery();
            List<Aluno> alunos = new AlunoDAO().montarLista(rs);
            return alunos;
        } catch (SQLException ex) {
            Logger.getLogger(InstituicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Instituicao> listar() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM INSTITUICAO";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Instituicao> instituicoes = montarLista(rs);
            return instituicoes;
        } catch (SQLException ex) {
            Logger.getLogger(InstituicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Instituicao> montarLista(ResultSet rs) {
    List<Instituicao> listObj = new ArrayList<Instituicao>();
        try {
            while (rs.next()) {
                Instituicao obj = new Instituicao();
                obj.setInstituicaoId(rs.getInt(1));
                obj.setInstituicaoNome(rs.getString(2));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Instituicao procurarPorCodigo(Instituicao elemento) {
        Connection conn = Conexao.conectar();
        String sql = "SELECT * FROM INSTITUICAO WHERE IDINSTITUICAO = ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);        
            stmt.setInt(1, elemento.getInstituicaoId());
            ResultSet rsInstituicao = stmt.executeQuery();
            Instituicao i = new Instituicao();
            while (rsInstituicao.next()) {
                i.setInstituicaoId(rsInstituicao.getInt(1));
                i.setInstituicaoNome(rsInstituicao.getString(2));
            }
            return i;
        } catch (SQLException ex) {
            Logger.getLogger(InstituicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Instituicao verificaExisteByName(String nome) {
        Connection conn = Conexao.conectar();
        String sql = "SELECT * FROM INSTITUICAO WHERE NOME LIKE ?";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);        
            stmt.setString(1, "%" + nome + "%");
            ResultSet rsInstituicao = stmt.executeQuery();
            Instituicao i = new Instituicao();
            while (rsInstituicao.next()) {
                i.setInstituicaoId(rsInstituicao.getInt(1));
                i.setInstituicaoNome(rsInstituicao.getString(2));
            }
            return i;
        } catch (SQLException ex) {
            Logger.getLogger(InstituicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
