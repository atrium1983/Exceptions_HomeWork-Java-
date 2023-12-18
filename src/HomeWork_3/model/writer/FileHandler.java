package HomeWork_3.model.writer;

import HomeWork_3.model.Contact;
import java.io.*;

public class FileHandler implements Writable{

    public void save(Contact contact) throws MyException {
        String filePath = "src/HomeWork_3/model/writer/contacts/"+contact.getLastName()+".txt";
        File file = new File(filePath);
        try(FileWriter writer = new FileWriter(file, true)){
            if(file.length() >0){
                writer.write("\n");
            }
            writer.write(contact.toString());
        } catch (IOException e){
            throw new MyException("Ошибка в процессе записи в файл");
        }
    }
    public void read(String name) throws MyException {
        String filePath = "src/HomeWork_3/model/writer/contacts/"+name;
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null){
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new MyException("Файл не найден");
        } catch (IOException e) {
            throw new MyException("Ошибка в процессе чтения из файла");
        }
    }
}
