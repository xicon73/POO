import java.util.*;
import java.io.*;
import static java.lang.System.out;


public class Coordenadas
{
    private int x;
    private int y;

    public Coordenadas(){
        this.x = 0;
        this.y = 0;
    }

    public Coordenadas(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Coordenadas(Coordenadas p){
        this.x = p.getX();
        this.y = p.getY();
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public boolean equal(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        else{
            Coordenadas p = (Coordenadas) o;
            return (this.x == p.getX() && this.y == p.getY());
        }
    }

    public Coordenadas clone(){
        return new Coordenadas(this);
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }


}
