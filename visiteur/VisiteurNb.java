package visiteur;

public class VisiteurNb {

    private int res =0;

    public void visitN(Nombre nb){
        setRes(res+1);
    }
    public void visitN(Binaire bi){
        bi.getGauche().acceptN(this);bi.getDroit().acceptN(this);
    }

    public void visitN(Naire na){
        for(Nombre n : na.getNaire())
            n.acceptN(this);
    }

    public Object getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public void reset(){
        this.res = 0;
    }
}
