
public class Curso {
	private String nome;
	private int alunos;
	
	public Curso(String nome, int alunos) {
		setNome(nome);
		setAlunos(alunos);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAlunos() {
		return alunos;
	}

	public void setAlunos(int alunos) {
		this.alunos = alunos;
	}
}
