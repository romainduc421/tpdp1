package visiteur;

public class Difference extends Binaire{
    public Difference(Expression gauche, Expression droit) {
        super(gauche, droit) ;
    }
    @Override
    public int valeur() {
        return gauche.valeur() - droit.valeur();
    }
    @Override
    public void accept(Visiteur v){
        v.visit(this) ;
    }

}
