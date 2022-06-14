import java.time.LocalDate;

public class Pessoa {

	String name;
	LocalDate birth;
	
	public Pessoa(String name, LocalDate birth) {
		this.name = name;
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirth() {
		return birth;
	}
	
	
}
