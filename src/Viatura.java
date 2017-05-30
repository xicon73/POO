import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class Viatura {
  private int capacidade;
  private int velocidade;
  private int preco_base;
  private Coordenadas localizacao;
  private String condutor //atual;
  private int kms;
  private int qualidade;
  //private String[] condutores


  public Viatura(){
      this.capacidade = 0;
      this.velocidade = 0;
      this.preco_base = 0;
      this.localizacao = new Coordenadas();
      this.condutor = "";
      this.kms = 0;
      this.qualidade = 0;
  }
  public Viatura(int capacidade, int velocidade, int preco_base, Coordenadas localizacao, String condutor, int kms, int qualidade){
      this.capacidade = capacidade;
      this.velocidade = velocidade;
      this.preco_base = preco_base;
      this.localizacao = localizacao.clone();
      this.condutor = condutor.clone();
      this.kms = kms;
      this.qualidade = qualidade;
  }

  public Viatura(Viatura m){
      this.capacidade = m.getCapacidade();
      this.velocidade = m.getVelocidade();
      this.preco_base = m.getPreco_base();
      this.localizacao = m.getLocalizacao();
      this.condutor = m.getCondutor();
      this.kms = m.getKms();
      this.qualidade = m.getQualidade();
  }

  public TreeMap<String, condutor> getLivres (int capacidade, Coordenadas cliente) {
      TreeMap<String, condutor> motoristasLivres = new TreeMap<String, condutor>;
      return motoristasLivres;
  }

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

  public int getPreco_base() {
      return preco_base;
    }

  public void setPreco_base(int preco_base) {
      this.preco_base = preco_base;
    }
  
  
  public Coordenadas getLocalizacao() {
      return localizacao;
  }

  public Motorista getCondutor() {
      return condutor;
  }

  public int getKms() {
      return kms;
  }

  public int getQualidade() {
      return qualidade;
  }

  public void setLocalizacao(Coordenadas localizacao) {
      this.localizacao = localizacao;
  }

  public void setCondutor(Motorista condutor) {
      this.condutor = condutor;
  }

  public void setKms(int kms) {
      this.kms = kms;
  }

  public void setQualdiade(int qualidade) {
      this.qualidade = qualidade;
  }

  public Viatura clone(){return new Viatura(this);}
}
