package exemploBancoUnchecked;

public class Main {
	public static void main(String[] args) {
		
		ContaCorrente cc = new ContaCorrente(111, 111);
		cc.deposita(100.0);
		
		try {			
			cc.saca(110.0);
		} catch(SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Saldo final: " + cc.getSaldo());

	}
}
