package visiteur;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Expression n1 = new Nombre(4);
        Expression n2 = new Nombre(5);
        Expression n3 = new Nombre(6);
        Expression e1 = new Somme(n1, n2);
        Expression ee1 = new Somme(new Nombre(8),new Difference(new Nombre(2),new Nombre(7) ));
        Expression e2 = new Somme(e1, n3);
        Expression e3 = new Difference(e2,n1);
        Expression e4 = new Produit(e3, e1);
        Expression e5 = new Division(e4, new Somme(n2,n3));
        Expression e6 = new Moyenne((Nombre)n1, (Nombre)n3, new Nombre(e3.valeur()));
        ArrayList<Nombre> arr_nbs = new ArrayList<>(Arrays.asList((Nombre)n1, (Nombre)n3, new Nombre(e3.valeur())));
        Expression e7 = new Min(arr_nbs);
        Expression e8 = new Max(arr_nbs);
        Expression e9 = new SommeMultiple(arr_nbs);
        Expression e10 = new ProduitMultiple(arr_nbs);
        Expression e11 = new DifferenceMultiple(arr_nbs);
        Expression e12 = new DivisionMultiple(new Nombre((new Somme((Nombre)n1, (Nombre) n3)).valeur()),new Nombre(2),(Nombre) n2);

        assert ee1.valeur() == 3;
        assert (e2.valeur()==15):"Bug";
        assert (e1.valeur()==9):"Bug";
        assert (e3.valeur()==11):"Bug";
        assert (e4.valeur()==99):"Bug";
        assert (e5.valeur()==9):"Bug";
        assert e6.valeur()==7:"Bug";
        assert e7.valeur()==4:"Bug";
        assert e8.valeur()==11:"Bug";
        assert e9.valeur()==21:"Bug";
        assert e10.valeur()==264:"Bug";
        assert e11.valeur()==-13:"Bug";
        assert e12.valeur()==1 : "Bug";

        VisiteurNb visitorNb = new VisiteurNb();
        Object res;
        ee1.acceptN(visitorNb);
        res = (int) visitorNb.getRes();
        assert ((int)res)==3:"Bug";
        visitorNb.reset();
        e2.acceptN(visitorNb);
        res = (int) visitorNb.getRes();
        assert ((int)res)==3 :"Bug";
        visitorNb.reset();
        e1.acceptN(visitorNb);
        res = (int)(visitorNb).getRes();
        assert res.equals(2) :"Bug";
        visitorNb.reset();
        e3.acceptN(visitorNb);
        res = (int)(visitorNb).getRes();
        assert res.equals(4) :"Bug";
        visitorNb.reset();
        e4.acceptN(visitorNb);
        res = (int)(visitorNb).getRes();
        assert res.equals(6) :"Bug";
        visitorNb.reset();
        e5.acceptN(visitorNb);
        res = (int)(visitorNb).getRes();
        assert res.equals(8) :"Bug";
        visitorNb.reset();
        e6.acceptN(visitorNb);
        res = (int)(visitorNb).getRes();
        assert res.equals(3) :"Bug";
        visitorNb.reset();
        e7.acceptN(visitorNb);
        res = (int)(visitorNb).getRes();
        assert res.equals(3) :"Bug";
        visitorNb.reset();
        e8.acceptN(visitorNb);
        res = (int)(visitorNb).getRes();
        assert res.equals(3) :"Bug";
        visitorNb.reset();
        e9.acceptN(visitorNb);
        res = (int)(visitorNb).getRes();
        assert res.equals(3) :"Bug";
        visitorNb.reset();
        e10.acceptN(visitorNb);
        res = (int)(visitorNb).getRes();
        assert res.equals(3) :"Bug";
        visitorNb.reset();
        e11.acceptN(visitorNb);
        res = (int)(visitorNb).getRes();
        assert res.equals(3) :"Bug";
        visitorNb.reset();
        e12.acceptN(visitorNb);
        res = (int)(visitorNb).getRes();
        assert res.equals(3) :"Bug";

        /*assert (e1.nbDeNombres()==2):"Bug";
        assert (e3.nbDeNombres()==4):"Bug";
        assert (e4.nbDeNombres()==6):"Bug";
        assert (e5.nbDeNombres()==8):"Bug";
        assert e6.nbDeNombres()==3:"Bug";
        assert e7.nbDeNombres()==3:"Bug";
        assert e8.nbDeNombres()==3:"Bug";
        assert e9.nbDeNombres()==3:"Bug";
        assert e10.nbDeNombres()==3:"Bug";
        assert e11.nbDeNombres()==3:"Bug";
        assert e12.nbDeNombres()==3:"Bug";*/

        VisitToString visitor = new VisitToString();
        VisitPrefToString visitorPref = new VisitPrefToString();
        VisitPostToString visitorPost = new VisitPostToString();

        e1.accept(visitor);
        res = (String) visitor.getRes();
        System.out.println(res);
        assert(res.equals( "( 4 + 5 )" )):"bug toString() Somme";

        visitor.reset();
        ee1.accept(visitor);
        res = (String) visitor.getRes();
        System.out.println(res);
        assert res.equals("( 8 + ( 2 - 7 ) )");

        e1.accept(visitorPref);
        res = (String) visitorPref.getRes();
        assert (res.equals("+ 4 5")):"bug";

        e1.accept(visitorPost);
        res = (String) visitorPost.getRes();
        assert (res.equals("4 5 +")):"bug";

        visitor.reset();
        e2.accept(visitor);
        res = (String) visitor.getRes();
        System.out.println(res);
        assert(res.equals( "( ( 4 + 5 ) + 6 )" )):"bug toString() Somme";

        visitorPref.reset();
        e2.accept(visitorPref);
        res = (String) visitorPref.getRes();
        assert (res.equals("+ + 4 5 6")):"bug";

        visitorPost.reset();
        e2.accept(visitorPost);
        res = (String) visitorPost.getRes();
        assert (res.equals("4 5 + 6 +")):"bug";

        visitor.reset();
        n1.accept(visitor);
        res = (String) visitor.getRes();
        assert(res.equals( "4" )):"bug toString() Nombre";

        visitor.reset();
        e3.accept(visitor);
        res = (String) visitor.getRes();
        System.out.println(res);
        assert (res.equals( "( ( ( 4 + 5 ) + 6 ) - 4 )" )):"bug toString Difference";

        visitorPref.reset();
        e3.accept(visitorPref);
        res = (String) visitorPref.getRes();
        assert (res.equals("- + + 4 5 6 4")):"bug";

        visitorPost.reset();
        e3.accept(visitorPost);
        res = (String) visitorPost.getRes();
        assert (res.equals("4 5 + 6 + 4 -")):"bug";

        visitor.reset();
        e4.accept(visitor);
        res = (String) visitor.getRes();
        System.out.println(res);
        assert (res.equals( "( ( ( ( 4 + 5 ) + 6 ) - 4 ) * ( 4 + 5 ) )" )):"bug toString Produit";

        visitorPref.reset();
        e4.accept(visitorPref);
        res = (String) visitorPref.getRes();
        assert (res.equals("* - + + 4 5 6 4 + 4 5")):"bug";

        visitorPost.reset();
        e4.accept(visitorPost);
        res = (String) visitorPost.getRes();
        assert (res.equals("4 5 + 6 + 4 - 4 5 + *")):"bug";

        visitor.reset();
        e5.accept(visitor);
        res = (String) visitor.getRes();
        System.out.println(res);
        assert (res.equals( "( ( ( ( ( 4 + 5 ) + 6 ) - 4 ) * ( 4 + 5 ) ) ÷ ( 5 + 6 ) )" )):"bug toString Division";

        visitorPref.reset();
        e5.accept(visitorPref);
        res = (String) visitorPref.getRes();
        assert (res.equals("÷ * - + + 4 5 6 4 + 4 5 + 5 6")):"bug";

        visitorPost.reset();
        e5.accept(visitorPost);
        res = (String) visitorPost.getRes();
        assert (res.equals("4 5 + 6 + 4 - 4 5 + * 5 6 + ÷")):"bug";

        visitor.reset();
        e6.accept(visitor);
        res = (String) visitor.getRes();
        System.out.println(res);
        assert (res.equals("moyenne( 4, 6, 11 )")):"bug toString Moyenne";
        System.out.println("ecriture infixee non existante pour l'operateur moyenne car ( ( 4 moyenne 6 ) moyenne 11 ) = 8" +"\ndifferent de moyenne( 4, 6, 11 ) = 7\n");

        visitorPref.reset();
        e6.accept(visitorPref);
        res = (String) visitorPref.getRes();
        assert (res.equals("moyenne( 4, 6, 11 )")):"bug toStringPrefix Moyenne";

        visitorPost.reset();
        e6.accept(visitorPost);
        res = (String) visitorPost.getRes();
        assert (res.equals("( 4, 6, 11 )moyenne")):"bug toStringPostfix Moyenne";

        visitor.reset();
        e7.accept(visitor);
        res = (String) visitor.getRes();
        System.out.println(res);
        assert (res.equals("( ( 4 min 6 ) min 11 )")):"bug toString Min";

        visitorPref.reset();
        e7.accept(visitorPref);
        res = (String) visitorPref.getRes();
        assert (res.equals("min( 4, 6, 11 )")):"bug toStringPrefix Min";

        visitorPost.reset();
        e7.accept(visitorPost);
        res = (String) visitorPost.getRes();
        assert (res.equals("( 4, 6, 11 )min")):"bug toStringPostfix Min";

        visitor.reset();
        e8.accept(visitor);
        res = (String) visitor.getRes();
        System.out.println(res);
        assert (res.equals("( ( 4 max 6 ) max 11 )")):"bug toString Max";

        visitorPref.reset();
        e8.accept(visitorPref);
        res = (String) visitorPref.getRes();
        assert (res.equals("max( 4, 6, 11 )")):"bug toStringPrefix Max";

        visitorPost.reset();
        e8.accept(visitorPost);
        res = (String) visitorPost.getRes();
        assert (res.equals("( 4, 6, 11 )max")):"bug toStringPostfix Max";

        visitor.reset();
        e9.accept(visitor);
        res = (String) visitor.getRes();
        System.out.println(res);
        assert (res.equals("( ( 4 somme 6 ) somme 11 )")):"bug toString SommeMultiple";

        visitorPref.reset();
        e9.accept(visitorPref);
        res = (String) visitorPref.getRes();
        assert (res.equals("somme( 4, 6, 11 )")):"bug toStringPrefix SommeMultiple";

        visitorPost.reset();
        e9.accept(visitorPost);
        res = (String) visitorPost.getRes();
        assert (res.equals("( 4, 6, 11 )somme")):"bug toStringPostfix SommeMultiple";

        visitor.reset();
        e10.accept(visitor);
        res = (String) visitor.getRes();
        System.out.println(res);
        assert (res.equals("( ( 4 produit 6 ) produit 11 )")):"bug toString ProduitMultiple";

        visitorPref.reset();
        e10.accept(visitorPref);
        res = (String) visitorPref.getRes();
        assert (res.equals("produit( 4, 6, 11 )")):"bug toStringPrefix ProduitMultiple";

        visitorPost.reset();
        e10.accept(visitorPost);
        res = (String) visitorPost.getRes();
        assert (res.equals("( 4, 6, 11 )produit")):"bug toStringPostfix ProduitMultiple";

        visitor.reset();
        e11.accept(visitor);
        res = (String) visitor.getRes();
        System.out.println(res);
        assert (res.equals("( ( 4 difference 6 ) difference 11 )")):"bug toString DifferenceMultiple";

        visitorPref.reset();
        e11.accept(visitorPref);
        res = (String) visitorPref.getRes();
        assert (res.equals("difference( 4, 6, 11 )")):"bug toStringPrefix DifferenceMultiple";

        visitorPost.reset();
        e11.accept(visitorPost);
        res = (String) visitorPost.getRes();
        assert (res.equals("( 4, 6, 11 )difference")):"bug toStringPostfix DifferenceMultiple";

        visitor.reset();
        e12.accept(visitor);
        res = (String) visitor.getRes();
        System.out.println(res);
        assert (res.equals("( ( 10 division 2 ) division 5 )")):"bug toString DivisionMultiple";

        visitorPref.reset();
        e12.accept(visitorPref);
        res = (String) visitorPref.getRes();
        assert (res.equals("division( 10, 2, 5 )")):"bug toStringPrefix DivisionMultiple";

        visitorPost.reset();
        e12.accept(visitorPost);
        res = (String) visitorPost.getRes();
        assert (res.equals("( 10, 2, 5 )division")):"bug toStringPostfix DivisionMultiple";
    }
}
