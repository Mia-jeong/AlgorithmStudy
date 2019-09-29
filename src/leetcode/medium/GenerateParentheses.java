package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        recursive(n-1, n , "(", list);
        return list;
    }
    public void recursive(int left, int right, String val, List<String> list){
        if(left ==0 && right == 0) {
            if(isValid(val)) list.add(val);
        }
        else if( left < 0 || right < 0) return;
        else {
            recursive(left-1, right, val+"(", list);
            recursive(left, right-1, val+")", list);
        }
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(temp == '('){
                stack.push(temp);
            }else{
                if(stack.isEmpty()) return false;
                Character top = stack.pop();
                if(top != '(')return false;
            }
        }

        if(stack.isEmpty()) return true;
        else return false;

    }

    //solution1 in discussion
    // ( < n
    // ) < (

    /*
            ( -- ) -- ) -- )   ((()))
          /
        (       ( -- ) -- )    (()())
       /  \   /
      /     )
     /        \
   (            ) -- ( -- )    (())()
     \         ( -- ) -- )     ()(())
      \      /
       ) -- (
             \
               ) -- ( -- )     ()()()

    * */
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}
