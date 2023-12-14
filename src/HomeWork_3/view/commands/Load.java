package HomeWork_3.view.commands;

import HomeWork_3.view.ConsoleUI;

public class Load extends Command{
    public Load(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить сохраненные контакты";
    }

    @Override
    public void execute() {
        consoleUI.load();
    }
}
