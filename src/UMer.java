import java.util.*;
import java.io.*;

public class UMer implements Serializable{
  private Map<String,Cliente> clientes;
  private Map<String,Motorista> motoristas;
  private Map<String,Viatura> viaturas;
  private Map<String,Viagem> viagens;

  public UMer(){
    this.clientes = new HashMap<String,Cliente>();
    this.motoristas = new HashMap<String,Motorista>();
    this.viaturas = new HashMap<String,Viatura>();
    this.viagens = new HashMap<String,Viagem>();
  }

  public UMer(Map<String,Cliente> clientes, Map<String,Motorista> motorista, Map<String,Viatura> viaturas, Map<String,Viagem> viagens) {
    this.clientes = new HashMap<String,Cliente>();
    this.motoristas = new HashMap<String,Motorista>();
    this.viaturas = new HashMap<String,Viatura>();
    this.viagens = new HashMap<String,Viagem>();
  }

}
