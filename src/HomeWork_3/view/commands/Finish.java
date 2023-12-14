package HomeWork_3.view.commands;

import HomeWork_3.view.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Завершить работу";
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }
}
