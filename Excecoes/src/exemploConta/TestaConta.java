package exemploConta;

public class TestaConta {

	public static void main(String[] args) {
		System.out.println("Iniciando..");
		Conta c = new Conta("Ellen", 100.00);
		
		try {			
			c.deposita();
		} 
		catch (MyException e) {
			System.out.println("Erro!");
		}
	}

}
