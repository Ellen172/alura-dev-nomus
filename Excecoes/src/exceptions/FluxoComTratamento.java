package exceptions;

import exemploBancoUnchecked.Conta;

public class FluxoComTratamento {

    public static void main(String[] args) {
        System.out.println("Ini do main");
        //metodo1();
        
        // metodo2 executa ate o erro e metodo1 ate chamado do metodo2
        try {
        	metodo1();
        } catch(ArithmeticException | NullPointerException e) { 
        	/* caso ocorra ArithmeticException ou NullPointerException */
        	System.out.println("Exception: " + e.getMessage());
        	//e.printStackTrace(); 
        } 
        
        System.out.println("Fim do main");
    }

    private static void metodo1() {
        System.out.println("Ini do metodo1");
        metodo2();
        /*
        // metodo2 executa apenas ate o erro
        try {
        	metodo2(); 
        } catch(ArithmeticException e) {
        	System.out.println("ArithmeticException");
        }
        */
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() {
        System.out.println("Ini do metodo2");
        for(int i = 1; i <= 5; i++) {
        	System.out.println(i);
        	
        	//int a = i/0; //divisão por zero não executa
        	/* 
        	try { 
        		//tenta executar 
        		int a = i/0;
        	} catch (ArithmeticException e) { 
        		//caso ocorra ArithmeticException
        		System.out.println("ArithmeticException");
        	}
        	*/
        	
        	Conta c = null;
        	c.deposita(100); //objeto null não pode executar 
        }
        System.out.println("Fim do metodo2");        
    }
}
