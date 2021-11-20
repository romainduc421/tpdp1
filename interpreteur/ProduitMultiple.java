package interpreteur;

import java.util.ArrayList;

public class ProduitMultiple extends Naire{

    public ProduitMultiple(Nombre... nbs){
        super(nbs);
    }
    public ProduitMultiple(ArrayList<Nombre> nbs){
        super(nbs);
    }

    public int valeur() {
        int ret = 1;
        for(Nombre nb : super.naire)
            ret *= nb.valeur();
        return ret;
    }


    public String toStringPrefix() {
        StringBuilder res = new StringBuilder();
        res.append("produit( ");
        for (int i = 0; i < length(); i++)
        {
            if (i + 1 == length())
                res.append(super.getAtIndex(i).toString());
            else
                res.append(super.getAtIndex(i).toString()).append(", ");
        }
        res.append(" )");
        return res.toString();
    }


    public String toStringPostfix() {
        StringBuilder res = new StringBuilder();
        res.append("( ");
        for (int i = 0; i < length(); i++)
        {
            if (i + 1 == length())
                res.append(super.getAtIndex(i).toString());
            else
                res.append(super.getAtIndex(i).toString()).append(", ");
        }
        res.append(" )produit");
        return res.toString();
    }

    public String toStringh(int rk) {
        StringBuilder res = new StringBuilder();
        if (rk == length() - 1)
            res.append(" produit ").append(super.getAtIndex(rk).toString()).append(" )");
        else {
            for (int m = 0; m <= length() - rk; m += 2)
                res.append("( ");
            res.append(super.getAtIndex(rk).toString()).append(" produit ").append(super.getAtIndex(rk + 1).toString()).append(" )");
        }
        return res.toString();
    }

    public String toString()
    {
        StringBuilder res = new StringBuilder();
        for(int k=0; k < length(); k=k+2)
            res.append(toStringh(k));
        return res.toString();
    }
}
