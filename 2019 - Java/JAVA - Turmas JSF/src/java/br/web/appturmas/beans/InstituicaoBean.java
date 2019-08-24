/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.appturmas.beans;

import br.web.appturmas.dao.AlunoDAO;
import br.web.appturmas.dao.InstituicaoDAO;
import br.web.appturmas.dto.Aluno;
import br.web.appturmas.dto.Instituicao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Joao
 */
@ManagedBean
@SessionScoped
public class InstituicaoBean {
    
    private Instituicao instituicao;

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
    
    public String editarInstituicao(Instituicao instituicao){
        this.instituicao = instituicao;
        return "instituicao.xhtml?faces-redirect=true";
    }
    
    public PieChartModel alunoPorScoreGraficoPie(){
        PieChartModel model = new PieChartModel();
        ChartSeries chart = new ChartSeries();
        
        List<Aluno> listaAlunos = new InstituicaoDAO().listarAlunosPorScore(instituicao);
        
        listaAlunos.forEach((aluno) ->{
            model.set(aluno.getAlunoNome(), aluno.getAlunoScore());
        });
        
        model.setTitle("Alunos por Score - " + instituicao.getInstituicaoNome());
        model.setLegendPosition("ne");

        return model;
    }
    
    public BarChartModel alunoPorScoreGraficoBar(){
        BarChartModel model = new BarChartModel();
        ChartSeries chart = new ChartSeries();
        
        List<Aluno> listaAlunos = new InstituicaoDAO().listarAlunosPorScore(instituicao);
        
        listaAlunos.forEach((aluno) ->{
            chart.set(aluno.getAlunoNome(), aluno.getAlunoScore());
        });
        
        model.setTitle("Alunos por Score - " + instituicao.getInstituicaoNome());
        model.setLegendPosition("ne");
        model.addSeries(chart);
        
        return model;
    }
   
    
    public List<Instituicao> listar(){
       InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
       return instituicaoDAO.listar();
    }
    
}
