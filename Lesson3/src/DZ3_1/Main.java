package DZ3_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
// Исходный текст для создания массива слов, есть повторяющиеся слова
        String lorem = "Lorem ipsum dolor sit amet, ad nam audiam euismod necessitatibus, " +
                "ad nam vim id falli euismod fabulas evertitur, ad nam ipsum dolor.";
// Текст - в список
        List<String> loremList = new ArrayList<>(Arrays.asList(lorem.split(" ")));

// Все слова - в строчные и убрать лишние символы "." и ","
        for(int i = 0 ; i < loremList.size(); i++) {
            loremList.set(i, loremList.get(i).toLowerCase());
            if(loremList.get(i).endsWith(",") | loremList.get(i).endsWith("."))
                loremList.set(i, loremList.get(i).replaceAll("[.,]", ""));
        }

        System.out.println("Полный список слов: ");
        System.out.println(loremList);

        Set<String> loremSet = new HashSet<>(loremList);

        System.out.println("Список уникальных слов: ");
        System.out.println(loremSet);

        Map<String, Integer> loremMap = new HashMap<>();

        for(String word : loremSet) {
            loremMap.put(word, Collections.frequency(loremList, word));
        }

        System.out.println("Частота слов в списке: ");
        System.out.println(loremMap);
    }
}
