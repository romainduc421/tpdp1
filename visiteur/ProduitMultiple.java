package visiteur;

import java.util.ArrayList;

public class ProduitMultiple extends Naire{

    public ProduitMultiple(Nombre... nbs){
        super(nbs);
    }
    public ProduitMultiple(ArrayList<Nombre> nbs){
        super(nbs);
    }

    @Override
    public int valeur() {
        int ret = 1;
        for(Nombre nb : super.naire)
            ret *= nb.valeur();
        return ret;
    }

    @Override
    public void accept(Visiteur v) {
        v.visit(this);
    }
}
