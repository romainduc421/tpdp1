package interpreteur;

import java.util.ArrayList;

public class Max extends Naire{
    public Max(Nombre ... e)
    {
        super(e);
    }

    public Max(ArrayList<Nombre> e)
    {
        super(e);
    }

    public int valeur()
    {
        int res = naire.get(0).valeur();
        for (Nombre nombre : naire)
            if (nombre.valeur() > res)
                res = nombre.valeur();

        return res;
    }

    public String toStringh( int rk) {
        StringBuilder res = new StringBuilder();
        if (rk == length() - 1)
            res.append(" max ").append(super.getAtIndex(rk).toString()).append(" )");
        else {
            for (int m = 0; m <= length() - rk; m += 2)
                res.append("( ");
            res.append(super.getAtIndex(rk).toString()).append(" max ").append(super.getAtIndex(rk+1).toString()).append(" )");
        }
        return res.toString();
    }

    public String toString()
    {
        StringBuilder res = new StringBuilder();
        for(int k=0; k < length(); k=k+2)
            res.append(toStringh( k));
        return res.toString();
    }

    public String toStringPrefix(){
        //pas d'ecriture infixee pour les operateurs n-aires
        StringBuilder res = new StringBuilder();
        res.append("max( ");
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

    public String toStringPostfix(){
        StringBuilder res = new StringBuilder();
        res.append("( ");
        for (int i = 0; i < length(); i++)
        {
            if (i + 1 == length())
                res.append(super.getAtIndex(i).toString());
            else
                res.append(super.getAtIndex(i).toString()).append(", ");
        }
        res.append(" )max");
        return res.toString();
    }
}
