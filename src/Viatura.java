import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class Viatura {
  private String id;
  private int capacidade;
  private int velocidade;
  private double preco_base;
  private Coordenadas localizacao;
  private String condutor; //atual;
  private double kms;
  private int qualidade;

  public Viatura(){
      this.id = "";
      this.capacidade = 0;
      this.velocidade = 0;
      this.preco_base = 0;
      this.localizacao = new Coordenadas();
      this.condutor = "";
      this.kms = 0;
      this.qualidade = 0;
  }
  public Viatura(String id, int capacidade, int velocidade, double preco_base, Coordenadas localizacao, String condutor, double kms, int qualidade){
      this.id = id;
      this.capacidade = capacidade;
      this.velocidade = velocidade;
      this.preco_base = preco_base;
      this.localizacao = localizacao.clone();
      this.condutor = condutor;
      this.kms = kms;
      this.qualidade = qualidade;
  }

  public Viatura(Viatura m){
      this.id = m.getId();
      this.capacidade = m.getCapacidade();
      this.velocidade = m.getVelocidade();
      this.preco_base = m.getPreco_base();
      this.localizacao = m.getLocalizacao();
      this.condutor = m.getCondutor();
      this.kms = m.getKms();
      this.qualidade = m.getQualidade();
  }
  
  public String getId(){return id;}
  
  public void setId(String id){this.id=id;}

  public int getCapacidade() {
        return capacidade;
    }

  public void setCapacidade(int capacidade) {
      this.capacidade = capacidade;
    }

  public int getVelocidade() {
      return velocidade;
    }

  public void setVelocidade(int velocidade) {
      this.velocidade = velocidade;
    }

  public double getPreco_base() {
      return preco_base;
    }

  public void setPreco_base(double preco_base) {
      this.preco_base = preco_base;
    }
  
  
  public Coordenadas getLocalizacao() {
      return localizacao;
  }

  public String getCondutor() {
      return condutor;
  }

  public double getKms() {
      return kms;
  }

  public int getQualidade() {
      return qualidade;
  }

  public void setLocalizacao(Coordenadas localizacao) {
      this.localizacao = localizacao;
  }

  public void setCondutor(String condutor) {
      this.condutor = condutor;
  }

  public void setKms(double kms) {
      this.kms = kms;
  }

  public void setQualidade(int qualidade) {
      this.qualidade = qualidade;
  }

  public Viatura clone(){return new Viatura(this);}
}
