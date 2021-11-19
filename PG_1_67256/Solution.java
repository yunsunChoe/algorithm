package PG_1_67256;

import java.lang.Math;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        //* : 10, 0 : 11, # : 12
        //왼손 현재 위치 /3
        int L = 10; //*
        int lx = 3; int ly = 0;
        
        //오른손 현재 위치 /3-1
        int R = 12; //#
        int rx = 3; int ry = 2;
        
        //숫자 위치
        int nx = -1; int ny = -1;
        
        for(int i = 0; i < numbers.length; i++){
            int temp_number = numbers[i];
            if(temp_number == 0){
                temp_number = 11;
            }
            //왼쪽숫자면 왼손
            if(temp_number % 3 == 1){
                answer = answer + "L";
                L = temp_number;
            }
            //오른쪽숫자면 오른손
            else if(temp_number % 3 == 0){
                answer = answer + "R";
                R = temp_number;
            }
            //가운데 숫자라면...?
            else{
                //현재 위치 설정(가운데숫자임)
                nx = temp_number/3; ny = 1;
                //L이 왼쪽일 때
                if(L%3 == 1){
                    lx = L/3; ly = 0;
                }
                //L이 가운데일 때
                else if(L%3 == 2){
                    lx = L/3; ly = 1;
                }
                //R이 가운데일 때
                if(R%3 == 2){
                    rx = R/3; ry = 1;
                }
                //R이 오른쪽일 때
                else if(R%3 == 0){
                    rx = R/3-1; ry = 2;
                }
                
                double temp_L = Math.abs(nx-lx) + Math.abs(ny-ly);
                double temp_R = Math.abs(nx-rx) + Math.abs(ny-ry);
                
                if(temp_L < temp_R){
                    answer = answer + "L";
                    L = temp_number;
                }else if(temp_L > temp_R){
                    answer = answer + "R";
                    R = temp_number;
                }else if(temp_L == temp_R){
                    if(hand.equals("left")){
                        answer = answer + "L";
                        L = temp_number;
                    }else{
                        answer = answer + "R";
                        R = temp_number;
                    }
                }
            }
           
        }
        
        
        return answer;
    }
}