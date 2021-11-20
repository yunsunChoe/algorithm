package PG_1_86051;

import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = -1;
        
        Arrays.sort(numbers);
        
        int[] target = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        
        int j = 0;
        int count = 0;
        
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == j){
                target[j] = 0;
                j++;
            }else{
                target[numbers[i]] = 0;
                j += 2;
            }
        }
        
        for(int i = 0; i < 10; i++){
            if(target[i] == -1){
                count += i;
            }
        }
        
        if(count != 0){
            answer = count;
        }

        return answer;
    }
}