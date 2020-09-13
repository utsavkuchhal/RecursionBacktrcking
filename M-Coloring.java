/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
       Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t > 0){
            int n = scn.nextInt();
            int[][] arr = new int[n][n];
            int m = scn.nextInt();
            int e = scn.nextInt();
            for (int i = 0; i < e; i++){
                int j = scn.nextInt() - 1;
                int k = scn.nextInt() - 1;
                arr[j][k] = 1;
                arr[k][j] = 1;
            } 
            if(solution(arr,0,m,new int[n])){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
            t--;
        }
        }
        
        	public static boolean solution(int[][] arr, int v, int m, int[] color){
	    if(v == arr.length){
	        return true;
	    }
	    
	    for(int i = 1; i <= m; i++){
	        if(isSafe(arr, v, i, color)){
	            color[v] = i;
	            
	            if(solution(arr, v + 1, m,color)){
	                return true;
	            }
	            
	            color[v] = 0;
	        }
	    }
	    return false;
	}
	
	public static boolean isSafe(int[][] arr, int v, int c, int[] color){
	    for (int i = 0; i < arr.length; i++){
	        if (arr[v][i] == 1 && color[i] == c){
	           return false; 
	        } 
	    }
	    return true;
	}
}
