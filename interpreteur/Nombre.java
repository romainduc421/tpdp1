package interpreteur;

public class Nombre implements Expression {
    protected int valeur ;
    public Nombre(int val) {
        this.valeur  = val;
    }

    public int valeur() {
        return valeur;
    }
    public String toString(){
        return Integer.toString(valeur());
    }
    public String toStringPrefix(){
        return Integer.toString(valeur());
    }
    public String toStringPostfix(){
        return Integer.toString(valeur());
    }

    public int nbDeNombres(){
        return 1;
    }

}
