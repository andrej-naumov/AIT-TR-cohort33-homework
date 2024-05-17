package java.basic.naumov.map;

import java.util.HashMap;
import java.util.Map;

public class CollectionMap {
    public static void main(String[] args) {
        Map<String, String> phonesMap = new HashMap<>();
        phonesMap.put("Samsung", "Galaxy");

        System.out.println(phonesMap);
    }
}
