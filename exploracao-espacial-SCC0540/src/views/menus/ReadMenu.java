package views.menus;
import controllers.GalaxiaController;
import resources.TableBuilder;

import java.sql.SQLException;

public class ReadMenu {

    private TableBuilder tb;
    private int[] colWidths = {40, 10};
    private String[] headers = {"O que deseja buscar?", "Digite"};
    private String[][] options = {
            {"Ver todas as galaxias", "1"},
            {"Ver galaxias por tipo", "2"},
    };

    private String[][] footer = {
            {"Voltar", "0"},
    };

    public ReadMenu() {
        tb = new TableBuilder(this.colWidths);
        tb.clearConsole();
        tb.setHeaders(headers);
        tb.displayHeader();
        tb.display(options);
        tb.displayFooter(footer);
    }

    public void handleInput(int input) throws SQLException {
        if (input == 0) {
            System.out.println("Voltando ao menu");
            return;
        }
        // Ver todas as galaxias
        if (input == 1) {
            GalaxiaController controller = new GalaxiaController();
            controller.selectAll();
        }
        // Ver galaxias por tipo
        if (input == 2) {
            GalaxiaController controller = new GalaxiaController();
            SingleInputMenu menuTipoGalaxia = new SingleInputMenu("Qual tipo de galaxia deseja pesquisar?");
            controller.selectByTipo(menuTipoGalaxia.getInput());
        }
    }
}
