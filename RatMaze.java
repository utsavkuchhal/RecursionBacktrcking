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
		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0;i < n; i++){
		    for (int j = 0; j < n; j++){
		        arr[i][j] = scn.nextInt();
		    } 
		} 
		ArrayList<String> list = new ArrayList<>();
		solution(list, "", 0, 0, new boolean[n][n], arr);
	}
	
	public static void solution(ArrayList<String> list, String ans, int i, int j, boolean[][] visited, int[][] arr){
	    
	   if (i == arr.length - 1 && j == arr.length  - 1){
            System.out.println(ans);
	        return;
	    } 
	    
	    if(i < 0 || j < 0 || i >= arr.length || j >= arr.length || arr[i][j] == 0 || visited[i][j]){
	        return;
	    }
	    
	 
	    
	    
	    
	    visited[i][j] = true;
	    solution(list, ans + "D", i + 1, j, visited,arr);
	     solution(list, ans + "R", i, j + 1, visited,arr);
        solution(list, ans + "U", i - 1, j, visited,arr);
	    solution(list, ans + "L", i - 1, j, visited,arr);
	    visited[i][j] = false;
	}
}
