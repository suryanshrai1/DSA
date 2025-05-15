import java.util.*;

public class EligibleForDisc {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [][] arr = new int[n][2];

        for(int i =0; i<n; i++){
            for(int j =0; j<2; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int count =0;

        int a = sc.nextInt();
        for(int i =0; i<n; i++){
            if( a % arr[i][0] == 0){
                count++;
            }
            else{
                System.out.println(0);
            }
        }
        System.out.println(count);
    }
}
