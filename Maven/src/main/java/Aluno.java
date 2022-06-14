import java.time.LocalDate;

public class Aluno extends Pessoa{

	int mat;
	
	public Aluno(String name, LocalDate birth, int mat) {
		super(name, birth);
		this.mat = mat;
	}
	
}
