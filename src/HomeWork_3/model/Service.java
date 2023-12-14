package HomeWork_3.model;

import HomeWork_3.model.writer.Writable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    List<String> personalInfo;
    private NoteBook noteBook;
    Writable writable;
    String filePath = "src/HomeWork_3/model/writer/person.txt";

    public Service() {
        noteBook = new NoteBook();
        personalInfo = new ArrayList<>();
    }

    public void addContact(String text){
        setPersonalInfo(text);
        noteBook.addContact(createContact());
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public void save() {
        writable.save(noteBook, filePath);
    }

    public void load() {
        noteBook = (NoteBook) writable.read(filePath);
    }

    public String getInfo() {
        return noteBook.getInfo();
    }

        public void setPersonalInfo(String text){
            String[] personalInfo = text.split(" ");
            if(checkLengthExceptions(checkInputLength(personalInfo))){
                this.personalInfo = new ArrayList<>(List.of(personalInfo));
            } else {
                throw new RuntimeException("Повторите ввод");
            }
        }

        public Contact createContact() {
            String lastName;
            String name;
            String middleName;
            LocalDate birthDate = getDate();
            long phoneNumber = getPhoneNumber();
            String gender = getGender();
            if(personalInfo.size() == 3) {
                lastName = getName("Фамилия");
                name = getName("Имя");
                middleName = getName("Отчество");
            } else {
                throw new RuntimeException ("Данные введены некорретно");
            }
            return new Contact(lastName, name, middleName, birthDate, phoneNumber, gender);
        }


        public int checkInputLength (String[]personalInfo){
            if (personalInfo.length < 6) {
                return -1;
            } else if (personalInfo.length > 6) {
                return 1;
            } else {
                return 0;
            }
        }

        public boolean checkLengthExceptions(int code){
            if (code == -1) {
                System.out.println("Вы ввели недостаточно информации.");
                return false;
            } else if (code == 1) {
                System.out.println("Вы ввели слишком много информации.");
                return false;
            } else {
                return true;
            }
        }

        public LocalDate getDate(){
            LocalDate date = null;
            String str;
            for (int i = 0; i < personalInfo.size(); i++) {
                if (personalInfo.get(i).matches("[0-9]*\\.+[0-9]*\\.+[0-9]+")) {
                    str = personalInfo.remove(i).replace(".", "-");
                    try {
                        date = LocalDate.parse(str);
                    } catch (Exception e) {
                        throw new RuntimeException("Вы ввели некорректную дату. Формат ввода должен быть YYYY.MM.DD");
                    }
                }
            }
            return date;
        }

        public long getPhoneNumber(){
            long phoneNumber = 0;
            for (int i = 0; i < personalInfo.size(); i++) {
                if (personalInfo.get(i).matches("[0-9]+")) {
                    phoneNumber = Long.parseLong(personalInfo.remove(i));
                }
            }
            return phoneNumber;
        }

        public String getGender(){
            String gender = null;
            for (int i = 0; i < personalInfo.size(); i++) {
                if(personalInfo.get(i).length() == 1) {
                    if (personalInfo.get(i).equals("m") | personalInfo.get(i).equals("f")) {
                        gender = personalInfo.remove(i);
                    } else {
                        throw new RuntimeException("Пол введен некорректно");
                    }
                }
            }
            return gender;
    }

        public boolean checkIfText(String text){
            return text.matches("\\D+")? true : false;
        }

        public String getName(String comment){
            String name;
            if(checkIfText(personalInfo.get(0))) {
                name = personalInfo.remove(0);
            } else {
                throw new RuntimeException(comment+" - ошибка ввода");
            }
            return name;
        }
}
