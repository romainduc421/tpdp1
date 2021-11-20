package visiteur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Naire implements Expression {

    protected List<Nombre> naire;

    public Naire(Nombre... nbs)
    {
        this.naire = new ArrayList<>(Arrays.asList(nbs));
    }

    public Naire(ArrayList<Nombre> nbs)
    {
        this.naire = nbs;
    }

    public int length(){
        return naire.size();
    }

    public Nombre getAtIndex(int indx){
        return this.naire.get(indx);
    }

    @Override
    public abstract void accept(Visiteur v);

    public List<Nombre> getNaire() {
        return naire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Naire naire1 = (Naire) o;
        return Objects.equals(naire, naire1.naire);
    }

    @Override
    public void acceptN(VisiteurNb vn){
        vn.visitN(this);
    }

}
