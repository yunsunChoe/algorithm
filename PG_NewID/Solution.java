package PG_NewID;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        //1
        answer = new_id.toLowerCase();
        //2
        answer = 
            answer.replaceAll("[[~][!][@][#][$][%]\\^[&][*]\\(\\)[=][+]\\[\\{\\]\\}[:][?][,]\\<\\>\\/]","");
        //3
        String dot = "";
        for(int i = 0; i <=  answer.length(); i++){
            dot = dot +".";
        }
        for(int i = answer.length(); i > 1 ; i--){
            String temp_dot = dot.substring(0,i);
            answer = answer.replace(temp_dot,".");
        }
        //4
        if(answer.charAt(0)=='.'){
            answer = answer.substring(1);
        }
       
        if(answer.length() > 0){
            if(answer.charAt(answer.length()-1)=='.'){
             answer = answer.substring(0,answer.length()-1);
             }
        }
        
        //5
        if(answer.length() == 0){
            answer = "a";
        }
        
        //6
        if(answer.length() >= 16){
            answer =  answer.substring(0, 15);
        }
        if(answer.length() > 0){
            if(answer.charAt(answer.length()-1)=='.'){
             answer = answer.substring(0,answer.length()-1);
             }
        }
        //7
        if(answer.length() <= 2){
            char last = answer.charAt(answer.length()-1);
            while(true){
                answer = answer + last;
                if(answer.length() == 3){
                    break;
                }
            }
        }
        return answer;
    }
}