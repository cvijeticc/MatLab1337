/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import broker.DBBroker;
import domen.Nastavnik;
import domen.Zvanje;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andri
 */
public class Kontroler {
    DBBroker dbbroker;

    public Kontroler() {
        dbbroker = new DBBroker();
    }

    public List<Zvanje> vratiZvnaja() throws Exception {

        try {
            return dbbroker.vratiZvanja();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Greska pri vracanju zvanje");
        }
    }

    public boolean sacuvajNastavnika(Nastavnik nastavnik) throws SQLException {
        return dbbroker.sacuvajNastavnika(nastavnik);
    }

    

    
}
