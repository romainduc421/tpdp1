package visiteur;

public class Somme extends Binaire {
    public Somme(Expression gauche, Expression droit) {
        super(gauche, droit) ;
    }
    @Override
    public int valeur() {
        return gauche.valeur() + droit.valeur();
    }
    @Override
    public void accept(Visiteur v){
        v.visit(this) ;
    }

}
