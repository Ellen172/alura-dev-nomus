import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenaSortColletions {

	public static void main(String[] args) {
		List <String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");
		
		//ordena alfabeticamente
		Collections.sort(palavras); 
		System.out.println(palavras); 
	}
}
