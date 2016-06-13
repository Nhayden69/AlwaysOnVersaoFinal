package redeSocial;

import java.util.HashSet;

public class Utilizador {
	
	private String cidade = "";
	private String nome = "";
	private String email = "";
	private String estadoCivil = "";
	private String numContribuinte = "";
	private String password = "";

	public HashSet<Mensagem> mensagenss = new HashSet<Mensagem>();

	public Utilizador() {
		
		super();

	}
	
	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String newCidade) {
		this.cidade = newCidade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String newNome) {
		this.nome = newNome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String newEstadoCivil) {
		this.estadoCivil = newEstadoCivil;
	}

	public String getNumContribuinte() {
		return this.numContribuinte;
	}

	public void setNumContribuinte(String newNumContribuinte) {
		this.numContribuinte = newNumContribuinte;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public HashSet<Mensagem> getMensagenss() {
		return this.mensagenss;
	}

	public void setMensagenss(HashSet<Mensagem> newMensagenss) {
		this.mensagenss = newMensagenss;
	}
	
	
	

}
