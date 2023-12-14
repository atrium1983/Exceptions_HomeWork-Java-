package HomeWork_3;

import HomeWork_3.model.writer.FileHandler;
import HomeWork_3.view.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.setWritable(new FileHandler());
        consoleUI.start();
    }
}
