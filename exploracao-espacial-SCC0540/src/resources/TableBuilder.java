package resources;

import models.Galaxia;

import java.util.ArrayList;
import java.util.Formatter;
public class TableBuilder {
    Formatter fmt;
    int colNumbers;
    int tableWidth;
    int[] colWidths;
    String[] headers;


    public TableBuilder(int[] colWidths) {
        fmt = new Formatter();
        this.tableWidth = 0;
        this.colWidths = colWidths;
        for (int i = 0; i < colWidths.length; i++) {
            this.tableWidth += colWidths[i];
        }
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
        this.colNumbers = headers.length;
    }

    public void divisor() {
        String divisorString = String.valueOf("-").repeat(this.tableWidth);
        System.out.println(divisorString);
    }

    public void display(String[][] data) {
        // Prints data array
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%-" + colWidths[j] + "s", data[i][j]);
            }
            System.out.println();
        }
    }

    public void displayHeader() {

        System.out.println();

        // Print headers
        for (int i = 0; i < this.headers.length; i++) {
            System.out.printf("%-" + this.colWidths[i] + "s", headers[i]);
        }

        // Jumps a line
        System.out.println();

        // Print a table width line
        this.divisor();
    }
    public void displayFooter(String[][] data) {

        // Print a table width line
        this.divisor();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%-" + colWidths[j] + "s", data[i][j]);
            }
            System.out.println();
        }

        // Print a table width line
        this.divisor();
    }

    public void clearConsole() {
        System.out.println("\n\n\n\n");
    }

}
