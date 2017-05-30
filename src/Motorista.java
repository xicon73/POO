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
    private double kms;
    private int estado;
    private int carro; //0 - não tem ; 1- tem
    //private int ganhos;

    /**
     * Construtor vazio, ou seja, inicializa um Motorista a nulo.
     */
    public Motorista(){
        super();
        this.grau = null;
        this.kms = 0;
        this.estado = 0;
        this.carro = 0;
        //this.ganhos = 0;
    }

    /**
     * Construtor parametrizado, ou seja, recebe um email, uma password, um nome, uma morada, uma data de nascimento e um grau.
     * @param grau Grau de cumprimento de horário estabelecido com o Cliente
     * @param kms Número de kms já realizados na UMeR
     * @param estado Estado do motorista, 0 - Fora de serviço, 1 - Livre, 2 - Em viagem
     */
    public Motorista(String email, String password, String nome, String morada, GregorianCalendar d, int [] array, double kms, int estado, int carro){
        super(email,password,nome,morada,d);
        this.grau = array;
        this.kms = kms;
        this.estado = estado;
        this.carro = carro;
//        this.ganhos = ganhos;
    }

    /**
     * Construtor de cópia, ou seja, copia os dados de um Motorista já existente.
     * @param m O Motorista que vamos copiar.
     */
    public Motorista(Motorista m){
        super(m);
        this.grau = m.getGrau();
        this.kms = m.getKms();
        this.estado = m.getEstado();
        this.carro = m.getCarro();
        //this.ganhos=m.getGanhos();
    }

    public HashMap<String, Motoristas> motoristasLivres(){
      HashSet<String, Motorista> motoristasLiv = new HashSet<String, Motorista>();
      for(String email: this.motoristas.keySet()){
        if(this.motoristas.getEstado().equals(1)){
          motoristas.put(this.motoristas.get(email).clone());
        }
      }
    }

    /*
     * GETS
     */

    /**
     * A função getGrau devolve o grau de cumprimento de horário estabelecido com o Cliente.
     */
    public int [] getGrau() { return grau.clone(); }

    /**
     * A função getKms devolve o número de kms já realizados na UMeR.
     */
    public double getKms() { return kms; }

    public int getEstado() {return estado;}

    public int getCarro() {return carro;}
    /*
     * SETS
     */
    /**
     * A função setGrau modifica o grau de cumprimento de horário estabelecido com o Cliente.
     */
    public void serGrau (int [] grau) { this.grau = grau.clone(); }

    /**
     * A função setKms modifica o número de kms já realizados na UMeR.
     */
    public void setKms (double kms) { this.kms = kms; }

    public void setEstado(int estado) {
      this.estado = estado;
    }

    public void setCarro(int carro) {this.carro = carro;}

    public Motorista clone(){return new Motorista(this);}
}
