import java.util.HashSet;

public class longestCommonPrefx {
    
    public int longestCommonPrefix(int[] arr1, int[] arr2) 
    {
       HashSet<String> set=new HashSet<>();
       for(int i=0;i<arr1.length;i++)
       {
        String s=String.valueOf(arr1[i]);
        for(int j=1;j<=s.length();j++)
        {
            set.add(s.substring(0,j));
        }

       }
       int ans=0;

       for(int i=0;i<arr2.length;i++)
       {
        String s=String.valueOf(arr2[i]);

        for(int j=1;j<=s.length();j++)
        {
            if(set.contains(s.substring(0,j)))
            ans=Math.max(ans,j);
        }
       }
       return ans;
    }

}
