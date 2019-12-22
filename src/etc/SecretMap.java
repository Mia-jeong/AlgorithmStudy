package etc;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < arr1.length; i++) {
            String push = "";
            String a = makeBinaryString(arr1[i], n);
            //System.out.println("a " + a);
            String b = makeBinaryString(arr2[i], n);
            //System.out.println("b " + b);
            for (int j = 0; j < a.length(); j++) {
                int i1 = Integer.parseInt(a.charAt(j)+"");
                int i2 = Integer.parseInt(b.charAt(j)+"");
                if((i1 | i2) == 0) push+=" ";
                else push+="#";
            }
            System.out.println(push);
            answer[i] = push;

        }

        return answer;
    }

    public String makeBinaryString(int val, int n){
        String a = Integer.toBinaryString(val);
        if(a.length()< n)
            if(val <= 15)for (int j = a.length(); j < n ; j++) a="0"+a;
            else for (int j = a.length(); j < n ; j++) a+="0";

        return a;
    }

    public String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
    }

    public static void main(String[] args) {
        SecretMap sc = new SecretMap();
        int n = 5;
        int arr1[] = {9, 20, 28, 18, 11};
        int arr2[] = {30, 1, 21, 17, 28};
        sc.solution(n, arr1, arr2);
    }
}
