package modelo;
import java.math.BigDecimal;

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

}
