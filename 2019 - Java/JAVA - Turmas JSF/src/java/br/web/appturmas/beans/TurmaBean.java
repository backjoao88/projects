/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.appturmas.beans;

import br.web.appturmas.dao.AlunoDAO;
import br.web.appturmas.dao.InstituicaoDAO;
import br.web.appturmas.dao.TurmaDAO;
import br.web.appturmas.dto.Aluno;
import br.web.appturmas.dto.Instituicao;
import br.web.appturmas.dto.Turma;
import com.classes.util.DataUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Matt
 */
@ManagedBean
@SessionScoped
public class TurmaBean {
    
    private Integer codigo;
    private Aluno aluno = new Aluno();
    private Turma turma = new Turma();
    private final String URL = "https://www.urionlinejudge.com.br/judge/en/profile/";
    
    public List<Turma> listar(){
        return new TurmaDAO().listar();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    public void carregaInfoAluno()
    {
        this.aluno = buscarInfoAluno(this.codigo);
    }
    
    public void adicionarAlunoLista()
    {
        turma.getListaAlunos().add(aluno);
        aluno = new Aluno();
        codigo = null;
    }
    
    public String converterDataToString(Date data) {
        return DataUtil.DataForStringPadrao(data);
    }
    
    public void excluirAlunoLinha(int codigoAluno)
    {
        for (int i = 0; i < turma.getListaAlunos().size(); i++) {
            if (turma.getListaAlunos().get(i).getAlunoCodigo() == codigoAluno) {
                turma.getListaAlunos().remove(i);
            }
        }
    }
    
    public String editarTurma(Turma turma){
        this.turma = turma;
        return "turma.xhtml?faces-redirect=true";
    }
    
    public BarChartModel turmaPorScoreGraficoBar(){
        BarChartModel model = new BarChartModel();
        ChartSeries chart = new ChartSeries();
        
        List<Aluno> listaAlunos = new TurmaDAO().listarAlunoTurma(turma);
        
        listaAlunos.forEach((aluno) ->{
            chart.set(aluno.getAlunoNome(), aluno.getAlunoScore());
        });
        
        model.setTitle("Alunos por Score - " + turma.getTurmaNome());
        model.setLegendPosition("ne");
        model.addSeries(chart);
        
        return model;
    }
    
    public PieChartModel turmaPorScoreGraficoPie(){
        PieChartModel model = new PieChartModel();
        ChartSeries chart = new ChartSeries();
        
        List<Aluno> listaAlunos = new TurmaDAO().listarAlunoTurma(turma);
        
        listaAlunos.forEach((aluno) ->{
            model.set(aluno.getAlunoNome(), aluno.getAlunoScore());
        });
        
        model.setTitle("Alunos por Score - " + turma.getTurmaNome());
        model.setLegendPosition("ne");

        return model;
    }

    public Aluno buscarInfoAluno(int codigo)
    {
        try {
            String URLCompleta = URL + "" + codigo;
            Document document = Jsoup.connect(URLCompleta).get();
            Element question = document.getElementById("profile-bar");
            
            String nome = question.firstElementSibling().child(2).text();
            
            String posicao = question.firstElementSibling().child(3).child(0).childNode(2).toString();
            
            int posicaoNumero;
            try {
                posicao = posicao.substring(1, posicao.length() - 2);
                posicao = posicao.replace(",", "");
                posicaoNumero = Integer.parseInt(posicao);
            } catch (Exception e) {
                posicaoNumero = -1;
            }

            String instituicaoNome = question.firstElementSibling().child(3).child(2).child(1).text();
            if (instituicaoNome.equals("")) {
                instituicaoNome = "Sem Instituição";
            }

            String desde = question.firstElementSibling().child(3).child(3).childNode(2).toString();
            desde = formataString(desde);

            String score = question.firstElementSibling().child(3).child(4).childNode(2).toString();
            score = score.substring(1, score.length() - 1);
            score = score.replace(",", "");

            String resolvidos = question.firstElementSibling().child(3).child(5).childNode(2).toString();
            resolvidos = formataString(resolvidos);

            String tentados = question.firstElementSibling().child(3).child(6).childNode(2).toString();
            tentados = formataString(tentados);

            String submetidos = question.firstElementSibling().child(3).child(7).childNode(2).toString();
            submetidos = formataString(submetidos);
            
            Instituicao instituicao = new Instituicao();
            instituicao.setInstituicaoNome(instituicaoNome);
            
            Aluno alunoBuscado = new Aluno();
            alunoBuscado.setAlunoCodigo(codigo);
            alunoBuscado.setAlunoNome(nome);
            alunoBuscado.setAlunoInstituicao(instituicao);
            alunoBuscado.setAlunoDesde(new Date(desde));
            alunoBuscado.setAlunoPosicao((float) posicaoNumero);
            alunoBuscado.setAlunoResolvidos(Integer.parseInt(resolvidos));
            alunoBuscado.setAlunoScore(Float.parseFloat(score));
            alunoBuscado.setAlunoSubmissoes(Integer.parseInt(submetidos));
            alunoBuscado.setAlunoTentados(Integer.parseInt(tentados));
            
            return alunoBuscado;
            
        } catch(IOException | NumberFormatException e) {
            e.getMessage();
        }
        return null;
    }
    
    public static String formataString(String str) 
    {
        if (str != null && str.length() > 0) {
            str = str.substring(1, str.length() - 1);
            str = str.replace(",", "");
            str = str.replace(".", "");
        }
        return str;
    }
    
    public void cadastrar()
    {
        if (turma.getTurmaNome().length() > 0 && turma.getListaAlunos().size() > 0) {
            for (int i = 0; i < turma.getListaAlunos().size(); i++) {
                AlunoDAO alunoDAO = new AlunoDAO();
                InstituicaoDAO instituicaoDAO = new InstituicaoDAO();

                Aluno alunoAtual = turma.getListaAlunos().get(i);
                Instituicao instituicaoAtual = alunoAtual.getAlunoInstituicao();

                // PEGO O ID DA INSTITUICAO
                Instituicao instituicao = instituicaoDAO.verificaExisteByName(instituicaoAtual.getInstituicaoNome());
                if (instituicao.getInstituicaoId() == null) {
                    // INSTITUICAO AINDA NÃO FOI CADASTRADA
                    instituicaoDAO.inserir(instituicaoAtual);
                    instituicao = instituicaoDAO.verificaExisteByName(instituicaoAtual.getInstituicaoNome());
                }
                alunoAtual.getAlunoInstituicao().setInstituicaoId(instituicao.getInstituicaoId());

                // PEGO O ID DO ALUNO
                Aluno alunoBuscado = alunoDAO.verificaExisteByCodigo(alunoAtual.getAlunoCodigo());
                if (alunoBuscado == null) {
                    // ALUNO AINDA NÃO FOI CADASTRADO
                    alunoDAO.inserir(alunoAtual);
                    alunoBuscado = alunoDAO.verificaExisteByCodigo(alunoAtual.getAlunoCodigo());
                }

                // SETO OS ID DE ALUNO E INSTITUICAO CRIADOS
                turma.getListaAlunos().get(i).setAlunoId(alunoBuscado.getAlunoId());
                turma.getListaAlunos().get(i).getAlunoInstituicao().setInstituicaoId(instituicao.getInstituicaoId());
            }

            // DEPOIS DE CADASTRAR OS ALUNOS E AS INSTITUICOES CADASTRA A TURMA
            TurmaDAO turmaDAO = new TurmaDAO();
            turmaDAO.inserir(turma);
            turma.setTurmaNome("");
            turma.setListaAlunos(null);
        }
    }
}