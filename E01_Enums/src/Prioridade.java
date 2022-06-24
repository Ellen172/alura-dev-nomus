
public enum Prioridade {
	
	//definindo os possiveis valores 
	//MIN, NORMAL, MAX; //default
	MIN(1), NORMAL(5), MAX(10); //com valores atribuidos (necessario construtor)
	
	//atributos (apos os valores)
	private int valor;
		
	Prioridade(int valor){
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
}
