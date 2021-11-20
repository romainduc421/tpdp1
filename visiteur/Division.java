package visiteur;

public class Division extends Binaire{
    public Division(Expression gauche, Expression droit) {
        super(gauche, droit) ;
    }

    @Override
    public int valeur() {
        return gauche.valeur() / droit.valeur();
    }
    @Override
    public void accept(Visiteur v){
        v.visit(this) ;
    }

}
