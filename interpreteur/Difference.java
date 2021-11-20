package interpreteur;

public class Difference extends Binaire{
    public Difference(Expression gauche, Expression droit) {
        super(gauche, droit) ;
    }
    public int valeur() {
        return gauche.valeur() - droit.valeur();
    }
    public String toString(){
        return "( "+getGauche().toString()+" - "+getDroit().toString()+" )";
    }
    public String toStringPrefix(){
        return "- "+getGauche().toStringPrefix()+" "+getDroit().toStringPrefix() ;
    }
    public String toStringPostfix(){
        return getGauche().toStringPostfix() + " "+ getDroit().toStringPostfix()+" -";
    }
}
