package service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusZeradoSeMaiorQueMil() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Ana", new BigDecimal("25000")));
		
		assertEquals(new BigDecimal("0.00"), bonus);
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
