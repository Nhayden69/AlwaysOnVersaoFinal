package redeSocial;

import java.util.ArrayList;

public enum TipoRelacao {
	
	FAMILIAR,
	PROFISSIONAL,
	AMIGO;
	
	static public ArrayList<TipoRelacao> pedidos = new ArrayList<TipoRelacao>();
	
	private String utilizadorQueEnvia = "";
	private String utilizadorQueRecebe = "";
	private String relacionamento = "";


	public void pedidoAmizade () {
		
		
		
		System.out.println("--- Pedido de Amizade ---");
		System.out.println("'"+this.relacionamento+"'");
		System.out.println("Nome de quem Envia: '"+this.utilizadorQueEnvia+"'");
		System.out.println("Nomede que recebe: '"+this.utilizadorQueRecebe+"'\n\n");
		
		pedidos.add(this);
		
		
		
	}
	
	public String getRelacionamento() {
		return relacionamento;
	}

	public void setRelacionamento(String relacionamento) {
		this.relacionamento = relacionamento;
	}
	
	
	public static ArrayList<TipoRelacao> getPedidos() {
		return pedidos;
	}

	public static void setPedidos(ArrayList<TipoRelacao> pedidos) {
		TipoRelacao.pedidos = pedidos;
	}

	public String getUtilizadorQueEnvia() {
		return utilizadorQueEnvia;
	}

	public void setUtilizadorQueEnvia(String utilizadorQueEnvia) {
		this.utilizadorQueEnvia = utilizadorQueEnvia;
	}

	public String getUtilizadorQueRecebe() {
		return utilizadorQueRecebe;
	}

	public void setUtilizadorQueRecebe(String utilizadorQueRecebe) {
		this.utilizadorQueRecebe = utilizadorQueRecebe;
	}

	public void adicionarPedido (TipoRelacao tr) {
		pedidos.add(tr);
	}
	
	public void listarPedidosDeAmizade () {
		
		System.out.println("--- Listar Pedidos de Amizade ---");
		for (int i = 0; i < pedidos.size(); i++) {
			System.out.println("Nº de Pedido de Amizade: "+(i+1));
			System.out.println("\t- Utilizador que Enviou Pedido: '"+pedidos.get(i).getUtilizadorQueEnvia()+"'");
			System.out.println("\t- Utilizador que Recebe Pedido: '"+pedidos.get(i).getUtilizadorQueRecebe()+"'");
			System.out.println("\t- Tipo do Pedido Efectuado (FAMILIAR, PROFISSIONAL, AMIGO): '"+pedidos.get(i).getRelacionamento()+"'\n\n");
		}
		
	}

}
