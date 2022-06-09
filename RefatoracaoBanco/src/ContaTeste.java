

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ContaTeste {
	
	@Test
	public void aoSacarUmValorDeUmaContaOSaldoDeveSofrerUmaSubtracaoDesseValor() {
		Conta conta = new Conta(200d);
		conta.sacar(50d);
		
		assertThat(conta.getSaldo(), is(equalTo(150d)));
	}
}
