package exceptions;

public class FluxoMyException {

    public static void main(String[] args) {
    	/* não é necessario verificar com throws, pois tem o try-catch */
        System.out.println("Ini do main");
        try {
        	metodo1();
        } catch(ArithmeticException | NullPointerException | MyException e) { 
        	System.out.println("Exception: " + e.getMessage());
        } 
        
        System.out.println("Fim do main");
    }

    private static void metodo1() throws MyException {
    	/* necessario verificar com throws para excecutar metodo2 */
        System.out.println("Ini do metodo1");
        metodo2(); 
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() throws MyException { 
    	/* Herdadando exceção é necessario especificar com 
    	 * throws na declaração da função.
    	 * Pertence à categoria checked, verificada pelo compilador.
    	 */
        System.out.println("Ini do metodo2");
        
        //criando um novo tipo de exceção 
        throw new MyException("deu muito errado");
        
    }
}
