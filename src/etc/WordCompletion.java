package etc;

import java.util.HashMap;

public class WordCompletion {

    class Tries {
        int val;
        int count = 0;
        HashMap<Integer, Tries> children;

        public Tries(int val, int count) {
            this.val = val;
            this.count = count;
            children = new HashMap<>();
        }
    }
    public int solution(String[] words) {
        words = new String[]{"go", "gone", "guild"};
        int count = 0;
        HashMap<Integer, Tries> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            HashMap<Integer, Tries> tempMap = map;
            for (int j = 0; j < word.length(); j++) {
                int c2 = word.charAt(j);
                Tries tries = tempMap.get(c2);
                if(tries == null) {
                    tempMap.put(c2, new Tries(c2, 1));
                    tries = tempMap.get(c2);
                }else tries.count +=1;
                tempMap = tries.children;
            }
        }

        HashMap<Integer, Tries> Search = map;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            HashMap<Integer, Tries> tempMap = map;
            for (int j = 0; j < word.length(); j++) {
                int c2 = word.charAt(j);
                Tries tries = tempMap.get(c2);
                //System.out.print((char) tries.val + " count "+ tries.count+ " ");
                count++;
                if(tries.count <= 1) break;
                tempMap = tries.children;
            }
            //System.out.println();
            //System.out.println("count " + count);
        }
        //System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        WordCompletion w = new WordCompletion();
        w.solution(null);
    }
}
