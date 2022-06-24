import java.util.ArrayList;
import java.util.List;

public class OrdenaComparatorLambda {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

		// ordenar com lambda
		palavras.sort((String o1, String o2) -> {
			if (o1.length() < o2.length())
				return -1;
			if (o1.length() > o2.length())
				return 1;
			return 0;
		});

		System.out.println(palavras);

		// ordenar com lambda simplificado
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		System.out.println(palavras);

	}
}
