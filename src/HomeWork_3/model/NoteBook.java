package HomeWork_3.model;

import HomeWork_3.model.writer.Writable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NoteBook implements Serializable {
    Writable writable;
    NoteBook noteBook;
    List<Contact> contactList;
    public NoteBook(){
        contactList = new ArrayList<>();
    }

    public void addContact(Contact contact){
        contactList.add(contact);
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Контактов с указанной фамилией => ");
        sb.append((contactList.size()));
        sb.append(" \n");
        for (Contact contact: contactList) {
            sb.append(contact);
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString(){
        return getInfo();
    }
}
