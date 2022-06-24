package conexao;

public class Conexao {
	public Conexao() {
		System.out.println("abrindo conexao");
		throw new IllegalStateException();
	}
	
	public void leDados() {
		System.out.println("recebendo dados");
		//throw new IllegalStateException();
	}
	
	public void fecha() {
		System.out.println("fechando conexao");
	}
}
