package HW_3_Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String [] arr = {
                "красный",
                "оранжевый",
                "желтый",
                "зеленый",
                "голубой",
                "синий",
                "фиолетовый",
                "черный",
                "белый",
                "красный",
                "красный",
                "синий",
                "серый"
        };
       // calcUniq(arr);
// number - ключ, уникален. name - значение, может повторяться
        HashMap<String, String> hm1 = new HashMap<>();
        PhoneBook book = new PhoneBook(hm1);

        book.add("Иванов","12345");
        book.add("Петров","12340");
        book.add("Сидоров","12341");
        book.add("Иванов","12342");
     //   System.out.println(hm1);

        book.get("Иванов");

    }
    static void calcUniq(String [] array){
        HashSet<String> hs = new HashSet<String>();
        for (int i = 0; i <array.length; i++) {
            hs.add(array[i]);
        }
      //  System.out.println(hs);

        ArrayList<String> al = new ArrayList<String>();
        for (int i = 0; i <array.length; i++) {
            al.add(array[i]);
        }
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        Integer a;
        for (String color : al) {
            a = hm.get(color);// если такой строки нет еще в HashMap, то get вернет null
            hm.put(color, a == null ? 1 : a + 1);
        }
        System.out.println(hm);
    }
}
