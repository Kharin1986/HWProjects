package HW_3_Collections;

import java.util.HashMap;

public class PhoneBook {
    public HashMap hashMap;

    public PhoneBook(HashMap hashMap) {
        this.hashMap = hashMap;
    }

    public void add(String name, String number) {
        hashMap.put(number, name);
    }

    public void get(String name) {

        for (Object key : hashMap.keySet()) { // вот здесь если написать String, то ругается, но ведь key - String!!!
           // System.out.println("Key: " + key);
            if (hashMap.get(key).equals(name)){
                System.out.println(name+" "+key);
            }
        }
    }
}
