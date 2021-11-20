package visiteur;

import java.util.ArrayList;

public class SommeMultiple extends Naire {

    public SommeMultiple(Nombre... nbs){
        super(nbs);
    }
    public SommeMultiple(ArrayList<Nombre> nbs){
        super(nbs);
    }

    @Override
    public int valeur() {
        int ret = 0;
        for(Nombre nb : super.naire)
            ret = ret + nb.valeur();
        return ret;
    }

    @Override
    public void accept(Visiteur v) {
        v.visit(this);
    }

}
