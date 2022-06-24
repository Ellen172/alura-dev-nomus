package exceptions;

public class FluxoMyRuntimeException {

    public static void main(String[] args) {
        System.out.println("Ini do main");
        try {
        	metodo1();
        } catch(ArithmeticException | NullPointerException | MyRuntimeException e) { 
        	System.out.println("Exception: " + e.getMessage());
        } 
        
        System.out.println("Fim do main");
    }

    private static void metodo1() {
        System.out.println("Ini do metodo1");
        metodo2();
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() {
        System.out.println("Ini do metodo2");
        
        // criando uma exceção
        /* 
        ArithmeticException exception = new ArithmeticException("deu errado"); // cria um objeto, ainda não executa como exceção
        throw exception; //transforma em uma exceção (so funciona com objeto do tipo exceção)
         */
        
        //criando um novo tipo de exceção 
        throw new MyRuntimeException("deu muito errado");
        
    }
}
