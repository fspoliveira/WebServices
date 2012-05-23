package br.com.fiap.bean;

public class Contato {
	
	private String email;
	private String nome;
	private String telefone;
	private String endereco;
	private String cidade;
	private String estado;
	private String pais;
	
	public Contato(){
		
	}
		
	public Contato(String email, String nome, String telefone, String endereco,
			String cidade, String estado, String pais) {
		super();
		this.email = email;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
}