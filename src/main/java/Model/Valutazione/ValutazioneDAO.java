package Model.Valutazione;

import Model.Connessione.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * classe che utilizza i metodi di interrogazione del database riguardanti Valutazione
 */

public class ValutazioneDAO {

    /**
     * metodo che interroga il database per restituire una lista di valutazione con UtNickname corrispondente alla
     * stringa passata come parametro
     * @param utNickname
     * @return Lista di valutazione
     * @throws SQLException
     */

    public List<Valutazione> doRetrieveValutazioneByUtente(String utNickname) throws SQLException {
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM valutazione WHERE UtNickname = ?")) {
                ps.setString(1, utNickname);
                ResultSet rs = ps.executeQuery();
                List<Valutazione> valutazione = new ArrayList<>();
                ValutazioneExtraction valutazioneExtraction = new ValutazioneExtraction();
                while (rs.next()) {
                    valutazione.add(valutazioneExtraction.mapping(rs));
                }
                rs.close();
                return valutazione;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * metodo che interroga il database per restituire una lista di valutazione con Titolo corrispondente alla
     * stringa passata come parametro
     * @param titolo
     * @return Lista di valutazione
     * @throws SQLException
     */

    public List<Valutazione> doRetrieveValutazioneByTitolo(String titolo) throws SQLException {
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM valutazione WHERE Titolo = ?")) {
                ps.setString(1, titolo);
                ResultSet rs = ps.executeQuery();
                List<Valutazione> valutazione = new ArrayList<>();
                ValutazioneExtraction valutazioneExtraction = new ValutazioneExtraction();
                while (rs.next()) {
                    valutazione.add(valutazioneExtraction.mapping(rs));
                }
                rs.close();
                return valutazione;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * metodo che interroga il database per inserire un elemento valutazione tramite UtNickname dell'utente
     * e Titolo del videogioco passati come parametro
     * @param titolo
     * @param utNickname
     * @return boolean
     * @throws SQLException
     */

    public Boolean insertByUtente(String titolo, String utNickname) throws SQLException{
        int rows = 0;
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("INSERT INTO valutazione(UtNickname,Titolo) VALUES (?,?);")) {
                ps.setString(1, utNickname);
                ps.setString(2, titolo);
                rows = ps.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows == 1;
    }

    /**
     * metodo che interroga il database per aggiornare MediaValutazioni di un elemento valutazione, con Titolo
     * corrispondente alla stringa passata come parametro, tramite un intero passato come parametro
     * @param titolo
     * @param value
     * @return boolean
     * @throws SQLException
     */

    public Boolean updateValutazione(String titolo, int value) throws SQLException {
        double d = 0;
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT Videogioco.MediaValutazioni FROM Videogioco WHERE Titolo = ?")) {
                ps.setString(1, titolo);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    d = rs.getInt(1);
                }
                rs.close();
            }
            if (d != 0) {
                d += value;
                d = d / 2;
            } else {
                d += value;
            }
            try (PreparedStatement ps = connection.prepareStatement("UPDATE videogioco SET MediaValutazioni=? WHERE Titolo=?")) {
                ps.setDouble(1, d);
                ps.setString(2, titolo);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    /**
     * metodo che interroga il database per restituire un elemento valutazione con Titolo e UtNickname corrispondenti
     * alle rispettive stringhe passate come parametro
     * @param titolo
     * @param utNickname
     * @return Valutazione
     * @throws SQLException
     */

    public Valutazione doRetrieveValutazione(String titolo,String utNickname) throws SQLException {
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM valutazione WHERE Titolo = ? AND UtNickname = ?")) {
                ps.setString(1, titolo);
                ps.setString(2, utNickname);
                ResultSet rs = ps.executeQuery();
                Valutazione valutazione = new Valutazione();
                ValutazioneExtraction valutazioneExtraction = new ValutazioneExtraction();
                if (rs.next()) {
                    valutazione = valutazioneExtraction.mapping(rs);
                }
                rs.close();
                return valutazione;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
