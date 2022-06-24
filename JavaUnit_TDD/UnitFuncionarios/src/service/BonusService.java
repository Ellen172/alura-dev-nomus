package service;
import java.math.BigDecimal;
import java.math.RoundingMode;

import modelo.Funcionario;

public class BonusService {
	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalary().multiply(new BigDecimal("0.1"));
		if(valor.compareTo(new BigDecimal("1000")) > 0) {
			valor = BigDecimal.ZERO;
		}
		return valor.setScale(2, RoundingMode.HALF_UP); //2 casas decimais
	}
}
