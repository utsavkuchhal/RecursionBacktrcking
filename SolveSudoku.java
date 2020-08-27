import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class Practise {

	public static void main(String[] args) {
        int[][] board = new int[][] { 
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
        }; 
        int N = board.length; 
        solution(board, 0, 0);
	}

	public static void solution(int[][] arr, int i, int j) {

		if (i == arr.length) {
			print(arr);
			return;
		}

		int ni = 0;
		int nj = 0;
		if (j == arr[0].length - 1) {
			nj = 0;
			ni = i + 1;
		}else {
			ni = i;
			nj = j + 1;
		}

		if (arr[i][j] != 0) {
			solution(arr, ni, nj);
		} else {
			for (int j2 = 1; j2 <= 9; j2++) {
				if (isValid(arr, j2, i, j) == true) {
					arr[i][j] = j2;
					solution(arr, ni, nj);
					arr[i][j] = 0;
				}
			}
		}
	}

	public static boolean isValid(int[][] arr, int val, int i, int j) {
		for (int j2 = 0; j2 < arr[0].length; j2++) {
			if (arr[i][j2] == val) {
				return false;
			}
		}

		for (int j2 = 0; j2 < arr.length; j2++) {
			if (arr[j2][j] == val) {
				return false;
			}
		}

		int boxi = i / 3 * 3;
		int boxj = j / 3 * 3;
		for (int k = 0; k < 3; k++) {
			for (int k2 = 0; k2 < 3; k2++) {
				if (arr[boxi + k][boxj + k2] == val) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
