package br.com.fiap.dao;


import java.util.List;

import br.com.fiap.bean.Contato;

public interface ContatoDao {
    
    public void save(Contato contato);
    public void remove(Contato contato);
    public Contato getContato(String email);
    public List<Contato> list();  
   
}