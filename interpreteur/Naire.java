package interpreteur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Naire implements Expression{

    protected List<Nombre> naire;

    public Naire(Nombre... nbs)
    {
        this.naire = new ArrayList<Nombre>(Arrays.asList(nbs));
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

    public int nbDeNombres(){
        return this.length();
    }
}
