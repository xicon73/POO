import java.util.*;
import java.io.*;
import java.util.*;
import static java.lang.System.out;
import java.io.*;

/**
 * Classe Cliente
 * 
 * @author Cláudia Marques
 * @version 0.2
 */
public class Cliente
{
    private String email;
    private String password;
    private String nome;
    private String morada;
    private GregorianCalendar data_nascimento;
    private ArrayList <Viagem> viagens;
    
    /**
     * Construtor vazio, ou seja, inicializa um Cliente a nulo
     */
    public Cliente(){
        this.email = "";
        this.password = "";
        this.nome = "";
        this.morada = "";
        this.data_nascimento = new GregorianCalendar();
        this.viagens = new ArrayList<Viagem>();
    }
    
    /**
     * Construtor parametrizado, ou seja, recebe um email, uma password, um nome, uma morada e uma data de nascimento
     * @param email Email do Cliente
     * @param password Password do Cliente
     * @param nome Nome do Cliente
     * @param morada Morada do Cliente
     * @param d Data de nascimento do Cliente
     */
    public Cliente(String email, String password, String nome, String morada, GregorianCalendar d, ArrayList<Viagem> viagens){
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.morada = morada;
        this.data_nascimento = d;
        this.viagens = new ArrayList<Viagem>(); 
    }
    
    /**
     * Construtor de cópia, ou seja, copia os dados de um Cliente já existente.
     * @param c O Cliente que vamos copiar.
     */
    public Cliente(Cliente c){
        this.email = c.getEmail();
        this.password = c.getPassword();
        this.nome = c.getNome();
        this.morada = c.getMorada();
        this.data_nascimento = c.getDate();
        this.viagens = c.getViagens();
    }
    
    /*
     * GETS
     */
    /**
     * A função getEmail devolve o email do Cliente.
     */
    public String getEmail(){ return email; }
    
    /**
     * A função getPassword devolve a password do Cliente.
     */
    public String getPassword() { return password; }
    
    /**
     * A função getNome devolve o nome do Cliente.
     */
    public String getNome(){ return nome; }
    
    /**
     * A função getMorada devolve a morada do Cliente.
     */
    public String getMorada(){ return morada; }
    
    /**
     * A função getDate devolve a Data de Nascimento do Cliente.
     */
    public GregorianCalendar getDate(){ return (GregorianCalendar)data_nascimento.clone(); }
    
    
    /**
     * A função getViagens devolve as viagens que o Cliente realizou.
     */
    public ArrayList<Viagem> getViagens () {
        ArrayList<Viagem> clone = new ArrayList<Viagem>();
        for(Viagem v : viagens){
            clone.add(v.clone());
        }
        return clone;
    }
    
    /*
     * SETS
     */
    /**
     * A função setEmail modifica o email do Cliente.
     * @param email O novo email que irá substituir o antigo.
     */
    public void setEmail(String email){ this.email = email; }
    
    /**
     * A função setPassword modifica a password do Cliente.
     * @param pw A nova password que irá substituir o antigo.
     */
    public void setPassword(String pw) { password = pw; }
    
    /**
     * A função setNome modifica o nome do Cliente.
     * @param nome O novo nome que irá substituir o antigo.
     */
     public void setNome(String nome){ this.nome=nome; }
     
    /**
     * A função setMorada modifica a morada do Utilizador.
     * @param morada A nova morada que irá substituir a antiga.
     */
    public void setMorada(String morada){ this.morada=morada; }
    
    /**
     * A função setDate modifica a data de nascimento do Utilizador.
     * @param d A nova data de nascimento que irá substituir a antiga.
     */
    public void setDate(GregorianCalendar d){this.data_nascimento=(GregorianCalendar)d.clone();}
    
    
    /**
     * A função toString imprime o Cliente.
     * @param c O Cliente que será imprimido.
     */
    public StringBuilder toString(Cliente c){
        StringBuilder str = new StringBuilder();
        str.append("-------Dados do Cliente------\n");
        str.append("Email: "               + this.getEmail()                                     +"\n");
        str.append("Password: "            + this.getPassword()                                  +"\n");
        str.append("Nome: "                + this.getNome()                                      +"\n");
        str.append("Morada: "              + this.getMorada()                                    +"\n");
        str.append("Data de Nascimento: "  + this.getDate().get(Calendar.DAY_OF_MONTH) +"/"
                                           + this.getDate().get(Calendar.MONTH) +"/"
                                           + this.getDate().get(Calendar.YEAR)                   +"\n");
        str.append("Viagens : "            + this.getViagens()                                   +"\n");                                      
        return str;
    }
    
    /**
     * A função equals recebe um Objeto genérico e verifica se é exatamente igual a um Cliente.
     * @param obj Objeto a comparar.
     */
    public boolean equals(Object obj){
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        
        Cliente cl = (Cliente) obj;
     
        return(this.email.equals(cl.getEmail()) && this.password.equals(cl.getPassword()) 
            && this.nome.equals(cl.getNome()) && this.morada.equals(cl.getMorada()) && this.data_nascimento.equals(cl.getDate()) && this.viagens.equals(cl.getViagens()));
            
    }
    
    public Cliente clone(){
        return new Cliente(this);
    }
}