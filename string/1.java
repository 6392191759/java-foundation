package L006_String;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class String_001 {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {
		// 1. Lecture 6
		// 1.1 Strings demo and theory functional
		// 1.2 Strings questions
		// 1.2.1 printChars
		// 1.2.2 printSubStrings
		// 1.2.3 isPalindrome
		// 1.2.4 printPalindromicSubstrings
		// 1.3 Strings demo and theory conceptual
		// 1.4 StringBuilder
		// 1.4.1 toggleCase
		// 1.4.2 modify1 - odd pos(char + 1), even pos (char - 1)
		// 1.4.3 modify2 - between chars(difference)
		// 1.4.4 printSubSequence
		// 1.4.5 compress1
		// 1.4.6 compress2Numeric

		solve();
		pnter.close();
	}

	public static void solve() throws Exception {
		String str = scn.scanString();

		// printAllSubstrings(str);

		// AllPalindromicSubstrings(str);

		// AllPermutationByBits(str);

		// ToggleCase(str);

		// Modify1(str);

		// Modify2(str);

		// Compress(str);

		Compress2ByNumeric(str);

	}

	private static void PrintChar(String str) throws IOException {

		for (int i = 0; i < str.length(); i++) {
			pnter.print(str.charAt(i) + "");
		}
	}

	private static void printAllSubstrings(String str) throws IOException {

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				pnter.print(str.substring(i, j) + " ");
			}
			pnter.printLine("");
		}
	}

	private static boolean IsPalindrome(String str) throws IOException {
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}

		return true;
	}

	private static void AllPalindromicSubstrings(String str) throws IOException {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				if (IsPalindrome(str.substring(i, j))) {
					pnter.print(str.substring(i, j) + " ");
				}
			}
			pnter.printLine("");
		}
	}

	private static void AllPermutationByBits(String str) throws IOException {

		ArrayList<String> list = new ArrayList<String>();

		int count = factorial(str.length());
		// pnter.print(count + "");

		for (int i = 0; i < count; i++) {
			int divs = str.length();
			StringBuilder tempstr = new StringBuilder(str);
			StringBuilder CurrResult = new StringBuilder("");
			int divid = i;
			while (divs > 0) {
				int rem = divid % divs;
				int quo = divid / divs;

				divid = quo;

				CurrResult.append(tempstr.charAt(rem));
				tempstr.deleteCharAt(rem);
				divs--;
			}

			list.add(CurrResult.toString());
		}
		// pnter.print(list + "");
		for (String s : list) {
			pnter.printLine(s + "");
		}
	}

	private static void ToggleCase(String str) throws IOException {
		StringBuilder rstr = new StringBuilder("");
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				rstr.append((char) (str.charAt(i) | 32));
			} else {
				rstr.append((char) (str.charAt(i) & ~32));
			}
		}
		pnter.print(rstr.toString());
	}

	private static void Modify1(String str) throws IOException {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (i % 2 == 0) { // Even
				sb.append((char) (ch - 1));
			} else {
				sb.append((char) (ch + 1));
			}
		}

		pnter.printLine(sb.toString() + "");
	}

	private static void Modify2(String str) throws IOException {
		StringBuilder sb = new StringBuilder("");
		for (int i = 1; i < str.length(); i++) {
			char ch1 = str.charAt(i - 1);
			char ch2 = str.charAt(i);
			int diff = ch2 - ch1;
			sb.append(ch1);
			sb.append(diff);
		}

		sb.append(str.charAt(str.length() - 1));

		pnter.printLine(sb.toString());
	}

	private static void Compress(String str) throws IOException {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < str.length(); i++) {
			char ch1 = str.charAt(i - 1);
			char ch2 = str.charAt(i);

			if (ch1 != ch2) {
				sb.append(ch1);
			}
		}
		sb.append(str.charAt(str.length() - 1));

		pnter.printLine(sb.toString());
	}

	private static void Compress2ByNumeric(String str) throws IOException {
		int count = 1;

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				count++;
			} else {
				sb.append(str.charAt(i));
				sb.append(count);
				count = 1;
			}
		}

		sb.append(str.charAt(str.length() - 1));
		sb.append(count);

		pnter.printLine(sb.toString());
	}

	private static int factorial(int n) {
		int res = 1;
		for (int i = 1; i <= n; i++) {
			res *= i;
		}

		return res;
	}

	// -------------------------------------------------------------------------------------------------------------
