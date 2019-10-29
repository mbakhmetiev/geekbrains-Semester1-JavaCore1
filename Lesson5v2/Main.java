package DZ5_v3;

public class Main {

    public static void main(String[] args) {

        // Запуск и замер времени исполнения обычного пробега

        ThreadsArray arrExecute1 = new ThreadsArray(1000000, 4);

        long a = System.currentTimeMillis();
        arrExecute1.updateArraySimple();
        System.out.println(System.currentTimeMillis() - a);

        // Запуск и замер времени исполнения разделения, изменения и склейка обратно

        ThreadsArray arrExecute2 = new ThreadsArray(1000000, 4);

        a = System.currentTimeMillis();
        arrExecute2.updateArrayThreads();
        System.out.println(System.currentTimeMillis() - a);
    }
}
