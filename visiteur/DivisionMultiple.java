package visiteur;

import java.util.ArrayList;

public class DivisionMultiple extends Naire{
    public DivisionMultiple(Nombre... nbs){
        super(nbs);
    }
    public DivisionMultiple(ArrayList<Nombre> nbs){
        super(nbs);
    }

    @Override
    public int valeur() {
        int ret = super.getAtIndex(0).valeur();
        for(int k=1; k<super.length(); k++)
            ret /= super.getAtIndex(k).valeur();
        return ret;
    }

    @Override
    public void accept(Visiteur v) {
        v.visit(this);
    }
}
