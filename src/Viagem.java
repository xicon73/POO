import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class Viagem implements Serializable{

    private GregorianCalendar data;
    /*public string cliente;
      public string viatura;
      public string motorista
     */

    private String cliente;
    private String motorista;
    private String viatura;
    private Coordenadas origem;
    private Coordenadas destino;
    private double distancia;
    private double preco;
    private double tempoPrevisto;
    private double tempoReal;
    private double desvio;

    public Viagem(){
        this.data = new GregorianCalendar();
        this.cliente = "";
        this.motorista = "";
        this.viatura = "";
        this.origem = new Coordenadas();
        this.destino = new Coordenadas();
        this.distancia = 0;
        this.preco = 0;
        this.tempoPrevisto=0;
        this.tempoReal=0;
        this.desvio=0;
    }

    public Viagem(GregorianCalendar date, String client, String driver, String car, Coordenadas origin, Coordenadas destiny, double distance, double price, double tempoPrevisto, double tempoReal, double desvio){
        this.data = new GregorianCalendar();
        this.cliente=client;
        this.motorista = driver;
        this.viatura=car;
        this.origem=origin.clone();
        this.destino=destiny.clone();
        this.distancia=distance;
        this.preco=price;
        this.tempoPrevisto=tempoPrevisto;
        this.tempoReal=tempoReal;
        this.desvio=desvio;
    }

    public Viagem(Viagem v){
        this.data=v.getData();
        this.cliente=v.getCliente();
        this.motorista=v.getMotorista();
        this.viatura=v.getViatura();
        this.origem=v.getOrigem();
        this.destino=v.getDestino();
        this.distancia=v.getDistancia();
        this.preco=v.getPreco();
        this.tempoPrevisto=v.getTempoPrevisto();
        this.tempoReal=v.getTempoReal();
        this.desvio=v.getDesvio();
    }


    /* Getters and setters methods */

    public GregorianCalendar getData() {
        return (GregorianCalendar)data.clone();
    }

    public void setData(Date data) {
        this.data = (GregorianCalendar)data.clone();
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
        public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public String getViatura() {
        return viatura;
    }

    public void setViatura(String viatura) {
        this.viatura = viatura;
    }

    public Coordenadas getOrigem() {
        return origem;
    }

    public void setOrigem(Coordenadas origem) {
        this.origem = origem;
    }

    public Coordenadas getDestino() {
        return destino;
    }

    public void setDestino(Coordenadas destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPreco() {
      return preco;
    }

    public void setPreco(double preco){
      this.preco = preco;
    }

    public double getTempoPrevisto() {return tempoPrevisto;}

    public void setTempoPrevisto(double tempoPrevisto) {this.tempoPrevisto = tempoPrevisto;}

    public double getTempoReal() {return tempoReal;}

    public void setTempoReal(double tempoReal) { this.tempoReal = tempoReal;}

    public double getDesvio() {return desvio;}

    public void setDesvio(double desvio) {this.desvio = desvio;}
}
