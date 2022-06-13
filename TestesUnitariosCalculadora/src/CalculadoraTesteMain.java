
public class CalculadoraTesteMain {
	
	// teste manual
	public static void main(String[] args) {
		Calculadora calc = new Calculadora();
		
		// dois positivos 
		int soma = calc.somar(3, 7);
		System.out.println(soma);
		
		// zero mais positivo 
		soma = calc.somar(0, 7);
		System.out.println(soma);
		
		// dois zeros 
		soma = calc.somar(0, 0);
		System.out.println(soma);
		
		// positivo mais negativo 
		soma = calc.somar(3, -1);
		System.out.println(soma);
	}
	
}
