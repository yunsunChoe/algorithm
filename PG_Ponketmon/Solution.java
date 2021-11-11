package PG_Ponketmon;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(1,1);
        map.putIfAbsent(1, map.get(2)+1);
        System.out.println(map.get(2));
        
    }
    
}
