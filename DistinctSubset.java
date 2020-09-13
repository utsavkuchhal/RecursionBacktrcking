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
            for (int i = 0; i < arr.length; i++){
                arr[i] = scn.nextInt();
            } 
            Arrays.sort(arr);
            LinkedHashSet<String> set = new LinkedHashSet<>();
            solution(0, arr, set, new ArrayList<Integer>());
            StringBuilder str = new StringBuilder("()");
            for(String s : set){
                str.append(s);
            }
            System.out.println(str);
            t--;
        }
	}
	
	public static void solution(int index, int[] arr, LinkedHashSet<String> set, ArrayList<Integer> subset){
	    
	    for (int i = index; i < arr.length; i++){
	        subset.add(arr[i]);
	        String s = "(";
	        for(int a : subset)
	            s = s + a + " ";
	            
	        s = s.trim();
	        
	        s = s + ")";
	        
	        set.add(s);
	        
	        solution(i + 1, arr, set, subset);
	        
	        subset.remove(subset.size() - 1);
	    } 
	}
	
}
