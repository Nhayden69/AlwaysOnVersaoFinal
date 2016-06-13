package redeSocial;

import java.util.ArrayList;

public class RedeSocial {
	
	


	static public ArrayList<Utilizador> utilizadores = new ArrayList<Utilizador>();
	static public ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();

	
	public RedeSocial() {
		
		super();
		
	}


	public void adicionarUtilizador(Utilizador newUtilizadors) {
		this.utilizadores.add(newUtilizadors);
		System.out.println("O Utilizador '" + newUtilizadors.getNome() + "' foi adicionado com sucesso!");
	}
	
	public String procurarUtilizador (String nif) {
		
		for (int i = 0; i < utilizadores.size(); i++) {
			if (utilizadores.get(i).getNumContribuinte().equals(nif))
				return utilizadores.get(i).getNome();
		}
		
		return null;
	}
	
	public ArrayList<Utilizador> listarUtilizadores() {
		
		if (!utilizadores.isEmpty()) {
		
			System.out.println("------Listagem------");
			System.out.println("N.∫ de Utilizadores: " + utilizadores.size() + " Amigos");
			for (Utilizador utilizador : utilizadores) {
				
				System.out.println("ID: " + utilizador.hashCode());
				System.out.println("Nome: " + utilizador.getNome());
				System.out.println("Cidade: " + utilizador.getCidade());
				System.out.println("Estado Civil: " + utilizador.getEstadoCivil());
				System.out.println("Nif: " + utilizador.getNumContribuinte());
				System.out.println("E-mail: " + utilizador.getEmail());
				System.out.println("Password: " + utilizador.getPassword() + "\n\n");
			
				
			}
		
			return utilizadores;
		}
		else
			return null;
	}
	
	public void removerUtilizador(String nifutilizador) {
		
		if (utilizadores.isEmpty()) {
			System.out.println("Não Existem utilizadores!!!");
			return;
		}
		
	
		for (int i = 0; i < utilizadores.size(); i++) {
			if (utilizadores.get(i).getNumContribuinte().equals(nifutilizador))
			{
				this.utilizadores.remove(i);
				System.out.println("Utilizador "+ nifutilizador + " removido");
				return;
			}
		}
	}
	
	public void enviarMensagem (Utilizador queEnvia, String assunto, String texto, Utilizador queRecebe) {
		
		Mensagem m1 = new Mensagem();
		m1.setUtilizadorQueEnvia(queEnvia.getNome());
		m1.setUtilizadorQueRecebe(queRecebe.getNome());
		m1.setAssuntoMensagem(assunto);
		m1.setTextoMensagem(texto);
		mensagens.add(m1);
		System.out.println("A mensagem foi enviada com sucesso!");
	}

	public void listarMensagens() {
		// TODO Auto-generated method stub
		
		System.out.println("--- Listagem de Mensagens ---");
		
		for (Mensagem m : mensagens) {
			System.out.println("Enviado por '"+m.getUtilizadorQueEnvia()+"'");
			System.out.println("Para '"+m.getUtilizadorQueRecebe()+"'");
			System.out.println("Assunto: '"+m.getAssuntoMensagem()+"'");
			System.out.println("Texto:\n\t'"+m.getTextoMensagem()+"'\n\n");
		}
		
	}
	
	
	public ArrayList<Utilizador> getUtilizadors() {
		return this.utilizadores;
	}
	
	
	public static ArrayList<Mensagem> getMensagens() {
		return mensagens;
	}


	public static void setMensagens(ArrayList<Mensagem> mensagens) {
		RedeSocial.mensagens = mensagens;
	}
}