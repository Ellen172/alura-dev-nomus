package conexao;

public class ConexaoNova implements AutoCloseable{
	public ConexaoNova() {
		System.out.println("abrindo conexao");
		throw new IllegalStateException();
	}
	
	public void leDados() {
		System.out.println("recebendo dados");
		//throw new IllegalStateException();
	}

	@Override
	public void close() {
		System.out.println("fechando conexao");
	}
}
