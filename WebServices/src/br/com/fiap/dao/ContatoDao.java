package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.bean.Contato;

public interface ContatoDao {
    
    public String save(Contato contato);
    public String removeRecord(Contato contato);
    public Contato getContato(Contato contato);
    public List<Contato> list();  
   
}