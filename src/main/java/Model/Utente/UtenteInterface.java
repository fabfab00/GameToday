package Model.Utente;

import Model.Amministratore.Amministratore;

import java.sql.SQLException;
import java.util.List;

public interface UtenteInterface
{
    List<Utente> doRetrieveUtenteAll() throws SQLException;
    Boolean createUtente(Utente utente) throws SQLException;
    Boolean updateUtente(Utente utente) throws SQLException;
    Boolean deleteUtente(int utNickname) throws SQLException;
    Utente loginUtente(String email, String password) throws SQLException;
    int countAll() throws SQLException;
    Utente doRetrieveUtenteByEmail(String email) throws SQLException;
}
