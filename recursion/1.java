package L007_Recursion_Basic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Recursion_001 {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		// 1. Lecture 7
		// 1.1 Recursion intro - Functions, PMI
		// 1.2 Recursion questions
		// 1.2.1 PrintDecreasing
		// 1.2.2 PrintIncreasing
		// 1.2.3 PrintDecreasingIncreasing
		// 1.2.4 Factorial
		// 1.2.5 Power
		// 1.2.6 Tower of Hanoi

		solve();
		pnter.close();
	}

	public static void solve() throws Exception {
		int n = scn.scanInt();

		// PrintIncreasing(n);

		// PrintDecreasing(n);

		// PrintDecreasingIncreasing(n);

		// int fact = factorial(n);
		// pnter.print(fact + "");

		// int b = scn.scanInt();
		// int power = power(n, b);
		// pnter.print(power + "");

		// int b = scn.scanInt();
		// int powerBtr = powerBtr(n, b);
		// pnter.printLine(powerBtr + "");

		int res = printInstructionsForTOH("A", "B", "C", n);
		pnter.print(res + "");

	}

	private static void PrintIncreasing(int n) throws IOException {
		if (n == 0) {
			return;
		}

		PrintIncreasing(n - 1);
		pnter.printLine(n + "");
	}

	private static void PrintDecreasing(int n) throws IOException {
		if (n == 0) {
			return;
		}

		pnter.printLine(n + "");
		PrintDecreasing(n - 1);

	}

	private static void PrintDecreasingIncreasing(int n) throws IOException {
		if (n == 0) {
			return;
		}

		pnter.printLine(n + "");
		PrintDecreasingIncreasing(n - 1);
		if (n != 1) {
			pnter.printLine(n + "");
		}
	}

	private static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		int recRes = factorial(n - 1);
		return recRes * n;
	}

	private static int power(int a, int b) {
		if (b == 0) {
			return 1;
		}

		int recRes = power(a, b - 1);

		return recRes * a;

	}

	private static int powerBtr(int a, int b) {
		if (b == 0) {
			return 1;
		}

		int recRes = powerBtr(a, b / 2);

		recRes *= recRes;
		if (b % 2 != 0) {
			recRes *= a;
		}

		return recRes;

	}

	private static int printInstructionsForTOH(String src, String dest, String help, int n) throws IOException {
		if (n == 0) {
			return 0;
		}

		int a = printInstructionsForTOH(src, help, dest, n - 1);
		pnter.printLine(n + "th Disk from " + src + " to " + dest);
		int b = printInstructionsForTOH(help, dest, src, n - 1);
		return a + b + 1;
	}

	// -------------------------------------------------------------------------------------------------------------
