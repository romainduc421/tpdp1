package visiteur;

import java.util.ArrayList;

public class Moyenne extends Naire {
    public Moyenne(ArrayList<Nombre> e){
        super(e);
    }

    public Moyenne(Nombre... e){
        super(e);
    }

    @Override
    public int valeur(){
        int ret = 0;
        for(Nombre nb : super.naire)
            ret = ret + nb.valeur();
        ret /= super.length();
        return ret;
    }

    @Override
    public void accept(Visiteur v) {
        v.visit(this);
    }

}
