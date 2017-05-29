import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class Viagem {

    private GregorianCalendar data;
    /*public string cliente;
      public string viatura;
      public string motorista
     */

    public Cliente cliente;
    private Viatura viatura;
    private Coordenadas origem;
    private Coordenadas destino;
    private float distancia;
    private float preco;
    private float tempoPrevisto;
    private float tempoReal;
    private float desvio;

    public Viagem(){
        this.data = new GregorianCalendar();
        this.cliente = new Cliente();
        this.viatura = new Viatura();
        this.origem = new Coordenadas();
        this.destino = new Coordenadas();
        this.distancia = 0f;
        this.preco = 0f;
        this.tempoPrevisto=0f;
        this.tempoReal=0f;
        this.desvio=0f;
    }

    public Viagem(GregorianCalendar date, Cliente client, Viatura car, Coordenadas origin, Coordenadas destiny, float distance, float price, float tempoPrevisto, float tempoReal, float desvio){
        this.data = new GregorianCalendar();
        this.cliente=client.clone();
        this.viatura=car.clone();
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Viatura getViatura() {
        return viatura;
    }

    public void setViatura(Viatura viatura) {
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

    public Float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public Float getPreco() {
      return preco;
    }

    public void setPreco(float preco){
      this.preco = preco;
    }

    public float getTempoPrevisto() return tempoPrevisto;

    public void setTempoPrevisto(float tempoPrevisto) this.tempoPrevisto = tempoPrevisto;

    public float getTempoReal() {return tempoReal;}

    public void setTempoReal(float tempoReal) { this.tempoReal = tempoReal;}

    public float getDesvio() {return desvio}

    public void setDesvio(float desvio) {this.desvio = desvio}
}
