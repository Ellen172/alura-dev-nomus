import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		System.out.println("Hoje é "+hoje);
		
		LocalDate meuNiver = LocalDate.of(2002, Month.JULY, 1);
		
		/*
		int anos =  hoje.getYear() - meuNiver.getYear();
		System.out.println("Passaram " + anos + " anos desde a olimpiada do Rio");
		*/
		
		Period periodo = Period.between(meuNiver, hoje);
		System.out.println("Eu tenho " + periodo.getYears() + " anos, "
					+ periodo.getMonths() + " meses e "
					+ periodo.getDays() + " dias de vida");
		
		System.out.println();
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);
		LocalDate proxOlimpiada = olimpiadasRio.plusYears(4); //soma 4 anos
		System.out.println("Depois do Rio, as Olimpiadas foram em " + proxOlimpiada.format(formatador));
		
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter dataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		System.out.println("Data atual : " + agora.format(dataHora));
		
		LocalTime intervalo = LocalTime.of(15, 30);
		System.out.println("O intervalo é " + intervalo);
	}
}
