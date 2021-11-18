package PG_81301;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] number_string 
            = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i < 10; i++){
            if(s.contains(number_string[i])){
                s = s.replaceAll(number_string[i],i+"");
            }
        }
        
        answer = Integer.parseInt(s);
        return answer;
    }
}