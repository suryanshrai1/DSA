public class removeSpace {
    String removeSpaces(String s){
        int n = s.length();
        char[] ch = s.toCharArray();

        int j=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == ' '){
                ch[j++] = s.charAt(i);
            }
        }
        return new String(ch,0, j);
    }
}
