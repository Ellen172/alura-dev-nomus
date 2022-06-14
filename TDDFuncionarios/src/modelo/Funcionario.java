package modelo;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Funcionario {
	String name;
	BigDecimal salary;
	
	public Funcionario(String name, BigDecimal salary) {
		this.name = name;
		this.salary = salary;
	}

	public BigDecimal getSalary() {
		return salary;
	}
	
	public String getName() {
		return name;
	}

	public void reajustarSalario(BigDecimal reajuste) {
		this.salary = this.salary.add(reajuste).setScale(2, RoundingMode.HALF_UP);
	}

}
