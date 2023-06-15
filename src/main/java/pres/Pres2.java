package pres;

import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws Exception {
       // DaoImpl dao=new DaoImpl();
        Scanner scanner=new Scanner(new File("config.txt"));
        String daoClassName=scanner.nextLine();
        System.out.println(daoClassName);
        Class cDao=Class.forName(daoClassName);
        IDao dao=(IDao)cDao.getConstructor().newInstance(); //=> new DaoImpl()
        System.out.println(dao.getData());

        // MetierImpl metier=new MetierImpl();
        String metierClassname=scanner.nextLine();
        Class cMetier=Class.forName(metierClassname);
        IMetier metier =(IMetier) cMetier.getConstructor().newInstance();

        // metier.setDao(new DaoImpl());
        Method setDao=cMetier.getDeclaredMethod("setDao",IDao.class);
        setDao.invoke(metier,dao); //injection des dépendances dynamiques

        System.out.println("RES="+metier.calcul());

    }
}
