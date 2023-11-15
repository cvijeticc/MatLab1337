/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package broker;

import domen.Nastavnik;
import domen.Zvanje;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andri
 */
public class DBBroker {

    public List<Zvanje> vratiZvanja() throws SQLException {
        Connection connection = null;
        List<Zvanje> zvanja;

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentska_sluzba", "root", "");
        System.out.println("Otvorena konekcija");

        String query = "SELECT * FROM zvanje";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        zvanja = new ArrayList<>();
        while (rs.next()) {
            Zvanje zvanje = new Zvanje();

            zvanje.setId(rs.getInt("id"));
            zvanje.setNaziv(rs.getString("naziv"));
            zvanja.add(zvanje);

        }

        rs.close();
        st.close();
        connection.close();
        System.out.println("Zatvorena konekcija");
        return zvanja;

    }

    public boolean sacuvajNastavnika(Nastavnik nastavnik) throws SQLException {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentska_sluzba", "root", "");

            System.out.println("Otvorena konekcija");
            String query = "INSERT INTO nastavnik(ime,prezime,zvanje_id) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nastavnik.getIme());
            ps.setString(2, nastavnik.getPrezime());
            ps.setInt(3, nastavnik.getZvanje().getId());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            return false;

        } finally {
            if (connection != null || !connection.isClosed()) {
                connection.close();
                System.out.println("Zatvorena je konekcija");
            }

        }
        return true;
    }

    public List<Nastavnik> vratiSveNastavnike() {
        try {
            String query = "SELECT * FROM Nastavnik";
            List<Nastavnik> vrati = new ArrayList<>();

            Konekcija.getInstance().connect();
            Connection connection = Konekcija.getInstance().getConnection();
            Statement st = connection.createStatement();
            st.executeQuery(query);
            ResultSet rs = st.executeQuery(query);

            List<Zvanje> zvanja = vratiZvanja();
            while (rs.next()) {
                int id = rs.getInt(1);
                String ime = rs.getString(2);
                String prezime = rs.getString(3);
                int idZvanje = rs.getInt(4);

                Zvanje zvanje = new Zvanje();

                for (Zvanje z : zvanja) {
                    if (z.getId() == idZvanje) {
                        zvanje = z;
                        break;
                    }
                }
                Nastavnik nastavnik = new Nastavnik(id, ime, prezime, zvanje);
                vrati.add(nastavnik);

            }

            System.out.println(vrati.size());

            return vrati;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Neuspesno");
        }

    }

}
