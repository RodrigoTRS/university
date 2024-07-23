package views.menus;
import controllers.GalaxiaController;
import resources.TableBuilder;

import java.sql.SQLException;

public class DeleteMenu {

    private TableBuilder tb;
    private int[] colWidths = {40, 10};
    private String[] headers = {"O que deseja deletar?", "Digite"};
    private String[][] options = {
            {"Galaxias", "1"},
            {"Estrelas", "2"},
    };

    private String[][] footer = {
            {"Voltar", "0"},
    };

    public DeleteMenu() {
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
        // Galaxia
        if (input == 1) {
            GalaxiaController controller = new GalaxiaController();
            SingleInputMenu menuNomeGalaxia = new SingleInputMenu("Qual o nome da galaxia que deseja deletar?");
            controller.deleteByNome(menuNomeGalaxia.getInput());
        }
        // Estrela
        if (input == 2) {
            System.out.println("Criando uma estrela");
        }
    }
}
