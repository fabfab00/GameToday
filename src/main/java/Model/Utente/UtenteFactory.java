package Model.Utente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe factory utilizzata per implementare il design pattern NullObject
 */

public class UtenteFactory {

    public static final UtenteDAO UTENTE_DAO=new UtenteDAO();

    public static List<Utente> UTENTE_LIST=new ArrayList<>();

    static {
        try {
            UTENTE_LIST = UTENTE_DAO.doRetrieveAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * metodo utilizzato per verificare se l'autore che tenta di effettuare il login è presente nel database
     * @param email
     * @return autore
     */

    public static UtenteAbstract getEmail(String email){
        for(int i=0; i<UTENTE_LIST.size(); i++){
            if(UTENTE_LIST.get(i).getEmail().equals(email)){
                return new Utente();
            }
        }
        return new UtenteNull();
    }
}
