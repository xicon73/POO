import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class Viagem {

    private GregorianCalendar data;
    public Cliente cliente;
    private Viatura viatura;
    private Ponto origem;
    private Ponto destino;
    private Float distancia;
    private Float preco;

    public Viagem(){
        this.data = new GregorianCalendar();
        this.cliente = "";
        this.viatura = "";
        this.origem = "";
        this.destino = "";
        this.distancia = "";
        this.preco = "";
    }

    public Viagem(GregorianCalendar date, Cliente client, Viatura car, Ponto origin, Ponto destiny, Float distance, Float price){
        this.data_nascimento = date;
        this.cliente=client.clone();
        this.viatura=car.clone();
        this.origem=origin.clone();
        this.destino=destiny.clone();
        this.distancia=distance;
        this.preco=price;
    }

    public Viagem(Viagem v){
        this.data=v.getData();
        this.cliente=v.getCliente();
        this.viatura=v.getViatura();
        this.origem=v.getOrigem();
        this.destino=v.getDestino();
        this.distancia=v.getDistancia();
        this.preco=v.getPreco();
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

    public Ponto getOrigem() {
        return origem;
    }

    public void setOrigem(Ponto origem) {
        this.origem = origem;
    }

    public Ponto getDestino() {
        return destino;
    }

    public void setDestino(Ponto destino) {
        this.destino = destino;
    }

    public Float getDistancia() {
        return distancia;
    }

    public void setDistancia(Float distancia) {
        this.distancia = distancia;
    }

    public Float getPreco() {
      return preco;
    }

    public void setPreco(Float preco){
      this.preco = preco;
    }
}
