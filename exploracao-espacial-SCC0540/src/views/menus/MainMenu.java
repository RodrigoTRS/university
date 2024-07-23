package views.menus;
import resources.Reader;
import resources.TableBuilder;

import java.sql.SQLException;

public class MainMenu{

    private TableBuilder tb;
    private int[] colWidths = {40, 10};
    private String[] headers = {"Menu Principal", "Digite"};
    private String[][] options = {
            {"Realizar uma consulta", "1"},
            {"Criar uma entidade", "2"},
            {"Alterar uma entidade", "3"},
            {"Deletar uma entidade", "4"},
    };

    private String[][] footer = {
            {"Sair", "0"},
    };

    public MainMenu() {
        tb = new TableBuilder(this.colWidths);
        tb.clearConsole();
        tb.setHeaders(headers);
        tb.displayHeader();
        tb.display(options);
        tb.displayFooter(footer);
    }

    public void handleInput(int input) throws SQLException {
        if (input == 0) {
            System.out.println("Finalizando aplicaçao");
        }
        if (input == 1) {
            ReadMenu menu = new ReadMenu();
            int nextInput = Reader.getInstance().input.nextInt();
            menu.handleInput(nextInput);
        }
        if (input == 2) {
            CreateMenu menu = new CreateMenu();
            int nextInput = Reader.getInstance().input.nextInt();
            menu.handleInput(nextInput);
        }
        if (input == 3) {
            System.out.println("Alterando uma entidade");
        }
        if (input == 4) {
            DeleteMenu menu = new DeleteMenu();
            int nextInput = Reader.getInstance().input.nextInt();
            menu.handleInput(nextInput);
        }
    }
}
