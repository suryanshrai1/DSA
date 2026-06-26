public class reversingWords {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int i = n - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (s.charAt(i) == ' ' && i < n - 1 && s.charAt(i + 1) != ' ') {
                sb.append(s.substring(i+1, j + 1)).append(' ');
                j = i;
            }
            else if(i==0){
                sb.append(s.substring(i, j+1));
            }
            if(s.charAt(j)==' '){
                j--;
            }
            i--;
        }
        return sb.toString().trim();
    }
}
