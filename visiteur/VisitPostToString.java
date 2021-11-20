package visiteur;

public class VisitPostToString extends Visiteur{

    @Override
    public void visit(Somme s) {
        s.getGauche().accept(this);
        this.res+=" ";
        s.getDroit().accept(this);
        this.res += " +";
    }

    @Override
    public void visit(Difference d) {
        d.getGauche().accept(this);
        this.res+=" ";
        d.getDroit().accept(this);
        this.res += " -";
    }

    @Override
    public void visit(Division di) {
        di.getGauche().accept(this);
        this.res+=" ";
        di.getDroit().accept(this);
        this.res += " ÷";
    }

    @Override
    public void visit(Produit p) {
        p.getGauche().accept(this);
        this.res+=" ";
        p.getDroit().accept(this);
        this.res += " *";
    }

    @Override
    public void visit(Moyenne m) {
        res += ("( ");
        for (int i = 0; i < m.length(); i++)
        {
            if (i + 1 == m.length())
                m.getAtIndex(i).accept(this);
            else{
                m.getAtIndex(i).accept(this);
                res += ", ";
            }
        }
        res += " )moyenne";
    }



    @Override
    public void visit(SommeMultiple sm) {
        res += ("( ");
        for (int i = 0; i < sm.length(); i++)
        {
            if (i + 1 == sm.length())
                sm.getAtIndex(i).accept(this);
            else{
                sm.getAtIndex(i).accept(this);
                res += ", ";
            }
        }
        res += " )somme";
    }

    @Override
    public void visit(ProduitMultiple pm) {
        res += ("( ");
        for (int i = 0; i < pm.length(); i++)
        {
            if (i + 1 == pm.length())
                pm.getAtIndex(i).accept(this);
            else{
                pm.getAtIndex(i).accept(this);
                res += ", ";
            }
        }
        res += " )produit";
    }

    @Override
    public void visit(DifferenceMultiple dm) {
        res += ("( ");
        for (int i = 0; i < dm.length(); i++)
        {
            if (i + 1 == dm.length())
                dm.getAtIndex(i).accept(this);
            else{
                dm.getAtIndex(i).accept(this);
                res += ", ";
            }
        }
        res += " )difference";
    }

    @Override
    public void visit(DivisionMultiple dim) {
        res += ("( ");
        for (int i = 0; i < dim.length(); i++)
        {
            if (i + 1 == dim.length())
                dim.getAtIndex(i).accept(this);
            else{
                dim.getAtIndex(i).accept(this);
                res += ", ";
            }
        }
        res += " )division";
    }

    @Override
    public void visit(Min mi) {
        res += ("( ");
        for (int i = 0; i < mi.length(); i++)
        {
            if (i + 1 == mi.length())
                mi.getAtIndex(i).accept(this);
            else{
                mi.getAtIndex(i).accept(this);
                res += ", ";
            }
        }
        res += " )min";
    }

    @Override
    public void visit(Max ma) {
        res += ("( ");
        for (int i = 0; i < ma.length(); i++)
        {
            if (i + 1 == ma.length())
                ma.getAtIndex(i).accept(this);
            else{
                ma.getAtIndex(i).accept(this);
                res += ", ";
            }
        }
        res += " )max";
    }

    @Override
    public void visit(Nombre n){
        this.res += Integer.toString(n.valeur());
    }

}
