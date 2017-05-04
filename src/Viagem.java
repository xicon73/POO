import Java.Util.*

public class Viagem {

    private Date data;
    private Cliente cliente;
    private Viatura viatura;
    private Ponto origem;
    private Ponto destino;
    private Float distancia;

    /* Getters and setters methods */

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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

    public Viagem(Date data, Cliente cliente, Viatura viatura, Ponto origem, Ponto destino, Float distancia) {
        this.data = data;
        this.cliente = cliente;
        this.viatura = viatura;
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
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

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (cliente != null ? cliente.hashCode() : 0);
        result = 31 * result + (viatura != null ? viatura.hashCode() : 0);
        result = 31 * result + (origem != null ? origem.hashCode() : 0);
        result = 31 * result + (destino != null ? destino.hashCode() : 0);
        result = 31 * result + (distancia != null ? distancia.hashCode() : 0);
        return result;
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
}
