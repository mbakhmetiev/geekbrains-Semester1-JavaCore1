package Lesson2_dz2;

public class SumArray {

    public int setSumArray(int dimension, String[][] array) throws MyArraySizeException, MyArrayDataException {

        for(String[] element : array) {
            if ((dimension == array.length && array.length == element.length) == false)
                throw new MyArraySizeException(String.format("размерность массива не %d Х %d", dimension, dimension));
        }

        int total = 0; int x = 0; int y = 0;

        try {
            for(int i = 0; i < dimension; ++i) {
                for(int j = 0; j < dimension; ++j) {
                    x = i; y =j;
                    total += Integer.parseInt(array[i][j]);
                }
            }
        }
        catch (NumberFormatException ex) {
            throw new MyArrayDataException(String.format("В ячейке [%d][%d] - не число !!!", x, y));
        }

        return total;
    }
}
