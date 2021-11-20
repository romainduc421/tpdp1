package visiteur;

import java.util.ArrayList;

public class DifferenceMultiple extends Naire{
    public DifferenceMultiple(Nombre... nbs){
        super(nbs);
    }
    public DifferenceMultiple(ArrayList<Nombre> nbs){
        super(nbs);
    }

    @Override
    public int valeur() {
        int ret = super.getAtIndex(0).valeur();
        for(int k=1; k<super.length(); k++)
            ret -= super.getAtIndex(k).valeur();
        return ret;
    }

    @Override
    public void accept(Visiteur v) {
        v.visit(this);
    }

}
