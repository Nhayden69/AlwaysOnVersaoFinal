package redeSocial;

public class Mensagem {
	
	private String utilizadorQueEnvia = "";
	private String utilizadorQueRecebe = "";
	private String assuntoMensagem = "";
	private String textoMensagem = "";
	
	
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
	public String getAssuntoMensagem() {
		return assuntoMensagem;
	}
	public void setAssuntoMensagem(String assuntoMensagem) {
		this.assuntoMensagem = assuntoMensagem;
	}
	public String getTextoMensagem() {
		return textoMensagem;
	}
	public void setTextoMensagem(String textoMensagem) {
		this.textoMensagem = textoMensagem;
	}

}
