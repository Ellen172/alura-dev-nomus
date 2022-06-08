package exemploConta;

public class Conta {
	private String nome;
	private double valor;
	
	public Conta(String nome, double valor) {
		setNome(nome);
		setValor(valor);
	}
	
	void deposita() throws MyException {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}