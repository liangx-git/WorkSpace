package com.liangx.practice;

import java.util.LinkedList;
import java.util.regex.Pattern;

class Solution {
    public int evalRPN(String[] tokens) {
               
        String result = "";
        
        if (null == tokens || 0 == tokens.length) return 0;
        
        LinkedList<String> s = new LinkedList<>();
        for (String token : tokens){
            
            //取到字符是操作符
            if (!isDig(token)) {
                //取出栈中数字
                if (s.size() >= 2) {
                    
                    String numb = s.pop();
                    String numa = s.pop();
                    char type = token.charAt(0);
                    int ret =calculation(numa, numb, type);
                    s.push(String.valueOf(ret));
                    
                } else {
                    s.push(token);
                }
            } else {
                s.push(token);
            }   
        }
        return Integer.parseInt(s.pop());
    }
    
    private boolean isDig(String num) {
        return Pattern.matches("[\\-]?[0-9]*", num);
    }
    
    private int calculation(String num1, String num2, char type) {
        int numa = Integer.parseInt(num1);
        int numb = Integer.parseInt(num2);
        
        int result = 0;
        switch(type) {
            case '+':
                result = numa + numb;
                break;
            case '-':
                result = numa - numb;
                break;
            case '*':
                result = numa * numb;
                break;
            case '/':
                result = numa / numb;
                break;
            default:
                System.out.println("不支持操作");
                break;
        }
        
        return result;
    }
    

}

public class StringTest{
    
    public static void main(String[] args) {
    	String[] inputs = new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
    	System.out.println(new Solution().evalRPN(inputs));
    	
    }
}













