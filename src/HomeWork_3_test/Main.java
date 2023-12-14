package HomeWork_3_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Main {
    private static String patternDate = "[0-9]*\\.+[0-9]*\\.+[0-9]+";
    private static String patternNumber = "[0-9]+";
    private static String patternText1 = "\\D+";
    public static void main(String[] args) {
//        String [] text = inputPersonalInfo();
        String date = "1983.05.16";
        String number = "7925670";
        String text= "Черепанов Артём Александрович";
//        for (String item: text) {
//            System.out.println(item);
//        }
//        System.out.println(checkLengthExceptions(checkInputLength(text)));
        if(date.matches(patternDate)){
            System.out.println(convertToDate(date));
        }
        if(number.matches(patternNumber)) {
            System.out.println(convertToPhoneNumber(number));
        }
        if(text.matches(patternText1)){
            System.out.println(text);
        }
    }
    public static String[] inputPersonalInfo() {
        String text;
        System.out.println("Введите следующие данные через пробел в произвольном порядке: " +
                "ФИО, дата рождения в формате ГГГГ-ММ-ДД, номер телефона, пол (m или f)");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            text = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] personalInfo = text.split(" ");
        return personalInfo;
    }
    public static int checkInputLength(String[] personalInfo){
        if(personalInfo.length < 6){
            return -1;
        } else if (personalInfo.length > 6) {
            return 1;
        } else {
            return 0;
        }
    }

    public static boolean checkLengthExceptions(int code){
        if(code == -1){
            System.out.println("Вы ввели недостаточно информации. Повторите ввод");
            return false;
        } else if (code == 1) {
            System.out.println("Вы ввели слишком много информации. Повторите ввод");
            return false;
        } else {
            return true;
        }
    }

    public static LocalDate convertToDate(String str){
        LocalDate date = null;
        str = str.replace(".", "-");
        try {
            date = LocalDate.parse(str);
        } catch (Exception e){
            System.out.println("Вы ввели некорректную дату. Формат ввода должен быть YYYY.MM.DD");
        }
        return date;
    }

    public static long convertToPhoneNumber(String str){
        long phoneNumber = 0;
        if(str.matches("[0-9]+")){
            phoneNumber = Long.parseLong(str);
        } else {
            throw new RuntimeException("Вы ввели некорректный номер телефона");
        }
        return phoneNumber;
    }
}

class Person {
    private int id;
    private String name;
    private LocalDate birthDate;
    private long phoneNumber;
    private String gender;

    Person(int id, String name, LocalDate birthDate, long phoneNumber, String gender){
        this.id = id;
        this.name =  name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append("id: ");
        info.append(id);
        info.append(", имя: ");
        info.append(name);
        info.append(", пол: ");
        info.append(gender);


        return info.toString();
    }

}
