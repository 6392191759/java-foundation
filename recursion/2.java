package L007_Recursion_Basic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Recursion_002 {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		// 1. Lecture 8
		// 1.1 PrintTriangle
		// 1.2 PrintInvertedTriangle
		// 1.2 Array Recursion
		// 1.2.1 display
		// 1.2.2 reverse display
		// 1.2.3 max
		// 1.2.4 find
		// 1.2.5 firstIndex
		// 1.2.6 lastIndex
		// 1.2.7 allIndices
		// 1.2.8 inverse
		// 1.2.9 bubbleSort
		// 1.2.10 selectionSort

		solve();
		pnter.close();
	}

	public static void solve() throws Exception {

		int n = scn.scanInt();
		int[] arr = takeArrayInput(n);
		int vidx = 0;

		// display(arr, vidx);

		// ReverseDisplay(arr, vidx);

		// int max = max(arr, vidx);
		// pnter.print(max + "");

		// int find=find(arr, vidx, 2);
		// pnter.print(find+"");

		// int firstIndex=find(arr, vidx, 2);
		// pnter.print(firstIndex+"");

		// int lastIndex = LastIndex(arr, vidx, 2);
		// pnter.print(lastIndex+"");

		/* 10 2 3 4 2 5 6 2 9 2 1 */
		// int[] rarr = AllIndices(arr, vidx, 2, 0);
		// displayArray(rarr);

		// bubbleSort(arr, 0, n - 1);
		// displayArray(arr);

		// insertionSort(arr, 0, 0);
		// displayArray(arr);
		
		selectionSort(arr, 1, 1);
displayArray(arr);
	}

	private static void display(int[] arr, int vidx) throws IOException {
		if (vidx == arr.length) {
			return;
		}

		pnter.print(arr[vidx] + " ");
		display(arr, vidx + 1);

	}

	private static void ReverseDisplay(int[] arr, int vidx) throws IOException {
		if (vidx == arr.length) {
			return;
		}

		ReverseDisplay(arr, vidx + 1);
		pnter.print(arr[vidx] + " ");

	}

	private static int max(int[] arr, int vidx) {

		if (vidx == arr.length - 1) {
			return arr[vidx];
		}

		int recRes = max(arr, vidx + 1);

		return Math.max(recRes, arr[vidx]);

	}

	private static int find(int[] arr, int vidx, int ele) {
		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == ele) {
			return vidx;
		}

		return find(arr, vidx + 1, ele);
	}

	private static int FirstIndex(int[] arr, int vidx, int ele) {
		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == ele) {
			return vidx;
		}

		return FirstIndex(arr, vidx + 1, ele);

	}

	private static int LastIndex(int[] arr, int vidx, int ele) {
		if (vidx == arr.length) {
			return -1;
		}

		int resRec = LastIndex(arr, vidx + 1, ele);
		if (resRec != -1) {
			return resRec;
		} else if (arr[vidx] == ele) {
			return vidx;
		}

		return resRec;

	}

	private static int[] AllIndices(int[] arr, int vidx, int ele, int count) throws IOException {
		if (arr.length == vidx) {
			int[] rarr = new int[count];
			return rarr;
		}

		if (arr[vidx] == ele) {
			int[] resArr = AllIndices(arr, vidx + 1, ele, count + 1);
			resArr[count] = vidx;
			return resArr;
		} else {
			return AllIndices(arr, vidx + 1, ele, count);
		}

	}

	private static void inverse(int[] arr, int vidx) {
		if (vidx == arr.length - 1) {
			return;
		}

		inverse(arr, vidx + 1);
		arr[arr[vidx]] = vidx;
	}

	private static void TrianglePattern(int n, int i, int j) throws IOException {
		if (i > n) {
			return;
		}
		if (j <= i) {
			pnter.print("* ");
			TrianglePattern(n, i, j + 1);
		} else {
			TrianglePattern(n, i + 1, j);
		}
	}

	private static void bubbleSort(int[] arr, int st, int en) {
		if (en == 0) {
			return;
		}

		if (st == en) {
			bubbleSort(arr, 0, en - 1);
			return;
		}
		if (arr[st] > arr[st + 1]) {
			swap(arr, st, st + 1);
		}
		bubbleSort(arr, st + 1, en);
	}

	private static void insertionSort(int[] arr, int st, int vidx) {
		if (st == arr.length) {
			return;
		}

		if (vidx == arr.length) {
			insertionSort(arr, st + 1, st + 1);
			return;
		}

		if (arr[st] > arr[vidx]) {
			swap(arr, st, vidx);
		}

		insertionSort(arr, st, vidx + 1);
	}

	private static void selectionSort(int[] arr, int st, int vidx) {
		if(st==arr.length){
			return;
		}
		
		
		if(vidx==0){
			selectionSort(arr, st+1, st+1);
			return;
		}
		
		
		if (arr[vidx-1] > arr[vidx]) {
			swap(arr, vidx-1, vidx);
		}else{
			selectionSort(arr, st+1, st+1);
			return;

		}
		
		
		selectionSort(arr, st, vidx-1);

	}

	// -------------------------------------------------------------------------------------------------------------
