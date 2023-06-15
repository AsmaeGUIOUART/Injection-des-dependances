package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class MetierImpl implements IMetier {
    @Autowired
    //@Qualifier("vws")
    private IDao dao; //couplage faible :la classe MetierImpl est prete à fonctionner avec n'importe quelle classe qui implemente cette interface"IDao"
    //fermer à la modification :l'application peut utiliser DaoImplV2 au lieu de DaoImpl sans modifier quoi que ce soit dans classe MetierImpl->avantage de couplage faible
    //couplage fort:dao=new...
    //getters et setters c'est pour lire les données privées
    @Override
    public double calcul() {
        double data=dao.getData();
        double res=data*11.4;
        return res;
    }
//set :pour permettre de modifier la valeur du variable dao (d'injecter dans la variable dao un objet de type IDao c.à.d une classe qui implémente l'intérface IDao)
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
