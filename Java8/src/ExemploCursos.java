import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExemploCursos {
	public static void main(String args[]) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		// ordena o list de acordo com qtd de alunos
		cursos.sort(Comparator.comparing(Curso::getAlunos)); 
		
		// printar cada curso com qtd de alunos
		System.out.println("Alunos\tCurso");
		cursos.forEach(c -> System.out.println(c.getAlunos() + "\t" + c.getNome()));
		System.out.println();
		
		// printar os cursos com mais de 50 alunos
		System.out.println("Cursos com mais de 50 alunos: ");
		cursos.stream() //não impacta o array inicial
			.filter(c -> c.getAlunos() > 50) //filtra apenas alunos>99
			.forEach(c -> System.out.println(c.getNome()));
		System.out.println();

		// mostrar qtd total de alunos matriculados em algum curso
		int sum = cursos.stream() //não impacta o array inicial
			.mapToInt(Curso::getAlunos)
			.sum();
		System.out.println("qtd de alunos totais: " + sum);		

		// retorna o valor de um elemento com mais de 100 alunos 
		Optional<Curso> optionalCurso = cursos.stream()
			.filter(c -> c.getAlunos() > 100)
			.findAny();
		optionalCurso
			.ifPresent(c -> System.out.println("Curso com +100 alunos: " + c.getNome())); 
			//com mais de 1000, não encontra nenhum e não imprime
			
		// media de alunos matriculados 
		OptionalDouble media = cursos.stream()
			.mapToInt(Curso::getAlunos)
			.average();
		media.ifPresent(m -> System.out.println("Media de alunos: " + m));
		
		System.out.println();
		
		// criando novo list com stream (podemos alterar a propria lista 'cursos')
		List<Curso> novoList = cursos.stream()
				.filter(c -> c.getAlunos()<=100)
				.collect(Collectors.toList());
		System.out.println("Novo list: " + novoList);
		
		// criando novo map com stream 
		Map<String, Integer> novoMap = cursos.stream()
				.collect(Collectors.toMap(
						c -> c.getNome(), //chave
						c -> c.getAlunos())); //valor
		System.out.println("Novo map: " + novoMap);
		
		// printar como map
		System.out.println();
		cursos.stream()
				.collect(Collectors.toMap(
						c -> c.getNome(),
						c -> c.getAlunos()))
				.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos."));
	}
}



