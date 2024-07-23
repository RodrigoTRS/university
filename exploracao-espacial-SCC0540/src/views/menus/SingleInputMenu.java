package views.menus;

import resources.Reader;
import resources.TableBuilder;

import java.sql.SQLException;

public class SingleInputMenu {
    private TableBuilder tb;

    public SingleInputMenu(String inputText) {
        tb = new TableBuilder(new int[]{60});
        tb.clearConsole();
        tb.setHeaders(new String[]{inputText});
        tb.displayHeader();
    }

    public String getInput() {
        Reader.getInstance().input.nextLine();
        String input = Reader.getInstance().input.nextLine();
        return input;
    }
}
