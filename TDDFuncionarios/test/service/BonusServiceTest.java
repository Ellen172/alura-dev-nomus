package service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusZeradoSeMaiorQueMil() {
		BonusService service = new BonusService();
		
		//verificar se durante a chamada do metodo houve IllegalArgumentException
		/*
		assertThrows(IllegalArgumentException.class, 
				() -> service.calcularBonus(new Funcionario("Ana", new BigDecimal("25000"))));
		*/
		//verificar se durante a chamada do metodo houve IllegalArgumentException
		
		try{
			service.calcularBonus(new Funcionario("Ana", new BigDecimal("25000")));
			fail("exception não ocorreu");
		} catch (Exception e) {
			//houve exception (valor esperado)
			assertEquals("Funcionario teria bonus maior que 1000.00 reais", e.getMessage());
		}
		
		
	}
	
	@Test
	void bonusDezPorcentoDoSalarioSeMenorQueMil() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Ana", new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDezPorcentoDoSalarioSeIgualMil() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Ana", new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
