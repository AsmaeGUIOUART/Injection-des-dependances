package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres22 {
    public static void main(String[] args) throws Exception {
       // DaoImpl dao=new DaoImpl();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Donner la classe de la couche DAO:");
        String daoClassName=scanner.nextLine();
        System.out.println(daoClassName);
        Class cDao=Class.forName(daoClassName);
        IDao dao=(IDao)cDao.getConstructor().newInstance(); //=> new DaoImpl()
        System.out.println(dao.getData());

        // MetierImpl metier=new MetierImpl();
        System.out.println("Donner la classe de la couche Métier:");
        String metierClassname=scanner.nextLine();
        Class cMetier=Class.forName(metierClassname);
        IMetier metier =(IMetier) cMetier.getConstructor().newInstance();

        // metier.setDao(new DaoImpl());
        Method setDao=cMetier.getDeclaredMethod("setDao",IDao.class);
        setDao.invoke(metier,dao); //injection des dépendances dynamiques

        System.out.println("RES="+metier.calcul());

    }
}
