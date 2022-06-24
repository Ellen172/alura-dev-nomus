package conexao;

public class TesteConexao {
	public static void main(String[] args) {
		//versão antiga
		/*
		Conexao con = null;
		try {
			con = new Conexao();
			con.leDados();
		} 
		catch (IllegalStateException e) { //possivel executar sem o catch, se houver finally, mas o erro não sera tratado
			System.out.println("erro na conexao"); 
		}
		finally { //sempre executa, com erro ou sem.
			if(con != null)
				con.fecha();			
		}
		*/
	//--------------------------------------------------------------------------
		//versão nova
		try (ConexaoNova conexao = new ConexaoNova()){ //garante que no fim do try a conexao será fechada (como se estivesse no finally)
			conexao.leDados();
		} catch (IllegalStateException e) { 
			System.out.println("erro na conexao"); 
		}
		
	}
}
