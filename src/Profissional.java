import java.util.*;
import java.io.*;
import static java.lang.System.out;


public class Profissional extends Motorista {
    private String empresa;
    private String[] viaturas;

    public Profissional(){
        super();
        this.empresa = "";
        this.viaturas = new String[];
    }

    public Profissional(String email, String password, String nome, String morada, GregorianCalendar d, int [] array, double kms, int estado, int carro, String empresa, String[] viaturas) {
        super(email,password,nome,morada,d,array,kms,estado,carro);
        this.empresa = empresa;
        this.viaturas = viaturas;
    }

    public Profissional(Profissional p){
        super(p);
        this.empresa = p.getEmpresa();
        this.viaturas = p.getViaturas();
    }

    public setEmpresa (String empresa) {this.empresa=empresa;}

    public setViaturas (String [] viaturas) {this.viaturas = viaturas;}

    public getEmpresa() {return empresa;}

    public getViaturas(){return viaturas;}

    public Profissional clone(){return new Profissional(m : this);}

}
