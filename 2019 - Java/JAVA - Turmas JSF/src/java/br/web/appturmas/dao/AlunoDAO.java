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
 * @author Joao
 */
public class AlunoDAO implements GenericDAO<Aluno>{

    @Override
    public boolean inserir(Aluno elemento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = Conexao.conectar();
            String sql = "INSERT INTO ALUNO (codigo, nome, score, posicao, desde, resolvidos, tentados, "
                    + "submissoes, idInstituicao) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, elemento.getAlunoCodigo());
            stmt.setString(2, elemento.getAlunoNome());
            stmt.setFloat(3, elemento.getAlunoScore());
            stmt.setFloat(4, elemento.getAlunoPosicao());
            stmt.setString(5, DataUtil.DataHoraForStringMySQL(elemento.getAlunoDesde()));
            stmt.setInt(6, elemento.getAlunoResolvidos());
            stmt.setInt(7, elemento.getAlunoTentados());
            stmt.setInt(8, elemento.getAlunoSubmissoes());
            stmt.setInt(9, elemento.getAlunoInstituicao().getInstituicaoId());
            
            stmt.executeUpdate();
            
            return true;

        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean atualizar(Aluno elemento) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = Conexao.conectar();
            String sql = "UPDATE ALUNO SET codigo = ?, nome = ?, score = ?, posicao = ?, desde = ?,"
                    + "resolvidos = ?, tentados = ?, submissoes = ?, idInstituicao = ? WHERE idAluno = ?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, elemento.getAlunoCodigo());
            stmt.setString(2, elemento.getAlunoNome());
            stmt.setFloat(3, elemento.getAlunoScore());
            stmt.setFloat(4, elemento.getAlunoPosicao());
            stmt.setString(5, DataUtil.DataHoraForStringMySQL(elemento.getAlunoDesde()));
            stmt.setInt(6, elemento.getAlunoResolvidos());
            stmt.setInt(7, elemento.getAlunoTentados());
            stmt.setInt(8, elemento.getAlunoSubmissoes());
            stmt.setInt(9, elemento.getAlunoInstituicao().getInstituicaoId());
            stmt.setInt(10, elemento.getAlunoId());
            
            stmt.executeUpdate();
            
            return true;

        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return false;
        
    }

    @Override
    public boolean deletar(Aluno elemento) {       
        Connection conn = null;
        PreparedStatement stmt = null; 
        try{   
            
            conn = Conexao.conectar();
            String sql = "DELETE FROM ALUNO WHERE IDALUNO = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, elemento.getAlunoId());
            stmt.executeUpdate();
            return true;
            
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return false;
   
    }

    @Override
    public List<Aluno> listar() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM ALUNO";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Aluno> alunos = montarLista(rs);
            return alunos;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
    public List<Aluno> montarLista(ResultSet rs) {
    List<Aluno> listObj = new ArrayList<Aluno>();
        try {
            while (rs.next()) {
                Aluno obj = new Aluno();
                obj.setAlunoId(rs.getInt(1));
                obj.setAlunoCodigo(rs.getInt(2));
                obj.setAlunoNome(rs.getString(3));
                obj.setAlunoScore(rs.getFloat(4));
                obj.setAlunoPosicao(rs.getFloat(5));
                obj.setAlunoDesde(rs.getDate(6));
                obj.setAlunoResolvidos(rs.getInt(7));
                obj.setAlunoTentados(rs.getInt(8));
                obj.setAlunoSubmissoes(rs.getInt(9));
                
                InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
                Instituicao instituicao = new Instituicao();
                instituicao.setInstituicaoId(rs.getInt(10));
                instituicao = instituicaoDAO.procurarPorCodigo(instituicao);
                
                obj.setAlunoInstituicao(instituicao);
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
    public Aluno procurarPorCodigo(Aluno elemento) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM ALUNO WHERE IDALUNO = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, elemento.getAlunoId());
            ResultSet rs = stmt.executeQuery();
            
            Aluno aluno = new Aluno();
            aluno.setAlunoId(rs.getInt(1));
            aluno.setAlunoCodigo(rs.getInt(2));
            aluno.setAlunoNome(rs.getString(3));
            aluno.setAlunoScore(rs.getFloat(4));
            aluno.setAlunoPosicao(rs.getFloat(5));
            aluno.setAlunoDesde(rs.getDate(6));
            aluno.setAlunoResolvidos(rs.getInt(7));
            aluno.setAlunoTentados(rs.getInt(8));
            aluno.setAlunoSubmissoes(rs.getInt(9));
            
            return aluno;
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Aluno verificaExisteByCodigo(int codigo) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM ALUNO WHERE CODIGO = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            
            // NÃO REMOVER O PRINT, POR ALGUM MOTIVO GERA ERRO SEM ESSE PRINT !!
            System.out.println(rs.first());
            
            try {
                Aluno aluno = new Aluno();
                aluno.setAlunoId(rs.getInt(1));
                aluno.setAlunoCodigo(rs.getInt(2));
                aluno.setAlunoNome(rs.getString(3));
                aluno.setAlunoScore(rs.getFloat(4));
                aluno.setAlunoPosicao(rs.getFloat(5));
                aluno.setAlunoDesde(rs.getDate(6));
                aluno.setAlunoResolvidos(rs.getInt(7));
                aluno.setAlunoTentados(rs.getInt(8));
                aluno.setAlunoSubmissoes(rs.getInt(9));

                return aluno;
            } catch (Exception e) {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
