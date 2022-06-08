import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaString {
	public static void main(String[] args) {
		
		List <String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");
		

		/////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////
		
		
		//ordena alfabeticamente
		/* 
		Collections.sort(palavras); 
		System.out.println(palavras); 
		*/
		
		//ordena com base no camparador (default methods)
		/* 
		Comparator<String> comparador = new ComparadorPorTamanho();
		Collections.sort(palavras, comparador); 
		System.out.println(palavras); 
		*/
		
		// ordena de acordo com comparador
		/*
		Comparator<String> comparador = new ComparadorPorTamanho();
		palavras.sort(comparador); 
		System.out.println(palavras);
		*/
		
		// ordenar com classe anonima
		/*
		palavras.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() < o2.length())
					return -1; 
				if(o1.length() > o2.length())
					return 1; 
				return 0; 
			}
			
		});
		*/
		
		// ordenar com lambda 
		/*
		palavras.sort((String o1, String o2) -> {
				if(o1.length() < o2.length())
					return -1; 
				if(o1.length() > o2.length())
					return 1; 
				return 0;
			}
			
		});
		*/
		
		// ordenar com lambda simplificado
		/*
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		*/
		
		// ordenar com metodo do Comparator (metodo reference)
		//palavras.sort(Comparator.comparing(s -> s.length())); // tipo 1		
		palavras.sort(Comparator.comparing(String::length)); // tipo 2
		
		/////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////
		
		// imprime cada elemento: for
		/*
		for (String p : palavras) {
			System.out.println(p);
		}
		*/
		
		// imprime cada elemento: metodo forEach
		/*
		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);
		*/
		
		// imprime cada elemento: metodo forEach + classe anonima
		/*
		Consumer<String> consumidora = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
			
		};
		palavras.forEach(consumidora);
		*/
		
		// imprime cada elemento: metodo forEach com lambda
		/*
		palavras.forEach((String s) -> {
			System.out.println(s);
		});
		*/
		
		// imprime cada elemento: metodo forEach inferindo tipo
		/*
		palavras.forEach(s -> { 
			System.out.println(s);
		});
		*/
		
		// imprime cada elemento: metodo forEach simplificado
		//palavras.forEach(s -> System.out.println(s));
		
		//metodo reference 
		palavras.forEach(System.out::println);
		
	}
}

class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String t) { // dada uma string
		System.out.println(t);
	}
	
}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if(o1.length() < o2.length())
			return -1; // o1 primeiro
		if(o1.length() > o2.length())
			return 1; // o2 primeiro
		return 0; // empate
	}
	
}