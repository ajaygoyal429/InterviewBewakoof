package main.java;

import java.util.*;

public class Main {

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        add("apple",list,map);
        String value = findKthMostRepeated(2, map);
        System.out.println(value);
    }

    private static String findKthMostRepeated(int k, Map<String, Integer> map) {
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int count = 0;
        for (Map.Entry<String,Integer> temp: list ) {
            count++;
            if(count==k){
                return temp.getKey();
            }
        }

        return "Not Found";
    }

    private static void add(String value, List<String> list, Map<String, Integer> map) {
        list.add(value);
        map.put(value,map.getOrDefault(value,0) + 1 );
    }
}





----------------------------------------------------------------------



2.
        Category : id, name
        Product : id, name, price, availabilityId
        Availability: id, name
        Customer: id, name, address, mobileNo
        Reviews: id, productId,customerId, comments, ratings
        Deals: id, name, productId, departmentId, percentageOff, codeRequired
