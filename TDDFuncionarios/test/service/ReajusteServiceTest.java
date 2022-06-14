package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import modelo.Desempenho;
import modelo.Funcionario;

public class ReajusteServiceTest {
	
	@Test
	public void reajusteDeTresPorcentoSeDesempenhoADesejar() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Ana", new BigDecimal("1000.00"));
		
		service.realizarReajuste(funcionario, Desempenho.A_DESEJAR);
		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalary());
	}
	
	@Test
	public void reajusteDeQuinzePorcentoSeDesempenhoBom() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Ana", new BigDecimal("1000.00"));
		
		service.realizarReajuste(funcionario, Desempenho.BOM);
		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalary());
	}
	
	@Test
	public void reajusteDeVintePorcentoSeDesempenhoOtimo() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Ana", new BigDecimal("1000.00"));
		
		service.realizarReajuste(funcionario, Desempenho.OTIMO);
		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalary());
	}

}
