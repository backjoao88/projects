/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.appturmas.dao;

import java.util.List;

/**
 *
 * @author Joao
 */
public interface GenericDAO<T> {
    
    public boolean inserir(T elemento);
    public boolean atualizar(T elemento);
    public boolean deletar(T elemento);
    public T procurarPorCodigo(T elemento);
    public List<T> listar();
    
}
