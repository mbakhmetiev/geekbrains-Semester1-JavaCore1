package DZ2_2_v1;

public class Main {
    public static void main(String[] args) {
        SumArray sumArray = new SumArray();

        String[][][] stringArray = {{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}},
                {{"1", "2", "3", "4"}, {"5", "6", "*", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "HELLO"}},
                {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}}};

        for (int i = 0; i < stringArray.length; ++i) {
            try {
                System.out.println(sumArray.setSumArray(4, stringArray[i]));
            } catch (MyArraySizeException ex) {
                System.err.println(ex.getMessage());
            } catch (MyArrayDataException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}