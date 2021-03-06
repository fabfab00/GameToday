package Model.Commento;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * classe utlizzata per il mapping del resultset dei commenti dal database
 */

public class CommentoExtraction {

    /**
     * metodo per effettuare il mapping del commento
     * @param rs
     * @return
     * @throws SQLException
     */

    public Commento mapping(ResultSet rs) throws SQLException
    {
        Commento commento= new Commento();
        commento.setComCodice(rs.getString(1));
        commento.setCodice(rs.getString(2));
        commento.setLike(rs.getInt(3));
        commento.setDislike(rs.getInt(4));
        commento.setTesto(rs.getString(5));
        return commento;
    }
}