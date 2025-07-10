import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;


class MainTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void sumArrayTest() {
        int[] array = new int[] {1, 2, 3, -1, -2, -3};
        assertEquals(0, Main.sumArray(array));
        assertNotEquals(0, Main.sumArray(new int[] {1, 2, 3}));
    }

    @Test
    public void findMinTest() {
        assertEquals(-10, Main.findMin(new int[] {1, 2, 3, -10}));
    }

    @Test
    public void printMonthsTest() {
        Main.printMonths("М");
        assertEquals("март Май", outputStream.toString().trim());
        outputStream.reset();
        Main.printMonths("С");
        assertEquals("Сентябрь", outputStream.toString().trim());
    }

    @Test
    public void invertArrayTest() {
        String[] array = new String[] {"a", "b", "c", "d"};
        String[] outArray = new String[] {"d", "c", "b", "a"};
        Main.invertArray(array);
        assertArrayEquals(outArray, array);
    }

    @Test
    public void checkDuplicateTest() {
        assertTrue(Main.checkDuplicate(new int[] {1, 2, 3, 4, 4}));
        assertFalse(Main.checkDuplicate(new int[] {1, 2, 3, 4}));
    }

    @Test
    public void absNegativeTest() {
        assertArrayEquals(new int[] {1,2,3}, Main.absNegative(new int[] {1,-2,3}));
        // посмотреть, как работает в случае ошибки
        assertArrayEquals(new int[] {1,-2,3}, Main.absNegative(new int[] {1,-2,3}), "Ожидается 1,2,3");
    }

    @Test
    public void printSomethingTest() {
        String result = new String("Сумма строки 1 = 6\n" +
                "Сумма строки 2 = 69\n" +
                "Сумма строки 3 = 24\n" +
                "Сумма строки 4 = 33\n" +
                "min = 0, max = 60");
        Main.printSomething(new int [][] {{0, 1, 2, 3}, {4, 5, 60}, {7, 8, 9}, {10, 11, 12}});
        assertEquals(result, outputStream.toString().trim());
    }

    @Test
    public void isSquareArrayTest() {
        assertFalse(Main.isSquareArray(new int [][] {{0, 1, 2, 3}, {4, 5, 60}, {7, 8, 9}, {10, 11, 12}}));
        assertTrue(Main.isSquareArray(new int [][] {{0}}));
    }

    @Test
    public void getOddArrayTest() {
        assertArrayEquals(new int[][] {{1, 1}, {1, 0}}, Main.getOddArray(2, 2));
    }

}