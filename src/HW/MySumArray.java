package HW;

import static java.lang.Integer.parseInt;

class MySumArray {
    public static boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

    public static int getSumArray(String[][] arr) throws MyArraySizeException,MyArrayDataException {
        int res = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException("Длина массива не равна 4!");
        }
        for (int l = 0; l < arr.length; l++) {
            if (arr[l].length != 4) {
                throw new MyArraySizeException("Длина массива не равна 4!");
            }
        }
        for (int k = 0; k < arr.length; k++) {
            for (int j = 0; j < arr[k].length; j++) {
                if (!MySumArray.isNumber(arr[k][j])) {
                    try {
                        throw new MyArrayDataException("В одной из ячеек не число, адрес ячейки " + k + " " + j);
                    } catch (MyArrayDataException e) {
                        e.printStackTrace();
                    }
                }
                res += parseInt(arr[k][j]);

            }
        }
        return res;
    }
}
