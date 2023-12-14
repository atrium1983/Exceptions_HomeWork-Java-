package HomeWork_3.presenter;

import HomeWork_3.model.Service;
import HomeWork_3.model.writer.Writable;
import HomeWork_3.view.View;

import java.time.LocalDate;

public class Presenter {

    private final View view;
    private final Service service;
    private final String positive = "Успешно!\n";

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void setWritable(Writable writable) {
        service.setWritable(writable);
    }
    public void save(){
        service.save();
        view.answer(positive);
    }

    public void load(){
        service.load();
        view.answer(positive);
    }

    public void addContact(String text){
        service.addContact(text);
        view.answer(positive);
        print();
    }

    public void print(){
        view.answer(service.getInfo());
    }

}
