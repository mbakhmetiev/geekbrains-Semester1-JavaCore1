package DZ3_2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class Main {
/*
    телефонный номер будет иметь вид <xxx>-<xxx>-<xxx>, где ххх - последовательность 3 цифр,
    <...> секция номера, кол-во секций зададим переменной sectionQuanty
*/
    static final int sectionQuanty = 3;    // кол-во секций телефонного номера
/*
    Кол-во телефонов в книжке генерируется случайно, макс число телефонных номеров
    для пользователя задаем переменной maxNumeros
*/
    static final int maxNumeros = 3;    // макс кол-во номеров для юзера

    // Список пользователей
    static String[] sulacoCrew = {"RIPLEY", "BURKE", "GORMAN", "BISHOP", "VASQUEZ", "FROST", "HICKS", "HUDSON"};

    // Список имен для теста регистра и несуществующей записи

    static String[] sulacoCrewWrong = {"riplEy", "burke", "GORMANN"};

    // Словарь - телефонный справочник
    static Map<String, LinkedList<String>> sulacoPhoneBook = new HashMap<>();

    public static void main(String[] args) {
/*
    Создание справочника из списка пользователей. кол-во номеров рандомно 1-3 в иетоде add().
    Номер генерится методом numberGen() - int array[3] вида {346,769,311}
*/
        for(String member : sulacoCrew) {
            add(member);
        }
//  Вывод номеров по имени
        for(String name : sulacoCrew) {
            System.out.printf("%-8s : %s%n", name, get(name));
        }
//  Тест разных регистров и несущ
        for(String name : sulacoCrewWrong) {
            System.out.printf("%-8s : %s%n", name, get(name));
        }
     }
// Генератор телефонных номеров
    public static Integer[] numberGen () {
        Random rand = new Random();
        Integer[] phoneNum = new Integer[sectionQuanty];          // Трехзначные секции номера записываются в int array длиной sectionQuanty
        for (int i = 0; i < sectionQuanty; i++) {
            phoneNum[i] = rand.nextInt((999 - 100) + 1) + 100; // Рандомное 3-х значное число
        }
        return phoneNum;  // возвращаем array вида {346,769,311}
    }
// Возвращаем список номеров пользователя по имени
    public static LinkedList<String> get (String name) {
        LinkedList<String> noEntry =  new LinkedList<>();
        noEntry.add("NO ENTRY FOUND");
        return sulacoPhoneBook.getOrDefault(name.toUpperCase(), noEntry);
    }
//    Добавлемномера пользователя
    public static void add (String name) {
        LinkedList<String> phone = new LinkedList<>();
        for (int i = 0 ; i < (int)(Math.random()*maxNumeros + 1); i++) {
            phone.add(String.format("%s-%s-%s",numberGen()[0],numberGen()[1], numberGen()[2])); // порходим по array из numberGen() {346,769,311}
        }
        sulacoPhoneBook.put(name, phone);
    }
}
