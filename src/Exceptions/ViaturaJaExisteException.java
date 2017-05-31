package Exceptions;

/**
 *
 * @author Claudia Marques
 * @author Francisco Costa
 * @author Mauricio Salgado
 */
public class ViaturaJaExisteException extends Exception {

    /**
     * Construtor vazio, ou seja, apenas invoca o construtor da superclasse.
     */
    public ViaturaJaExisteException(){
        super();
    }

    /**
     * Construtor parametrizado, ou seja, recebe uma String como parâmetro para informação, que invoca igualmente o construtor da superclasse que aceita uma String por parâmetro.
     */
    public ViaturaJaExisteException(String message){
        super(message);
    }

    /**
     * A função getMessage imprime o texto de exceção.
     */
    public String getMessage() {
        return "A viatura já existe!\n";
    }
}
