package HomeWork_3.model.writer;

import HomeWork_3.model.Contact;
import java.io.IOException;

public interface Writable {

    void save(Contact contact) throws IOException, MyException;
    void read(String fileName) throws MyException;
}
