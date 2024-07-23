import resources.Db;
import resources.Env;
import resources.Reader;
import views.menus.MainMenu;

import java.sql.SQLException;
import java.util.Scanner;

public class Index {
    public static void main(String[] args) throws SQLException {
        // Connect to database
        Db.getInstance().connect();

        // Main loop
        int nextInput = -1;
        while (nextInput != 0) {
            MainMenu menu = new MainMenu();
            nextInput = Reader.getInstance().input.nextInt();
            menu.handleInput(nextInput);
        }

        Db.getInstance().disconnect();
    }
}
