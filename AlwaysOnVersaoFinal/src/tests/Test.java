package tests;

import redeSocial.Mensagem;
import redeSocial.RedeSocial;
import redeSocial.TipoRelacao;
import redeSocial.Utilizador;

public class Test {

//	@org.junit.Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	
	
	@org.junit.Test
	public void adicionarUtilizador() {
			
		Utilizador utilizador = new Utilizador();
		utilizador.setNome("Filipa");
		utilizador.setCidade("Coimbra");
		utilizador.setEstadoCivil("Solteira");
		utilizador.setNumContribuinte("23558224");
		utilizador.setEmail("filipa@gmail.pt");
		utilizador.setPassword("123");
		
		RedeSocial rS = new RedeSocial();
		rS.adicionarUtilizador(utilizador);
		
	}
	
	@org.junit.Test
	public void listarUtilizadores() {
		
		Utilizador utilizador = new Utilizador();
		utilizador.setNome("Filipa");
		utilizador.setCidade("Coimbra");
		utilizador.setEstadoCivil("Solteira");
		utilizador.setNumContribuinte("23558224");
		utilizador.setEmail("filipa@gmail.pt");
		utilizador.setPassword("123");
		
		
		Utilizador utilizador1 = new Utilizador();
		utilizador1.setNome("Nuno");
		utilizador1.setCidade("Algarve");
		utilizador1.setEstadoCivil("Viuvo");
		utilizador1.setNumContribuinte("3232130");
		utilizador1.setEmail("nuno@sapo.pt");
		utilizador1.setPassword("333");
		
		RedeSocial rS = new RedeSocial();
		rS.adicionarUtilizador(utilizador);
		rS.adicionarUtilizador(utilizador1);
		rS.listarUtilizadores();
		
	}
	
	
	@org.junit.Test
	public void removerUtilizador() {
		
		Utilizador utilizador = new Utilizador();
		utilizador.setNome("Filipa");
		utilizador.setCidade("Coimbra");
		utilizador.setEstadoCivil("Solteira");
		utilizador.setNumContribuinte("23558224");
		utilizador.setEmail("filipa@gmail.pt");
		utilizador.setPassword("123");
		
		RedeSocial rS = new RedeSocial();
		rS.adicionarUtilizador(utilizador);
		rS.removerUtilizador(""+23558224);
		
	}
	
	@org.junit.Test
	public void adicionarPedidoAmizade() {
		
		Utilizador user1 = new Utilizador();
		user1.setNome("francisco");
		Utilizador user2 = new Utilizador();
		user2.setNome("antonio");
		
		TipoRelacao tR = TipoRelacao.PROFISSIONAL;
		tR.setUtilizadorQueEnvia(user1.getNome());
		tR.setUtilizadorQueRecebe(user2.getNome());
		tR.setRelacionamento(tR.toString());
		tR.pedidoAmizade();
		

		
	}
	
	@org.junit.Test
	public void listarPedidosAmizade() {
		
		
		Utilizador user1 = new Utilizador();
		user1.setNome("francisco");
		Utilizador user2 = new Utilizador();
		user2.setNome("antonio");
		
		TipoRelacao tR = TipoRelacao.AMIGO;
		tR.setUtilizadorQueEnvia(user1.getNome());
		tR.setUtilizadorQueRecebe(user2.getNome());
		tR.setRelacionamento(tR.toString());
		tR.pedidoAmizade();
		
		Utilizador user3 = new Utilizador();
		user3.setNome("maria");
		Utilizador user4 = new Utilizador();
		user4.setNome("patrícia");
		
		TipoRelacao tR1 = TipoRelacao.FAMILIAR;
		tR1.setUtilizadorQueEnvia(user3.getNome());
		tR1.setUtilizadorQueRecebe(user4.getNome());
		tR1.setRelacionamento(tR1.toString());
		tR1.pedidoAmizade();
		
		TipoRelacao tr = TipoRelacao.PROFISSIONAL;
		tr.listarPedidosDeAmizade();
		
	}
	
	@org.junit.Test
	public void enviarMensagem() {
		
		Utilizador queEnvia = new Utilizador();
		queEnvia.setNome("Ana");
		Utilizador queRecebe = new Utilizador();
		queRecebe.setNome("Susana");
		
		String assunto = "Mensagem de Teste";
		String texto = "Isto é um teste...";
		
		Mensagem m1 = new Mensagem();
		m1.setUtilizadorQueEnvia(queEnvia.getNome());
		m1.setUtilizadorQueRecebe(queRecebe.getNome());
		m1.setAssuntoMensagem(assunto);
		m1.setTextoMensagem(texto);
		RedeSocial rs = new RedeSocial();
		rs.mensagens.add(m1);
		System.out.println("A mensagem foi enviada com sucesso!");
		
	}
	
	@org.junit.Test
	public void listarMensagens() {
		
		Utilizador queEnvia = new Utilizador();
		queEnvia.setNome("Ana");
		Utilizador queRecebe = new Utilizador();
		queRecebe.setNome("Susana");
		
		String assunto = "Mensagem de Teste";
		String texto = "Isto é um teste...";
		
		Mensagem m1 = new Mensagem();
		m1.setUtilizadorQueEnvia(queEnvia.getNome());
		m1.setUtilizadorQueRecebe(queRecebe.getNome());
		m1.setAssuntoMensagem(assunto);
		m1.setTextoMensagem(texto);
		RedeSocial rs = new RedeSocial();
		rs.mensagens.add(m1);
		System.out.println("A mensagem foi enviada com sucesso!");
		
		
		Utilizador queEnvia1 = new Utilizador();
		queEnvia1.setNome("Sousa Pinto");
		Utilizador queRecebe1 = new Utilizador();
		queRecebe1.setNome("Jorge Jesus");
		
		String assunto1 = "Época 2015/2016";
		String texto1 = "Águia Vitória";
		
		Mensagem m2 = new Mensagem();
		m2.setUtilizadorQueEnvia(queEnvia1.getNome());
		m2.setUtilizadorQueRecebe(queRecebe1.getNome());
		m2.setAssuntoMensagem(assunto1);
		m2.setTextoMensagem(texto1);
		RedeSocial rs1 = new RedeSocial();
		rs1.mensagens.add(m2);
		System.out.println("A mensagem foi enviada com sucesso!");
		
		RedeSocial rs2 = new RedeSocial();
		rs2.listarMensagens();
	}
	
	
	
	@org.junit.Test
	public void guardarDados() {
		
	}
	
	@org.junit.Test
	public void lerDados() {
		
	}
	

}
