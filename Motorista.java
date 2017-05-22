import java.util.*;
import java.io.*;
import static java.lang.System.out;
/**
 * Write a description of class Motorista here.
 *
 * @author my name
 */

public class Motorista extends Cliente {
    private int[] grau = new int[100];    //grau de cumprimento de horário estabelecido com o cliente, dado por um factor entre 0 e 100
    private int[] classificacao = new int[100];   //classificação do motorista, dada numa escala de 0 a 100
    private double kms;
    private int estado;

    /**
     * Construtor vazio, ou seja, inicializa um Motorista a nulo.
     */
    public Motorista(){
        super();
        this.grau = null;
        this.classificacao = null;
        this.kms = 0;
        this.estado = 0;
    }

    /**
     * Construtor parametrizado, ou seja, recebe um email, uma password, um nome, uma morada, uma data de nascimento e um grau.
     * @param grau Grau de cumprimento de horário estabelecido com o Cliente
     * @param classi Classificação do motorista, calculado com base na classificação dada pelo Cliente no final da viagem
     * @param kms Número de kms já realizados na UMeR
     * @param estado Estado do motorista, 0 - Fora de serviço, 1 - Livre, 2 - Em viagem
     */
    public Motorista(String email, String password, String nome, String morada, GregorianCalendar d, ArrayList<Viagem> viagens, int [] array, int [] classi, double kms, int estado){
        super(email,password,nome,morada,d, viagens);
        this.grau = array;
        this.classificacao = classi;
        this.kms = kms;
        this.estado = estado;
    }

    /**
     * Construtor de cópia, ou seja, copia os dados de um Motorista já existente.
     * @param m O Motorista que vamos copiar.
     */
    public Motorista(Motorista m){
        super(m);
        this.grau = m.getGrau();
        this.classificacao = m.getClassificacao();
        this.kms = m.getKms();
        this.estado = m.getEstado();
    }

    /*
     * GETS
     */

    /**
     * A função getGrau devolve o grau de cumprimento de horário estabelecido com o Cliente.
     */
    public int [] getGrau() { return grau.clone(); }
    
    /**
     * A função getClassificacao devolve a classificação dada ao Motorista.
     */
    public int [] getClassificacao() { return classificacao.clone(); }
    

    /**
     * A função getKms devolve o número de kms já realizados na UMeR.
     */
    public double getKms() { return kms; }

    /**
     * A função getEstado devolve o estado do Motorista.
     */
    public int getEstado() {return estado;}
    /*
     * SETS
     */
    /**
     * A função setGrau modifica o grau de cumprimento de horário estabelecido com o Cliente.
     */
    public void serGrau (int [] grau) { this.grau = grau.clone(); }
    
    /**
     * A função setClassificacao modifica a classificação do Motorista.
     */
    public void setClassificacao (int [] classif) { this.classificacao = classif.clone(); }

    /**
     * A função setKms modifica o número de kms já realizados na UMeR.
     */
    public void setKms (double kms) { this.kms = kms; }

    
    /**
     * A função setEstado modifica o estado do Motorista.
     */
    public void setEstado(int estado) {
      this.estado = estado;
    }
    
    /**
     * A função toString imprime o Motorista.
     * @param m O Motorista que será imprimido.
     */
    public StringBuilder toString(Motorista m){
        StringBuilder str = new StringBuilder();
        str.append("-------Dados do Motorist------\n");
        str.append("Email: "                       + super.toString()            +"\n");
        str.append("Password: "                    + super.toString()            +"\n");
        str.append("Nome: "                        + super.toString()            +"\n");
        str.append("Morada: "                      + super.toString()            +"\n");
        str.append("Data de nascimento: "          + super.toString()            +"\n");
        str.append("Viagens: "                     + super.toString()            +"\n");
        str.append("Grau de cumprimento: "         + this.getGrau()              +"\n");
        str.append("Classificação do Motorisra: "  + this.getClassificacao()     +"\n");
        str.append("Número de kms já realizados: " + this.getKms()               +"\n");
        str.append("Estado do Motorista: "         + this.getEstado()            +"\n");

        return str;
    }
   
    /**
     * A função equals recebe um Objeto genérico e verifica se é exatamente igual a um Motorista.
     * @param obj Objeto a comparar.
     */
    public boolean equals(Object obj){
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        
        Motorista mot = (Motorista) obj;
        
        return(super.equals(obj) && this.grau == mot.getGrau() && this.classificacao == mot.getClassificacao() 
            && this.kms == mot.getKms() && this.estado == mot.getEstado());
    }
    
    public Motorista clone(){
        return new Motorista(this);
    }
}
