class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int n = num1.length();
        int m = num2.length();
        int[] result = new int[n + m];

        for(int i = n - 1; i > -1; --i){
            for(int j = m - 1; j > -1; --j) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                product += result[i + j + 1];
                result[i + j + 1] = product % 10;
                result[i + j] += product / 10;
            }
        }

        String t = "";
        for(int i : result){
            if(t.isEmpty() && i == 0)
                continue;
            t += (char)(i + '0');
        }

        return t;

    }
}