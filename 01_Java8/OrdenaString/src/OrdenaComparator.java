import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenaComparator {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

		// DEAFAULT METHODS

		Comparator<String> comparador = new ComparadorPorTamanho();
		Collections.sort(palavras, comparador); // palavras.sort(comparador);
		System.out.println(palavras);

		// CLASSE ANONIMA

		palavras.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length())
					return -1;
				if (o1.length() > o2.length())
					return 1;
				return 0;
			}

		});
		System.out.println(palavras);

		// METODO REFERENCE
		
		//palavras.sort(Comparator.comparing(s -> s.length()));
		palavras.sort(Comparator.comparing(String::length)); 
		System.out.println(palavras);

	}
}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if (o1.length() < o2.length())
			return -1; // o1 primeiro
		if (o1.length() > o2.length())
			return 1; // o2 primeiro
		return 0; // empate
	}

}
