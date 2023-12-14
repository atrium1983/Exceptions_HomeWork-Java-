package HomeWork_3.view.commands;

import HomeWork_3.view.ConsoleUI;

public class AddContact extends Command{
    public AddContact(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить контакт";
    }

    @Override
    public void execute() {
        consoleUI.addContact();
    }
}
