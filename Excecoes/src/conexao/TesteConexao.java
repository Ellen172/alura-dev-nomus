package conexao;

public class TesteConexao {
	public static void main(String[] args) {
		Conexao con = null;
		try {
			con = new Conexao();
			con.leDados();
		} catch (IllegalStateException e) {
			System.out.println("erro na conexao"); 
		} finally { //sempre executa, com erro ou sem.
			con.fecha();			
		}
	}
}
