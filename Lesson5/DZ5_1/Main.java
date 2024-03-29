package DZ5_v2;

import java.util.ArrayList;

public class Main {
    static final int size = 1000000;
    static float[] arr = new float[size];
    static int numParts = 4;
    static ArrayList<float[]> splitArrays = new ArrayList<>();
    static ArrayList<Integer> cells = new ArrayList<>();
    static ArrayList<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {

        // Запуск и замер времени исполнения обычного пробега

        long a = System.currentTimeMillis();
        createArray(); updateArraySimple();
        System.out.println(System.currentTimeMillis() - a);

        // Запуск и замер времени исполнения разделения, изменения и склейка обратно

        a = System.currentTimeMillis();
        createArray(); updateArrayThreads();
        System.out.println(System.currentTimeMillis() - a);
    }
/*
        Создать массив размером size из 1
*/
    static public void createArray () {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
    }
/*
        Метод производит промежуточные манипуляции для разбиения исходного массива
*/
    static public ArrayList<Thread> prepare () {

        // определяем количество ячеек для копирования при разбиении size / numparts
        // создаем логику, которая позволит рабивать иходный массив проиизвольно
        // получим например 103 / 3 = [34,34,35]
        for (int i = 0; i < numParts; i++) {
            if (i == numParts - 1) {
                cells.add(size - ((numParts - 1) * (size / numParts)));
            } else cells.add(i, size / numParts);
        }

        int cellsget = 0;
        // создаем ListArray, содержащий массивы явл. копиями частей исходного
        // результат ListArray splitArrays
        for (int i = 0; i < numParts; i++) {
            float[] splitArr = new float[cells.get(i)];
            System.arraycopy(arr, cellsget, splitArr, 0, cells.get(i));
            cellsget += cells.get(i);
            splitArrays.add(i, splitArr);
        }

        cellsget = 0;

        // Создаем ListArray, содержащий потоки, потоки нам создает метод create
        // cretae принимает одну из копий исходного массива и сдвиг
        for (int i = 0; i < splitArrays.size(); i++ ) {
            threads.add(i, create(cellsget, splitArrays.get(i)));
            cellsget += cells.get(i);
        }
        return threads;
    }
/*
        Метод врзращает поток в котором изменяем значения одной из копий с учетом сдвига в исходном
*/
    static synchronized public Thread create(int start, float[] arr1) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < arr1.length; j++) {
                    arr1[j] = (float) (arr1[j] * Math.sin(0.2f + (j + start) / 5) * Math.cos(0.2f + (j + start) / 5) * Math.cos(0.4f + (j + start) / 2) );
                }
            }
        });
        return thread;
    }
/*
        Метод запускает потоки на изменение значений в копиях и затем склеивает (копирует) обратно в исходный
*/
    static public void updateArrayThreads() {
        for (Thread thread : prepare()) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int cellsget = 0;

        for (int i = 0; i < numParts; i++) {
            System.arraycopy(splitArrays.get(i), 0, arr, cellsget, cells.get(i));
            cellsget += cells.get(i);
        }
    }
/*
        Метод делающий простой пробег с изменением по исходному
*/
    static public void updateArraySimple() {
        for(int i = 0 ; i < size; i ++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
