import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Домашняя работа №4");

        int[] numbers = {1, 2, 3, 2, 4, 5, -10};

        printIntArray(numbers);
        System.out.println();

        System.out.printf("Сумма элементов массива = %s\n",sumArray(numbers));
        System.out.printf("Минимальный элемент массива = %s\n",findMin(numbers));

        System.out.print("Месяцы на букву М - ");
        printMonths("М");
        System.out.println();

        String[] seasons = {"Осень", "Лето", "Весна", "Зима"};
        System.out.print("Слева направо - ");
        printStringArray(seasons);
        System.out.println();
        System.out.print("Справа налево - ");
        invertArray(seasons);
        printStringArray(seasons);
        System.out.println();

        System.out.print("Еще раз Слева направо - ");
        System.out.println(Arrays.toString(seasons));

        int[] someNumbers = {1, 2, 3, 4, 5};
        System.out.printf("В массиве есть повторяющиеся? %s\n", checkDuplicate(someNumbers));

        int[] negtiveNumbers = {1, 2, 3, 4, -55};
        printIntArray(absNegative(negtiveNumbers));
        System.out.println();

        printInt2Array(fillDiagonal());
        System.out.println();

        int [][] sampleIntArray = {{0, 1, 2, 3}, {4, 5, 60}, {7, 8, 9}, {10, 11, 12}};
        printInt2Array(sampleIntArray);
        getCoordinateMaxValue(sampleIntArray);
        System.out.println();

        System.out.printf("Двумерный массив квадратный? - %s",isSquareArray(sampleIntArray));
        System.out.println();

        printSomething(sampleIntArray);

        printInt2Array(getOddArray(7,7));
    }

    /**
     * Одномерные массивы
     * - Создайте метод, который выводит массив в консоль.
     */
    static void printIntArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    static void printStringArray(String[] array) {
        for (String element : array) {
            System.out.print(element + " ");
        }
    }

    /**
     * - Напишите метод, который принимает массив целых чисел и возвращает сумму всех его элементов.
     */
    static  int sumArray(int[] array) {
        int result = 0;
        for (int num : array) {
            result += num;
        }
        return result;
    }

    /**
     * - Реализуйте метод для поиска минимального элемента в одномерном массиве
     */
    static int findMin(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (result > array[i]) {
                result = array[i];
            }
        }
        return result;
    }

    /**
     *  - Создайте массив строк, инициализируйте его названиями месяцев года. Выведите все строки, начинающиеся на букву "М"
     */
    static void printMonths(String firstLetter) {
        String[] months = {"Январь", "Февраль", "март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        String firstLetterUpper = firstLetter.toUpperCase();
        for (String element : months) {
            if (element.toUpperCase().startsWith(firstLetterUpper)) {
                System.out.print(element + " ");
            }
        }
    }

    /**
     * - Напишите метод, который инвертирует порядок элементов в одномерном массиве
     */
    static void invertArray(String[] array) {
        String[] tmpArray = new String[array.length];
        System.arraycopy(array, 0, tmpArray, 0, array.length);
        for (int i = 0; i < tmpArray.length; i++) {
            array[i] = tmpArray[(tmpArray.length - 1) - i];
        }
    }

    /**
     *  - Напишите метод, который проверяет, есть ли в массиве повторяющиеся элементы
     */
    static boolean checkDuplicate(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * - Напишите метод, который заменяет все отрицательные числа в массиве на их абсолютные значения.
     */
    static int[] absNegative(int[] array) {
        //int size = array.length;
        int[] resultArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            resultArray[i] = Math.abs(array[i]);
        }
        return resultArray;
    }
    /**
     * Многомерные массивы
     */
    static void printInt2Array(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
         }
    }
    /**
     * - Создайте двумерный массив 3x3, заполните его единицами на главной диагонали и нулями в остальных ячейках. Выведите массив
     */
    static int[][] fillDiagonal() {
        int[][] array = new int[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][j] = 1;
                }
            }
        }
        return array;
    }
    /**
     * - Реализуйте поиск максимального элемента в матрице и вывод его координат (строка, столбец)
     */
    static void getCoordinateMaxValue(int[][] array) {
        int maxValue = Integer.MIN_VALUE;
        int maxI = -1;
        int maxJ = -1;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (maxValue < array[i][j]) {
                    maxValue =  array[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        System.out.printf("координаты максимума Строка = %s, столбец = %s", maxI + 1, maxJ + 1);
    }
     /**
     * - Реализуйте проверку, является ли двумерный массив квадратным (количество строк = количеству столбцов)
     */
     static boolean isSquareArray(int[][] array) {
         //boolean result = true;
         for (int i = 0; i < array.length; i++) {
            if ( array.length != array[i].length) {
                return false;
            }
         }
         return true;
     }

     /**
     * - Напишите метод, который находит сумму элементов каждой строки, минимальное и максимальное значение двумерного массива и выводит результаты
     */
    static void printSomething(int[][] array) {
        int sumLine;
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            sumLine = 0;
            for (int j = 0; j < array[i].length; j++) {
                sumLine += array[i][j];
                if (maxValue < array[i][j]) {
                    maxValue =  array[i][j];
                }
                if (minValue > array[i][j]) {
                    minValue =  array[i][j];
                }
            }
            System.out.printf("Сумма строки %s = %s\n", i + 1, sumLine);
        }
        System.out.printf("min = %s, max = %s\n", minValue, maxValue);
    }
     /**
     * - Создайте двумерный массив, заполните его так, чтобы элементы на четных позициях были 0, на нечетных — 1
     */
     static int[][] getOddArray(int a, int b) {
         int[][] resultArray = new int[a][b];
         for (int i = 0; i < resultArray.length; i++) {
             for (int j = 0; j < resultArray[i].length; j++) {
                 // для int можно принудительно не заполнять 0
                 resultArray[i][j] = ((i % 2) == 1) && ((j % 2) == 1) ? 0 : 1;
             }
         }
         return resultArray;
     }
}

