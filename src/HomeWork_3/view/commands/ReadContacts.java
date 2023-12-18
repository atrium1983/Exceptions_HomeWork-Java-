package HomeWork_3.view.commands;

import HomeWork_3.view.ConsoleUI;

public class ReadContacts extends Command{
    public ReadContacts(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать все контакты";
    }

    @Override
    public void execute() {
        consoleUI.read();
    }
}
