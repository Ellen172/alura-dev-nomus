
public class Test {
	public static void main(String[] args) {
		
		//Prioridade pMin = new Prioridade(); //não pode ser instanciada
		Prioridade pMin = Prioridade.MIN; 
		
		Prioridade pMax = Prioridade.MAX;
		
		System.out.println(pMin.name() + 
				"\t" + pMin.ordinal() + "\t" + pMin.getValor());
		System.out.println(pMax.name() + 
				"\t" + pMax.ordinal() + "\t" + pMax.getValor());
		
		//ordinal = nro de classificação de acordo com a ordem que foram inseridos na classe
		
		
		
	}
}
