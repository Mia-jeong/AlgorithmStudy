package leetcode.easy;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(temp == '(' || temp =='{' || temp =='['){
                stack.push(temp);
            }else{
                if(stack.isEmpty()) return false;
                Character top = stack.pop();
                if(temp == ')'){
                    if(top != '(')return false;
                }else if (temp == ']'){
                    if(top != '[')return false;
                }else{
                    if(top != '{')return false;
                }
            }
        }

        if(stack.isEmpty()) return true;
        else return false;

    }
}
