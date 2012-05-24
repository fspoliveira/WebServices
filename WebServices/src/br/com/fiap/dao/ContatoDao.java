package br.com.fiap.dao;


import java.util.HashSet;
import java.util.List;

import br.com.fiap.bean.Contato;

public interface ContatoDao {
    
    public String save(Contato contato);
    public String removeRecord(String email);
    public Contato getContato(String email);
    public List<Contato> list();  
   
}