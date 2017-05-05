import java.util.*;
import java.io.*;

public class UMeR implements Serializable{
  private Map<String,Cliente> clientes;
  private Map<String,Motorista> motoristas;
  private Map<String,Viatura> viaturas;
  private Map<String,Viagem> viagens;

  public UMer(){
    this.clientes = new Map<String,Cliente>();
    this.motoristas = new Map<String,Motorista>();
    this.viaturas = new Map<String,Viatura>();
    this.viagens = new Map<String,Viagem>();
  }

  public UMeR(Map<String,Cliente> clientes, Map<String,Motorista> motorista, Map<String,Viatura> viaturas, Map<String,Viagem> viagens) {
    this.clientes = new Map<String,Cliente>();
    this.motoristas = new Map<String,Motorista>();
    this.viaturas = new Map<String,Viatura>();
    this.viagens = new Map<String,Viagem>();
  }

}
