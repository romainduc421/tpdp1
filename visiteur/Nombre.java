package visiteur;

import java.util.Objects;

public class Nombre implements Expression {
    protected int valeur ;
    public Nombre(int val) {
        this.valeur  = val;
    }

    @Override
    public int valeur() {
        return valeur;
    }
    @Override
    public void accept(Visiteur v){
        v.visit(this);
    }

    @Override
    public void acceptN(VisiteurNb vn) {
        vn.visitN(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombre nombre = (Nombre) o;
        return valeur == nombre.valeur;
    }
}
