package pres;

import dao.DaoImpl;
import ext.DaoImpl2;
import metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args) {
        DaoImpl dao=new DaoImpl();//Instanciation statique
        MetierImpl metier=new MetierImpl();
        metier.setDao(new DaoImpl());//injection des dépendances c'est prendre l'adresse mémoire d'un objet et l'affecter à un autre objet
        System.out.println("RES="+metier.calcul());
    }
}
