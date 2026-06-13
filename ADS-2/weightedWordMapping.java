public class weightedWordMapping {
    /*
in this ps, we gotta do-
iterate words then calc word wt 
then modulo 26 then do character mapping in reverse order as asked
then build the str by appending in res
*/

    public String mapWordWeights(String[] w, int[] wt) {
        StringBuilder res = new StringBuilder();

        for(String wd : w){
            int currWt = 0;
            for(char ch : wd.toCharArray()){
                currWt += wt[ch-'a'];
            }
            int rem = currWt%26;
            char temp=(char)('z'-rem);
            res.append(temp);
        }
        return res.toString();
    }
}
