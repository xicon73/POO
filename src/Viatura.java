import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class Viatura {
  private Coordenadas localizacao;
  private Motorista condutor;
  private Int kms;
  private Int qualidade;


  public Viatura(){
      this.localizacao = "";
      this.condutor = "";
      this.kms = 0;
      this.qualidade = 0;
  }
  public Viatura(Coordenadas localizacao, Motorista condutor, Int kms, Int qualidade){
      this.localizacao = localizacao.clone();
      this.condutor = condutor.clone();
      this.km = km;
      this.qualidade = qualidade;
  }

  public Viatura(Viatura m){
      this.localizacao = m.getLocalizacao();
      this.condutor = m.getCondutor();
      this.kms = m.getKms();
      this.qualidade = m.getQualidade();
  }

  public Coordenadas getLocalizacao() {
      return localizacao;
  }

  public Motorista getCondutor() {
      return condutor;
  }

  public Int getKms() {
      return kms;
  }

  public Int getQualidade() {
      return qualidade;
  }

  public void setLocalizacao(Coordenadas localizacao) {
      this.localizacao = localizacao;
  }

  public void setCondutor(Motorista condutor) {
      this.condutor = condutor;
  }

  public void setKms(Int kms) {
      this.kms = kms;
  }

  public void setQualdiade(Int qualidade) {
      this.qualidade = qualidade;
  }


}
