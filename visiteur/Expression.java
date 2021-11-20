package visiteur;

public interface Expression {
    int valeur() ;
    void accept(Visiteur v);
    void acceptN(VisiteurNb vn);
}
