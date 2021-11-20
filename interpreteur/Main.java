package interpreteur;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Expression n1 = new Nombre(4);
        Expression n2 = new Nombre(5);
        Expression n3 = new Nombre(6);
        Expression e1 = new Somme(n1, n2);
        Expression e2 = new Somme(e1, n3);
        Expression e3 = new Difference(e2, n1);
        Expression e4 = new Produit(e3, e1);
        Expression e5 = new Division(e4, new Somme(n2,n3));
        Expression e6 = new Moyenne((Nombre)n1, (Nombre)n3, new Nombre(e3.valeur()));
        ArrayList<Nombre> arr_nbs = new ArrayList<>(Arrays.asList((Nombre) n1, (Nombre) n3, new Nombre(e3.valeur())));
        Expression e7 = new Min(arr_nbs);
        Expression e8 = new Max(arr_nbs);
        Expression e9 = new SommeMultiple(arr_nbs);
        Expression e10 = new ProduitMultiple(arr_nbs);
        Expression e11 = new Difference(e10,e9);
        assert e2.nbDeNombres()==3 : "Bug";
        assert e1.nbDeNombres()==2 : "Bug";
        assert e3.nbDeNombres()==4 : "Bug";
        assert e4.nbDeNombres()==6 : "Bug";
        assert e5.nbDeNombres()==8 : "Bug";
        assert e6.nbDeNombres()==3 : "Bug";
        assert e7.nbDeNombres()==3 : "Bug";
        assert e8.nbDeNombres()==3 : "Bug";
        assert e9.nbDeNombres()==3 : "Bug";
        assert e10.nbDeNombres()==3 : "Bug";
        assert e2.valeur() == 15 : "Bug";
        assert (e1.toString().equals( "( 4 + 5 )" )):"bug toString() Somme";
        assert ((Somme) e1).toStringPrefix().equals("+ 4 5") :"bug";
        assert ((Somme) e1).toStringPostfix().equals("4 5 +") :"bug";
        assert e2.toString().equals( "( ( 4 + 5 ) + 6 )" ) :"bug toString() Somme";
        assert ((Somme) e2).toStringPrefix().equals("+ + 4 5 6") :"bug";
        assert ((Somme) e2).toStringPostfix().equals("4 5 + 6 +") :"bug";
        assert e3.toString().equals( "( ( ( 4 + 5 ) + 6 ) - 4 )" ) :"bug toString Difference";
        assert ((Difference) e3).toStringPrefix().equals("- + + 4 5 6 4") :"bug";
        assert ((Difference) e3).toStringPostfix().equals("4 5 + 6 + 4 -") :"bug";
        assert e3.valeur() == 11 : "bug valeur() Difference";

        assert (e4.toString().equals( "( ( ( ( 4 + 5 ) + 6 ) - 4 ) * ( 4 + 5 ) )" )):"bug toString Produit";
        assert (((Produit)e4).toStringPrefix().equals("* - + + 4 5 6 4 + 4 5")):"bug";
        assert (((Produit) e4).toStringPostfix().equals("4 5 + 6 + 4 - 4 5 + *")):"bug";
        assert (e4.valeur() == 99): "bug valeur() Produit" ;
        assert (e5.toString().equals( "( ( ( ( ( 4 + 5 ) + 6 ) - 4 ) * ( 4 + 5 ) ) ÷ ( 5 + 6 ) )" )):"bug toString Division";
        assert (((Division) e5).toStringPrefix().equals("÷ * - + + 4 5 6 4 + 4 5 + 5 6")):"bug";
        assert (((Division) e5).toStringPostfix().equals("4 5 + 6 + 4 - 4 5 + * 5 6 + ÷")):"bug";
        assert (e5.valeur() == 9): "bug valeur() Division";
        assert (n1.toString().equals( "4" )):"bug toString() Nombre";

        assert e6.valeur() == 7 :"erreur calcul de valeur() de Moyenne";
        assert e6.toStringPrefix().equals("moyenne( 4, 6, 11 )") :"erreur toStringPrefix() de Moyenne";
        assert e6.toStringPostfix().equals("( 4, 6, 11 )moyenne") :"erreur toStringPostfix() de Moyenne";
        assert e6.toString().equals("moyenne( 4, 6, 11 )") :"erreur toString() de Moyenne";
        System.out.println("ecriture infixee non existante pour l'operateur moyenne car ( ( 4 moyenne 6 ) moyenne 11 ) = 8" +"\ndifferent de moyenne( 4, 6, 11 ) = 7\n");

        assert e7.valeur() == 4 :"erreur calcul de valeur() de Min";
        assert e7.toStringPrefix().equals("min( 4, 6, 11 )") :"erreur toStringPrefix() de Min";
        assert e7.toStringPostfix().equals("( 4, 6, 11 )min"):"erreur toStringPostfix() de Min";
        assert e7.toString().equals("( ( 4 min 6 ) min 11 )"):"erreur toString() de Min";

        assert e8.valeur() == 11 :"erreur calcul de valeur() de Max";
        assert e8.toStringPrefix().equals("max( 4, 6, 11 )") :"erreur toStringPrefix() de Max";
        assert e8.toStringPostfix().equals("( 4, 6, 11 )max"):"erreur toStringPostfix() de Max";
        assert e8.toString().equals("( ( 4 max 6 ) max 11 )"):"erreur toString() de Max";

        assert e9.valeur() == 21 :"erreur calcul de valeur() de SommeMultiple";
        assert e9.toStringPrefix().equals("somme( 4, 6, 11 )") :"erreur toStringPrefix() de SommeMultiple";
        assert e9.toStringPostfix().equals("( 4, 6, 11 )somme"):"erreur toStringPostfix() de SommeMultiple";
        assert e9.toString().equals("( ( 4 somme 6 ) somme 11 )"):"erreur toString() de SommeMultiple";

        assert e10.valeur() == 264 :"erreur calcul de valeur() de ProduitMultiple";
        assert e10.toStringPrefix().equals("produit( 4, 6, 11 )") :"erreur toStringPrefix() de ProduitMultiple";
        assert e10.toStringPostfix().equals("( 4, 6, 11 )produit"):"erreur toStringPostfix() de ProduitMultiple";
        assert e10.toString().equals("( ( 4 produit 6 ) produit 11 )"):"erreur toString() de ProduitMultiple";

        assert e11.valeur() == 243 ;
        assert e11.toString().equals ("( ( ( 4 produit 6 ) produit 11 ) - ( ( 4 somme 6 ) somme 11 ) )");
        assert e11.toStringPrefix().equals ("- produit( 4, 6, 11 ) somme( 4, 6, 11 )");
        assert e11.toStringPostfix().equals("( 4, 6, 11 )produit ( 4, 6, 11 )somme -");
    }
}
