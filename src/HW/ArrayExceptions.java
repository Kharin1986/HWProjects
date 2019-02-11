package HW;

public class ArrayExceptions {

    public static void main(String[] args)  {
        try {
            test();
        } catch (MyArrayDataException e) {
           e.printStackTrace();
            System.out.println("Ошибка типа данных");
        } catch (MyArraySizeException e) {
            e.printStackTrace();

        }
    }

    public static void test() throws MyArrayDataException,MyArraySizeException{
        int sum;
        String[][] arrString = {
                {"5", "15", "25", "35"},
                {"5", "11", "20", "305"},
                {"5", "150", "205", "305"},
                {"5", "10", "f", "55"}
        };
            sum = MySumArray.getSumArray(arrString);
        System.out.println(sum);
    }
}
