import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CalculadoraTeste {
	
	@Test
	public void somarDoisNumerosPositivos() {
		Calculadora calc = new Calculadora();
		int soma = calc.somar(3, 7);
		
		Assert.assertEquals(10, soma);
		
	}
}
