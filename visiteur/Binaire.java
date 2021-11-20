package visiteur;

import java.util.Objects;

public abstract class Binaire implements Expression {
    protected Expression gauche ;
    protected Expression droit ;
    protected Binaire(Expression gauche, Expression droit) {
        this.gauche = gauche ;
        this.droit = droit ;
    }

    public Expression getGauche() {
        return gauche;
    }

    public void setGauche(Expression gauche) {
        this.gauche = gauche;
    }

    public Expression getDroit() {
        return droit;
    }

    public void setDroit(Expression droit) {
        this.droit = droit;
    }

    @Override
    public abstract void accept(Visiteur v);

    @Override
    public void acceptN(VisiteurNb vn){
        vn.visitN(this);
    }

}
