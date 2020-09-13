/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t > 0){
            int n = scn.nextInt();
            int[] arr = new int[n];
            for (int i = 0;i < arr.length; i++){
                arr[i] = scn.nextInt();
            }
            
            Arrays.sort(arr);
            int sum = scn.nextInt();
            LinkedHashSet<String> set = new LinkedHashSet<>();
            solution(arr, sum, "", 0,set);
            String ans = "";
            for(String s : set){
                ans += s;
            }
            if(ans.length() > 0)
            System.out.println(ans);
            else
            System.out.println("Empty");
            t--;
        }
	}
	
    public static void solution(int[] arr,int sum,String ans,int index,LinkedHashSet<String> set){
        if (sum == 0){
            String finale = "(" + ans.trim() + ")";
            set.add(finale);
            return;
        } 
        
        if(sum < 0){
            return;
        }
        
        if(index >= arr.length){
            return;
        }
        solution(arr,sum - arr[index], ans + arr[index] + " ", index,set);
        
        solution(arr, sum, ans,index + 1,set);
    }
}
