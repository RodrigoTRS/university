package views;

import models.Galaxia;
import resources.Reader;
import resources.TableBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;

public class GalaxiaView {

    private TableBuilder tb;

    private int[] colWidths = {15, 15, 15, 15};
    private String[] headers = {"Nome", "Tipo", "Massa total", "Massa visivel"};

    private ArrayList<Galaxia> galaxias;

    public GalaxiaView(ResultSet rs) throws SQLException {
        this.galaxias = parseResultSet(rs);

        tb = new TableBuilder(this.colWidths);
        tb.clearConsole();
        tb.setHeaders(headers);
        tb.displayHeader();
        this.displayGalaxias(this.galaxias);
    }

    private ArrayList<Galaxia> parseResultSet(ResultSet rs) throws SQLException {
        ArrayList<Galaxia> queriedGalaxies = new ArrayList<Galaxia>();
        while (rs.next()) {
            Galaxia g = new Galaxia();
            g.setNome(Normalizer.normalize(rs.getString("NOME"), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase());
            g.setTipo(Normalizer.normalize(rs.getString("TIPO"), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toLowerCase());
            g.setMassaTotal(rs.getString("MASSATOTAL"));
            g.setMassaVisivel(rs.getString("MASSAVISIVEL"));
            queriedGalaxies.add(g);
        }
        return  queriedGalaxies;
    }

    private void displayGalaxias(ArrayList<Galaxia> galaxias) {
        for (int i = 0; i < galaxias.size(); i++) {
            System.out.printf("%-" + colWidths[0] + "s", galaxias.get(i).getNome());
            System.out.printf("%-" + colWidths[1] + "s", galaxias.get(i).getTipo());
            System.out.printf("%-" + colWidths[2] + "s", galaxias.get(i).getMassaTotal());
            System.out.printf("%-" + colWidths[3] + "s", galaxias.get(i).getMassaVisivel());
            System.out.println();
        }
    }

}
