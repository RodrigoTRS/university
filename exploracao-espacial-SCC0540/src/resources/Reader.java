package resources;

import java.util.Scanner;

public class Reader {
    private static Reader instance;
    public Scanner input;

    private Reader() {
        this.input = new Scanner(System.in);
    }

    public static Reader getInstance() {
        if (instance == null) {
            instance = new Reader();
        }
        return instance;
    }
}
