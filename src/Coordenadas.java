import java.util.*;
import java.io.*;
import static java.lang.System.out;


public class Coordenadas implements java.io.Serializable
{
    private double x, y;

    public Coordenadas(){
        this.x = 0;
        this.y = 0;
    }
    public Coordenadas(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Coordenadas(Coordenadas c){
        this.x = c.getX();
        this.y = c.getY();
    }

    public double getX(){ return this.x; }
    public double getY(){ return this.y; }
    public void setX(double x){ this.x = x; }
    public void setY(double y){ this.y = y; }

    /*public String toString(){
        StringBuilder sb = new StringBuilder();
        String xxs, yys;
        sb.append("("+Math.abs(this.x)+"º "+ xxs +", "+Math.abs(this.y)+"º "+ yys +")");
        return sb.toString();
    }*/

    public boolean equals(Object o){
        if(this == o) return true;
        if((o==null) || (this.getClass() != o.getClass())) return false;
        Coordenadas a = (Coordenadas) o;
        return (this.x == a.getX() && this.y == a.getY());
    }

    public double getDistancia(Coordenadas p2) {
        return Math.sqrt(
                (this.getX() - p2.getX()) *  (this.getX() - p2.getX()) +
                        (this.getY() - p2.getY()) *  (this.getY() - p2.getY())
        );
    }

    public Coordenadas clone(){
        return new Coordenadas(this);
    }
}
