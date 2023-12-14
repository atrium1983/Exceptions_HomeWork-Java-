package HomeWork_3.view.commands;

import HomeWork_3.view.ConsoleUI;

public class PrintContacts extends Command{
    public PrintContacts(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать текущие контакты";
    }

    @Override
    public void execute() {
        consoleUI.printContacts();
    }
}
