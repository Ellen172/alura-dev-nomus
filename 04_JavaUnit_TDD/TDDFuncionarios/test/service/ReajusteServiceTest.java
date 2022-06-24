package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Desempenho;
import modelo.Funcionario;

public class ReajusteServiceTest {
	
	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach //executa antes de cada metodo de teste
	public void inicializar() {
		service = new ReajusteService();
		funcionario = new Funcionario("Ana", new BigDecimal("1000.00"));
	}
	
	@AfterEach
	public void finalizar() {
		System.out.println("teste!");
	}
	
	@BeforeAll
	public static void antes() {
		System.out.println("antes de todos");
	}
	
	@AfterAll
	public static void depois() {
		System.out.println("depois de tudo");
	}

	@Test
	public void reajusteDeTresPorcentoSeDesempenhoADesejar() {
		service.realizarReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalary());
	}
	
	@Test
	public void reajusteDeQuinzePorcentoSeDesempenhoBom() {
		service.realizarReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalary());
	}
	
	@Test
	public void reajusteDeVintePorcentoSeDesempenhoOtimo() {
		service.realizarReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalary());
	}

}
