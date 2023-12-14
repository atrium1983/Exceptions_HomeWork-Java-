package HomeWork_3.view;

import HomeWork_3.model.writer.Writable;
import HomeWork_3.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {

    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;
    private String error = "Вы ввели некорректное значение. Введите целое число";

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    private void hello() {
        answer("Добро пожаловать в меню приложение");
    }

    public void finish() {
        answer("Сеанс завершен. До свидания!");
        work = false;
        scanner.close();
    }

    private void printMenu(){
        answer(menu.getMenu());
    }

    public void printContacts(){
        presenter.print();
    }

    public void addContact(){
        String text;
        answer("Введите следующие данные через пробел в произвольном порядке: " +
                "ФИО, дата рождения в формате ГГГГ.ММ.ДД, номер телефона, пол (m или f)");
        text = scanner.nextLine();
        presenter.addContact(text);
    }

    private void execute(){
        String input = scanner.nextLine();
        if (checkIfInt(input)){
            int numCommand = Integer.parseInt(input);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkIfInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        answer(error);
    }

    public void setWritable(Writable writable) {
        presenter.setWritable(writable);
    }
    public void load(){
        presenter.load();
    }

    public void save(){
        presenter.save();
    }

    @Override
    public void answer(String text) {
        System.out.println(text);
    }
}
