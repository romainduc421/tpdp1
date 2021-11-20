package interpreteur;

import java.util.ArrayList;

public class Moyenne extends Naire{
    public Moyenne(ArrayList<Nombre> e){
        super(e);
    }

    public Moyenne(Nombre... e){
        super(e);
    }

    public int valeur(){
        int ret = 0;
        for(Nombre nb : super.naire)
            ret = ret + nb.valeur();
        ret /= super.length();
        return ret;
    }

    public String toString(){
        return toStringPrefix();
    }



    public String toStringPrefix() {
        StringBuilder res = new StringBuilder();
        res.append("moyenne( ");
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
        res.append(" )moyenne");
        return res.toString();
    }
}
