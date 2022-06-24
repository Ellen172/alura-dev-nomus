import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Imprime {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

		// for
		System.out.println("\nfor: ");
		for (String p : palavras) {
			System.out.println(p);
		}

		// forEach com Consumer
		System.out.println("\nforEach com consumer: ");
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);

		// forEach com Consumer por classe anonima
		System.out.println("\nforEach com Consumer por classe anonima: ");
		Consumer<String> consumidora = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}

		};
		palavras.forEach(consumidora);

		// forEach com Consumer por lambda
		System.out.println("\nforEach com Consumer por lambda: ");
		palavras.forEach((String s) -> {
			System.out.println(s);
		});

		// forEach com Consumer por lambda, inferindo tipo
		System.out.println("\nforEach com Consumer por lambda, inferindo tipo: ");
		palavras.forEach(s -> {
			System.out.println(s);
		});

		// forEach com Consumer por lambda, inferindo tipo, simplificado
		System.out.println("\nforEach com Consumer por lambda, inferindo tipo, simplificado: ");
		palavras.forEach(s -> System.out.println(s));

		// forEach com Consumer por lambda, inferindo tipo, simplificado, por metodo reference
		System.out.println("\nforEach com Consumer por lambda, inferindo tipo, simplificado, por metodo reference: ");
		palavras.forEach(System.out::println);
	}

}

class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String t) { // dada uma string
		System.out.println(t);
	}

}
