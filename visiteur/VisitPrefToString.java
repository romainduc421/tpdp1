package visiteur;

public class VisitPrefToString extends Visiteur{

    @Override
    public void visit(Somme s) {
        res += "+ ";
        s.getGauche().accept(this);
        res+=" ";
        s.getDroit().accept(this);
    }

    public void visit(Nombre n){
        res += Integer.toString(n.valeur());
    }

    @Override
    public void visit(Difference d) {
        res += "- ";
        d.getGauche().accept(this);
        res+=" ";
        d.getDroit().accept(this);
    }

    @Override
    public void visit(Division di) {
        res += "÷ ";
        di.getGauche().accept(this);
        res+=" ";
        di.getDroit().accept(this);
    }

    @Override
    public void visit(Produit p) {
        res += "* ";
        p.getGauche().accept(this);
        res+=" ";
        p.getDroit().accept(this);
    }

    @Override
    public void visit(Moyenne m){
        res += ("moyenne( ");
        for (int i = 0; i < m.length(); i++)
        {
            if (i + 1 == m.length())
                m.getAtIndex(i).accept(this);
            else{
                m.getAtIndex(i).accept(this);
                res += ", ";
            }
        }
        res += " )";
    }

    @Override
    public void visit(SommeMultiple sm) {
        res += ("somme( ");
        for (int i = 0; i < sm.length(); i++)
        {
            if (i + 1 == sm.length())
                sm.getAtIndex(i).accept(this);
            else{
                sm.getAtIndex(i).accept(this);
                res += ", ";
            }
        }
        res += " )";
    }

    @Override
    public void visit(ProduitMultiple pm) {
        res += ("produit( ");
        for (int i = 0; i < pm.length(); i++)
        {
            if (i + 1 == pm.length())
                pm.getAtIndex(i).accept(this);
            else{
                pm.getAtIndex(i).accept(this);
                res += ", ";
            }
        }
        res += " )";
    }

    @Override
    public void visit(DifferenceMultiple dm) {
        res += ("difference( ");
        for (int i = 0; i < dm.length(); i++)
        {
            if (i + 1 == dm.length())
                dm.getAtIndex(i).accept(this);
            else{
                dm.getAtIndex(i).accept(this);
                res += ", ";
            }
        }
        res += " )";
    }

    @Override
    public void visit(DivisionMultiple dim) {
        res += ("division( ");
        for (int i = 0; i < dim.length(); i++)
        {
            if (i + 1 == dim.length())
                dim.getAtIndex(i).accept(this);
            else{
                dim.getAtIndex(i).accept(this);
                res += ", ";
            }
        }
        res += " )";
    }

    @Override
    public void visit(Max ma){
        res += ("max( ");
        for (int i = 0; i < ma.length(); i++)
        {
            if (i + 1 == ma.length())
                ma.getAtIndex(i).accept(this);
            else{
                ma.getAtIndex(i).accept(this);
                res += ", ";
            }
        }
        res += " )";
    }

    @Override
    public void visit(Min mi){
        res += ("min( ");
        for (int i = 0; i < mi.length(); i++)
        {
            if (i + 1 == mi.length())
                mi.getAtIndex(i).accept(this);
            else{
                mi.getAtIndex(i).accept(this);
                res += ", ";
            }
        }
        res += " )";
    }

}
