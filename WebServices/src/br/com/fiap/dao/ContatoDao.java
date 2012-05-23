package br.com.fiap.dao;


import java.util.List;

import br.com.fiap.bean.Contato;

public interface ContatoDao {
    
    public String save(Contato contato);
    public String remove(Contato contato);
    public Contato getContato(String email);
   //public List<Contato> list();  
   
}