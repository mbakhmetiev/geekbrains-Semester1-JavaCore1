package DZ3_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); String passwd;

// Подсмотрено здесь - https://stackoverflow.com/questions/3802192/regexp-java-for-password-validation

        String passwdPattern = "^(?=.*[0-9])" +     // Хотя бы одно число
                                "(?=.*[a-z])" +     // Хотя бы одна строчная буква
                                "(?=.*[A-Z])" +     // Хотя бы одна заглавная буква
                                "(?=\\S+$)" +       // Не должно быть пробелов во всем слове
                                ".{8,}$";           // Длина не менее 8 символов

        System.out.println("Правила пароля - не менее 8 символов, " + "\n" +
                            "хотя бы одно число, одна строчная," + "\n" +
                            "одна заглавная латинская буква" + "\n");
            do {
                System.out.println("Введите пароль: ");
                passwd = scanner.nextLine();
            } while (!passwd.matches(passwdPattern));
    }
}
