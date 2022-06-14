import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Principal {
	public static void main(String[] args) {

		Pessoa p1 = new Pessoa("Amanda", LocalDate.of(1998, Month.APRIL, 25));
		Pessoa p2 = new Pessoa("Carlos", LocalDate.of(1998, Month.AUGUST, 30));
		
		Period pp1 = Period.between(p1.getBirth(), LocalDate.now());
		Period pp2 = Period.between(p2.getBirth(), LocalDate.now());
		
		System.out.println(p1.getName() + " tem " 
				+ pp1.getYears() + " anos " 
				+ pp1.getMonths() + " meses e " 
				+ pp1.getDays() + " dias");
		
		System.out.println(p2.getName() + " tem " 
				+ pp2.getYears() + " anos " 
				+ pp2.getMonths() + " meses e " 
				+ pp2.getDays() + " dias");
	}
}
