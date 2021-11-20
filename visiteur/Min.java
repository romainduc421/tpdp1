package visiteur;

import java.util.ArrayList;

public class Min extends Naire {

    public Min(Nombre... e) {
        super(e);
    }
    public Min(ArrayList<Nombre> e) {
        super(e);
    }

    @Override
    public int valeur() {
        int res = super.getAtIndex(0).valeur();
        for (Nombre nombre : naire)
            if (nombre.valeur() < res)
                res = nombre.valeur();
        return res;
    }

    @Override
    public void accept(Visiteur v) {
        v.visit(this);
    }


}
