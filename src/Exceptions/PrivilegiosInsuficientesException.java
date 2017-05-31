package Exceptions;

/**
 *
 * @author Claudia Marques
 * @author Francisco Costa
 * @author Mauricio Salgado
 */
public class PrivilegiosInsuficientesException extends Exception {

    /**
     * Construtor vazio, ou seja, apenas invoca o construtor da superclasse.
     */
    public PrivilegiosInsuficientesException(){
        super();
    }

    /**
     * Construtor parametrizado, ou seja, recebe uma String como parâmetro para informação, que invoca igualmente o construtor da superclasse que aceita uma String por parâmetro.
     */
    public PrivilegiosInsuficientesException(String message){
        super(message);
    }

    /**
     * A função getMessage imprime o texto de exceção.
     */
    public String getMessage() {
        return "Não possui privilegios suficientes!\n";
    }
}
