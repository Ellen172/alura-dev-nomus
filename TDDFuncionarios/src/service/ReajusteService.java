package service;

import java.math.BigDecimal;

import modelo.Desempenho;
import modelo.Funcionario;

public class ReajusteService {

	public void realizarReajuste(Funcionario funcionario, Desempenho desempenho) {
		BigDecimal reajuste = funcionario.getSalary().multiply(desempenho.percentualReajuste());
		funcionario.reajustarSalario(reajuste);		
	}

}
