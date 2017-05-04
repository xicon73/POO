import java.util.*;
import java.io.*;
import static java.lang.System.out;
/**
 * Write a description of class Motorista here.
 *
 * @author my name
 */

public class Motorista
{
    private String email;
    private String password;
    private String nome;
    private String morada;
    private GregorianCalendar data_nascimento;
    private int[] grau = new int[100];    //grau de cumprimento de horário estabelecido com o cliente, dado por um factor entre 0 e 100
    private double kms;
    private int estado;
    
    /**
     * Construtor vazio, ou seja, inicializa um Motorista a nulo.
     */
    public Motorista(){
        this.email = "";
        this.password = "";
        this.nome = "";
        this.morada = "";
        this.data_nascimento = new GregorianCalendar();
        this.grau = null;
        this.kms = 0;
        this.estado = 0;
    }
    
    /**
     * Construtor parametrizado, ou seja, recebe um email, uma password, um nome, uma morada, uma data de nascimento e um grau.
     * @param email Email do Motorista
     * @param password Password do Motorista
     * @param nome Nome do Motorista
     * @param morada Morada do Motorista
     * @param d Data de nascimento do Motorista
     * @param grau Grau de cumprimento de horário estabelecido com o Cliente
     * @param kms Número de kms já realizados na UMeR
     */
    public Motorista(String email, String password, String nome, String morada, GregorianCalendar d, int [] array, double kms){
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.morada = morada;
        this.data_nascimento = d;
        this.grau = array;
        this.kms = kms;
    }
    
    /**
     * Construtor de cópia, ou seja, copia os dados de um Motorista já existente.
     * @param m O Motorista que vamos copiar.
     */
    public Motorista(Motorista m){
        this.email = m.getEmail();
        this.password = m.getPassword();
        this.nome = m.getNome();
        this.morada = m.getMorada();
        this.data_nascimento = m.getDate();
        this.grau = m.getGrau();
        this.kms = m.getKms();
    }
    
    /*
     * GETS
     */
    /**
     * A função getEmail devolve o email do Motorista.
     */
    public String getEmail(){ return email; }
    
    /**
     * A função getPassword devolve a password do Motorista.
     */
    public String getPassword() { return password; }
    
    /**
     * A função getNome devolve o nome do Motorista.
     */
    public String getNome(){ return nome; }
    
    /**
     * A função getMorada devolve a morada do Motorista.
     */
    public String getMorada(){ return morada; }
    
    /**
     * A função getDate devolve a Data de Nascimento do Motorista.
     */
    public GregorianCalendar getDate(){ return (GregorianCalendar)data_nascimento.clone(); }
    
    /**
     * A função getGrau devolve o grau de cumprimento de horário estabelecido com o Cliente.
     */
    public int [] getGrau() { return grau.clone(); }
    
    /**
     * A função getKms devolve o número de kms já realizados na UMeR.
     */
    public double getKms() { return kms; }
    /*
     * SETS
     */
    /**
     * A função setEmail modifica o email do Motorista.
     * @param email O novo email que irá substituir o antigo.
     */
    public void setEmail(String email){ this.email = email; }
    
    /**
     * A função setPassword modifica a password do Motorista.
     * @param pw A password que irá substituir a antiga.
     */
    public void setPassword(String pw) { password = pw; }
    
    /**
     * A função setNome modifica o nome do Motorista.
     * @param nome O novo nome que irá substituir o antigo.
     */
     public void setNome(String nome){ this.nome=nome; }
     
    /**
     * A função setMorada modifica a morada do Motorista.
     * @param morada A nova morada que irá substituir a antiga.
     */
    public void setMorada(String morada){ this.morada=morada; }
    
    /**
     * A função setDate modifica a data de nascimento do Motorista.
     * @param d A nova data de nascimento que irá substituir a antiga.
     */
    public void setDate(GregorianCalendar d){this.data_nascimento=(GregorianCalendar)d.clone();}
    
    /**
     * A função setGrau modifica o grau de cumprimento de horário estabelecido com o Cliente.
     */
    public void serGrau (int [] grau) { this.grau = grau.clone(); }
    
    /**
     * A função setKms modifica o número de kms já realizados na UMeR.
     */
    public void setKms (double kms) { this.kms = kms; }
}

