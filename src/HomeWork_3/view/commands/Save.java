package HomeWork_3.view.commands;

import HomeWork_3.view.ConsoleUI;

public class Save extends Command{
    public Save(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить контакты";
    }

    @Override
    public void execute() {
        consoleUI.save();
    }
}
