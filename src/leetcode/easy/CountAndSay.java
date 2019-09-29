package leetcode.easy;

public class CountAndSay {
    /*
    1 > 11
    2 > 21     //11 > 2
    3> 1211   //21 >112 1
    4> 111221
    5> 132211  // 111 > 31 22 > 22 1 1
    6> 11132221 // 32 13
    n(n-1) > 1n
    n(n)> n2

    */
    public String countAndSay(int n) {
        String count = "1";
        int idx = 1;
        while(idx < n){
            int len = count.length()-1;
            String str = "";
            for (int i = 0; i <= len; i++) {
                int prev = Integer.parseInt(count.charAt(i)+"");
                int next = 0;
                if(i+1 <= len) {
                    next =  Integer.parseInt(count.charAt(i+1)+"");
                }
                //13 31 32
                //11 13 13
                if(prev > next || prev < next) str+=1+""+prev;
                 //11 22 33 222 333 111
                 //21 22 32 32  33 31
                else{
                    int sum = prev;
                    int nextnext = 0;
                    if(i+2 <= len) {
                        nextnext =  Integer.parseInt(count.charAt(i+2)+"");
                    }
                    if(prev > nextnext || prev < nextnext){
                        int t = next+prev;
                        if(t % 2 == 0) str+= 2+""+(t/2);
                        else str+=3+""+(t/3);
                        i+=1;
                    }
                    else {
                        str += 3+""+((prev*3)/3);
                        i+=2;
                    }
                }
            }
            idx++;
            count = str;
        }

        return count;
    }

    //solution in discussion
    public String countAndSay2(int n) {
        if (n == 1) return "1";
        String cur = countAndSay2(n-1);
        StringBuilder sb = new StringBuilder();
        int index =0;
        while(index < cur.length()) {
            char ch = cur.charAt(index);
            int count = 1;
            //222 3(count)2(ch)  333 3(count)3(ch)
            //111 3(count)1(ch)
            //11 2(count)1(ch) 22 2(count)2(ch)
            //33 2(count)3(ch)
            while(index+1 < cur.length() && cur.charAt(index+1) == cur.charAt(index)){
                index++;
                count++;
            }
            sb.append(count);
            sb.append(ch);
            index++;
        }
        return sb.toString();
    }


}
