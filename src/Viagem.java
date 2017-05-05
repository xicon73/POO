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
        this.origem=origin;
        this.destino=destiny;
        this.distancia=distance;
        this.preco=price;
    }

    /**
     * Construtor de cópia, ou seja, copia os dados de um Cliente já existente.
     * @param c O Cliente que vamos copiar.
     */
    public Viagem(Cliente v){
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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        Viagem viagem = (Viagem) object;

        if (data != null ? !data.equals(viagem.data) : viagem.data != null) return false;
        if (cliente != null ? !cliente.equals(viagem.cliente) : viagem.cliente != null) return false;
        if (viatura != null ? !viatura.equals(viagem.viatura) : viagem.viatura != null) return false;
        if (origem != null ? !origem.equals(viagem.origem) : viagem.origem != null) return false;
        if (destino != null ? !destino.equals(viagem.destino) : viagem.destino != null) return false;
        if (distancia != null ? !distancia.equals(viagem.distancia) : viagem.distancia != null) return false;

        return true;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Viagem{" +
                "data=" + data +
                ", cliente=" + cliente +
                ", viatura=" + viatura +
                ", origem=" + origem +
                ", destino=" + destino +
                ", distancia=" + distancia +
                '}';
    }
}
