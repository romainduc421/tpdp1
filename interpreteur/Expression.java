package interpreteur;

public interface Expression {
    public int valeur() ;
    public String toString();
    public String toStringPrefix();
    public String toStringPostfix();
    public int nbDeNombres();
}
