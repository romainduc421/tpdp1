package visiteur;

public class VisitToString extends Visiteur{

    //private Object res = "";

    @Override
    public void visit(Somme s){
        res+="( ";
        s.getGauche().accept(this);
        res+=" + ";
        s.getDroit().accept(this);
        res += " )";
    }

    @Override
    public void visit(Difference d){
        res +="( ";
        d.getGauche().accept(this);
        res+=" - ";
        d.getDroit().accept(this);
        res += " )";
    }

    @Override
    public void visit(Division di){
        res += "( ";
        di.getGauche().accept(this);
        res+=" ÷ ";
        di.getDroit().accept(this);
        res += " )";
    }

    @Override
    public void visit(Produit p){
        res += "( ";
        p.getGauche().accept(this);
        res+=" * ";
        p.getDroit().accept(this);
        res += " )";
    }

    @Override
    public void visit(Moyenne m) {
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
        for (int k = 0; k < sm.length(); k = k + 2){
            if (k == sm.length() - 1) {
                res += " somme ";
                sm.getAtIndex(k).accept(this);
                res += " )";
            } else {
                for (int m = 0; m <= sm.length() - k; m += 2)
                    res += "( ";
                sm.getAtIndex(k).accept(this);
                res += " somme ";
                sm.getAtIndex(k + 1).accept(this);
                res += " )";
            }
        }
    }

    @Override
    public void visit(ProduitMultiple pm) {
        for (int k = 0; k < pm.length(); k = k + 2){
            if (k == pm.length() - 1) {
                res += " produit ";
                pm.getAtIndex(k).accept(this);
                res += " )";
            } else {
                for (int m = 0; m <= pm.length() - k; m += 2)
                    res += "( ";
                pm.getAtIndex(k).accept(this);
                res += " produit ";
                pm.getAtIndex(k + 1).accept(this);
                res += " )";
            }
        }
    }

    @Override
    public void visit(DifferenceMultiple dm) {
        for (int k = 0; k < dm.length(); k = k + 2){
            if (k == dm.length() - 1) {
                res += " difference ";
                dm.getAtIndex(k).accept(this);
                res += " )";
            } else {
                for (int m = 0; m <= dm.length() - k; m += 2)
                    res += "( ";
                dm.getAtIndex(k).accept(this);
                res += " difference ";
                dm.getAtIndex(k + 1).accept(this);
                res += " )";
            }
        }
    }

    @Override
    public void visit(DivisionMultiple dim) {
        for (int k = 0; k < dim.length(); k = k + 2){
            if (k == dim.length() - 1) {
                res += " division ";
                dim.getAtIndex(k).accept(this);
                res += " )";
            } else {
                for (int m = 0; m <= dim.length() - k; m += 2)
                    res += "( ";
                dim.getAtIndex(k).accept(this);
                res += " division ";
                dim.getAtIndex(k + 1).accept(this);
                res += " )";
            }
        }
    }

    @Override
    public void visit(Min mi) {
        for (int k = 0; k < mi.length(); k = k + 2){
            if (k == mi.length() - 1) {
                res += " min ";
                mi.getAtIndex(k).accept(this);
                res += " )";
            } else {
                for (int m = 0; m <= mi.length() - k; m += 2)
                    res += "( ";
                mi.getAtIndex(k).accept(this);
                res += " min ";
                mi.getAtIndex(k + 1).accept(this);
                res += " )";
            }
        }
    }

    @Override
    public void visit(Max ma) {
        for (int k = 0; k < ma.length(); k = k + 2){
            if (k == ma.length() - 1) {
                res += " max ";
                ma.getAtIndex(k).accept(this);
                res += " )";
            } else {
                for (int m = 0; m <= ma.length() - k; m += 2)
                    res += "( ";
                ma.getAtIndex(k).accept(this);
                res += " max ";
                ma.getAtIndex(k + 1).accept(this);
                res += " )";
            }
        }
    }

    @Override
    public void visit(Nombre n){
        res += Integer.toString(n.valeur());
    }



}
