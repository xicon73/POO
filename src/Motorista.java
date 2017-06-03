import java.util.*;
import java.io.*;
import static java.lang.System.out;
/**
 * Write a description of class Motorista here.
 *
 * @author my name
 */

public class Motorista extends Cliente {
    private double avaliacao;
    private int viagens;//grau de cumprimento de horário estabelecido com o cliente, dado por um factor entre 0 e 100
    private double kms;
    private int estado;
    private int carro; //0 - não tem ; 1- tem
    //private double ganhos;

    /**
     * Construtor vazio, ou seja, inicializa um Motorista a nulo.
     */
    public Motorista(){
        super();
        this.avaliacao = 0;
        this.viagens=0;
        this.kms = 0;
        this.estado = 1;
        this.carro = 0;
        //this.ganhos = 0;
    }

    /**
     * Construtor parametrizado, ou seja, recebe um email, uma password, um nome, uma morada, uma data de nascimento e um grau.
     * @param grau Grau de cumprimento de horário estabelecido com o Cliente
     * @param kms Número de kms já realizados na UMeR
     * @param estado Estado do motorista, 0 - Fora de serviço, 1 - Livre, 2 - Em viagem
     */
    public Motorista(String email, String password, String nome, String morada, GregorianCalendar d, int tipo, double avaliacao, int nviagens, double kms, int estado, int carro){
        super(email,password,nome,morada,d,tipo);
        this.avaliacao = avaliacao;
        this.viagens = nviagens;
        this.kms = kms;
        this.estado = estado;
        this.carro = carro;
        //this.ganhos = ganhos;
    }

    /**
     * Construtor de cópia, ou seja, copia os dados de um Motorista já existente.
     * @param m O Motorista que vamos copiar.
     */
    public Motorista(Motorista m){
        super(m);
        this.avaliacao = m.getAvaliacao();
        this.viagens = m.getViagens();
        this.kms = m.getKms();
        this.estado = m.getEstado();
        this.carro = m.getCarro();
        //this.ganhos=m.getGanhos();
    }

    public TreeMap<String, Motorista> motoristasLivres(){
      TreeMap<String, Motorista> motoristasLiv = new TreeMap<String, Motorista>();
      for(Motorista m: motoristasLiv.values()){
        if(m.getEstado()==1){
          motoristasLiv.put(m.getEmail(),m);
        }
      }
      return motoristasLiv;
    }

    /*
     * GETS
     */

    /**
     * A função getGrau devolve o grau de cumprimento de horário estabelecido com o Cliente.
     */
    public double getAvaliacao() { return avaliacao; }
    
    public int getViagens(){return viagens;}

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
    public void setAvaliacao (double avaliacao) { this.avaliacao = avaliacao; }
    
    public void setViagens (int viagens) {this.viagens = viagens;}

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
