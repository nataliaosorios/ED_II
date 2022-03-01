import java.util.LinkedList;
public class Vertice {
    
    int dato;
    LinkedList<Integer> adyacentes;
    public Vertice(int dato){
        this.dato = dato;
        adyacentes = new LinkedList<Integer>();
    }

    public int getDato(){
        return dato;
    }

    public LinkedList<Integer> getAdyacentes(){
        return adyacentes;
    }
}
