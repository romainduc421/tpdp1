package visiteur;

public abstract class Visiteur {

    protected Object res="";
    public abstract void visit(Somme s);
    public abstract void visit(Nombre n);
    public abstract void visit(Difference d);
    public abstract void visit(Division di);
    public abstract void visit(Produit p);
    public abstract void visit(Moyenne m);
    public abstract void visit(SommeMultiple sm);
    public abstract void visit(ProduitMultiple pm);
    public abstract void visit(DifferenceMultiple dm);
    public abstract void visit(DivisionMultiple dim);
    public abstract void visit(Min mi);
    public abstract void visit(Max ma);

    public void reset(){
        setRes("");
    }

    public Object getRes() {
        return res;
    }

    public void setRes(Object res) {
        this.res = res;
    }
}
