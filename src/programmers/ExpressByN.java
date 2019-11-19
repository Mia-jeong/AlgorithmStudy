package programmers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//N으로 표현
public class ExpressByN {
    Map<Long, Integer> map = new HashMap<>();
    public int solution(int N, int number) {
        int answer = 0;
        int array[] = new int[8];
        int num = N;
        map.put((long)0, 1);
        map.put((long)N, 1);
        for (int i = 0; i < array.length; i++) {
            array[i] = num;
            num = num*10 + N;
        }
        int result = recursive((long)0, 0, array, number);
        System.out.println("heyho " + map.get(number));
        if(map.containsKey(number))answer = map.get(number);
        else answer = -1;

        return answer;
    }
    public int recursive(Long result, int count, int[] array, int answer){
        //if(count == 8) System.out.println("[ result ] " + result);
        if(map.get(12) != null) System.out.println(map.get(12)+ " //");
        if (count < 9){
           if(map.get(result) != null){
               int level = map.get(result);
               //if(count == 8)System.out.println(" level " + level);
               if(level > count) {
                   map.put(result, count);
               }
               //if(count == 8 )System.out.println(" after " + map.get(result));
           }else{
               map.put(result, count);
               //if(count == 4)System.out.println("gg");
           }

           if(result == answer) return count;
           for (int i = 0; i < array.length; i++) {
               if((count+i+1) < 9) {
                   int a = recursive(result - array[i], count + i + 1, array, answer);
                   int b = recursive(result + array[i], count + i + 1, array, answer);
                   int c = recursive(result + array[i], count + i + 1, array, answer);
                   int d = recursive(result / array[i], count + i + 1, array, answer);
                   //System.out.println("count " + count + " [ - ]: " + (result - array[i])+ " [ plus ] " + (result + array[i]) + " [multi ] " +  (result + array[i]) + " [divide ] " + result / array[i]+ "[count ]" + (count + i + 1));
               }
           }
        }
        return -1;
    }

    public static void main(String[] args) {
        ExpressByN e = new ExpressByN();
        int n = e.solution(5, 12);
        System.out.println("N: " + n);
    }
}
