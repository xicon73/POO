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

  public UMer(UMer um) {
    this.clientes = um.getClientes();
    this.motoristas = um.getMotoristas();
    this.viaturas = um.getViaturas();
    this.viagens = um.getViagens();
  }

  public HashMap<String, Cliente> getClientes (){
    HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();
    for(String email: this.clientes.keySet()){
      clientes.put(email,this.clientes.get(email).clone());
    }
    return clientes;
  }

  public HashMap<String, Motoristas> getMotoristas (){
    HashMap<String, Motorista> motoristas = new HashMap<String, Motorista>();
    for(String email: this.motoristas.keySet()){
      motoristas.put(email,this.motoristas.get(email).clone());
    }
    return motoristas;
  }

  public Cliente getCliente(String email){
      if(!this.clientes.containsKey(email)) return null;
      return this.clientes.get(email).clone();
  }

  public Motorista getMotorista(String email){
      if(!this.motoristas.containsKey(email)) return null;
      return this.motoristas.get(email).clone();
  }



}
