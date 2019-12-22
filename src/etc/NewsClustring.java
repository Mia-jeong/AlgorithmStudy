package etc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//뉴스클러스트링
public class NewsClustring {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> arr1 = makeList(str1);
        List<String> arr2 = makeList(str2);
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.size(); i++) {
            String str = arr1.get(i);
            Integer t = map.get(str);
            if(t== null) map.put(str, 1);
            else map.put(str, t+1);
        }
        double intersection = 0;
        double total = 0;
        for (int i = 0; i < arr2.size(); i++) {
            String t = arr2.get(i);
            Integer in = map.get(t);
            if(in == null) continue;
            if(in >0) intersection++;
            map.put(t, --in);
        }
        total = (arr1.size()+arr2.size())-intersection;
        if(total == 0) answer = 65536;
        else {
            double d = Math.floor((intersection/total) * 65536);
            System.out.println("d " + d);
            answer = (int) d;
        }
        System.out.println("inter " + intersection + " total: " + total+ " answer " + answer);
        return answer;
    }
    public List<String> makeList(String str){
        List<String> arr = new ArrayList<>();
        for (int i = 0; i <= str.length()-2; i++) {
            char a = str.charAt(i);
            char b = str.charAt(i+1);
            if(a < 'A' || (a > 'Z' && a <'a') || a >'z') continue;
            if(b < 'A' || (b > 'Z' && b <'a') || b >'z') continue;
            a = Character.toLowerCase(a);
            b = Character.toLowerCase(b);
            arr.add(a+""+b);
        }
        return arr;
    }

    public static void main(String[] args) {
        NewsClustring n = new NewsClustring();
        n.solution("FRANCE", "french");
    }
}
