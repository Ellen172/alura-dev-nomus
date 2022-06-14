package service;
import java.math.BigDecimal;

import modelo.Funcionario;

public class BonusService {
	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalary().multiply(new BigDecimal("0.1"));
		if(valor.compareTo(new BigDecimal("1000")) > 0) {
			//se o bonus é maior que 1000, será zerado;
			valor = BigDecimal.ZERO;
		}
		return valor;
	}
}
