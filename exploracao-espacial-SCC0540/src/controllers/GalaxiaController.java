package controllers;

import models.Galaxia;
import resources.Db;
import resources.Reader;
import views.GalaxiaView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Normalizer;
import java.util.Locale;

public class GalaxiaController {

    String tableName = "GALAXIA";

    public GalaxiaController() {}

    public Galaxia getInput() {
        Galaxia g = new Galaxia();
        Reader.getInstance().input.nextLine();
        System.out.println("Qual o nome da galaxia que deseja criar?");
        g.setNome(Reader.getInstance().input.nextLine());
        System.out.println("Qual o tipo da galaxia?");
        g.setTipo(Reader.getInstance().input.nextLine());
        System.out.println("Qual a massa total?");
        g.setMassaTotal(Reader.getInstance().input.nextLine());
        System.out.println("Qual a massa visivel?");
        g.setMassaVisivel(Reader.getInstance().input.nextLine());

        return g;
    }

    public void insert(Galaxia g) throws SQLException {

        Statement statement = Db.getInstance().connection.createStatement();

        int result = statement.executeUpdate("INSERT INTO " + this.tableName + " VALUES ('" + g.getNome() + "', '" + g.getTipo() + "', '" + g.getMassaTotal() + "', '" + g.getMassaVisivel() + "')");

        if (result > 0) {
            System.out.println("\n -- Insercao bem sucedida!");
        } else {
            System.out.println("\n -- Falha na insercao");
        }
    }

    public void selectAll() throws SQLException {
        Statement statement = Db.getInstance().connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM " + this.tableName);
        GalaxiaView gv = new GalaxiaView(rs);
    }

    public void selectByTipo(String tipo) throws SQLException {
        tipo = Normalizer.normalize(tipo, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();

        Statement statement = Db.getInstance().connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM " + this.tableName + " WHERE TIPO='"+ tipo +"'");
        GalaxiaView gv = new GalaxiaView(rs);
    }

    public void deleteByNome(String nome) throws SQLException {
        nome = Normalizer.normalize(nome, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();

        Statement statement = Db.getInstance().connection.createStatement();
        int result = statement.executeUpdate("DELETE FROM " + this.tableName + " WHERE NOME='"+ nome +"'");
        if (result > 0) {
            System.out.println("\n -- Delecao bem sucedida!");
        } else {
            System.out.println("\n -- Falha na delecao");
        }
    }
}
