package L009_Recursion_High;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Recursion_003_0 {
	// public static Scanner scn = new Scanner(System.in);
	private static Scan scn = new Scan(System.in);
	private static Print pnter = new Print();

	public static void main(String[] args) throws Exception {

		// 1.1 printBoardPath, BP16, BP16Ladders, BP16SnakesAndLadders
		// 1.2 printMazePath, printMPWithDiagonal, printMPWithMultiMoves,
		// floodfill

		solve();
		pnter.close();
	}

	public static void solve() throws Exception {

		// ArrayList<String> Boardpath =BoardPathAL(0, 10);
		// pnter.printLine(Boardpath+"");

		// BoardPath(0, 10, "");

		// Subsequence("abc", "");

		// keyPad("245", "");

		// ArrayList<String> MazePath_HV = MazePathAL_HV(0, 0, 2, 2);

		// pnter.printLine(MazePath_HV + "");

		// ArrayList<String> MazePath_HVD = MazePathAL_HVD(0, 0, 2, 2);
		// pnter.printLine(MazePath_HVD + "");

		// ArrayList<String> MazePathAL_MutiHVD = MazePathAL_MutiHVD(0, 0, 2,
		// 2);
		// pnter.printLine(MazePathAL_MutiHVD + "");

		// mazePath_HV(0, 0, 2, 2, "");

		// mazePath_HVD(0, 0, 3, 5, "");

		// mazePath_MultiHVD(0, 0, 2, 2, "");

		// int[][] maze = new int[5][6];
		// maze[0][1] = 1;
		// maze[0][5] = 1;
		// maze[1][3] = 1;
		// maze[1][5] = 1;
		// maze[3][4] = 1;
		// maze[4][3] = 1;
		// maze[3][2] = 1;
		// maze[3][3] = 1;
		// boolean[][] isdone = new boolean[maze.length][maze[0].length];
		// floodFill(0, 0, maze, "", isdone);

	}

	private static ArrayList<String> BoardPathAL(int src, int desti) {
		if (src == desti) {
			ArrayList<String> baseAl = new ArrayList<>();
			baseAl.add("\n");
			return baseAl;
		}

		ArrayList<String> myres = new ArrayList<>();

		for (int dice = 1; dice <= 6 && src + dice <= desti; dice++) {
			ArrayList<String> recRes = BoardPathAL(src + dice, desti);
			for (String res : recRes) {
				myres.add(res + dice);
			}
		}
		return myres;
	}

	private static void BoardPath(int src, int desti, String ans) throws IOException {
		if (src == desti) {
			pnter.printLine(ans);
			return;
		}

		for (int dice = 1; dice <= 6 && src + dice <= desti; dice++) {
			BoardPath(src + dice, desti, ans + dice);
		}
	}

	private static void Subsequence(String str, String ans) throws IOException {
		if (str.length() == 0) {
			pnter.print(ans + " ");
			return;
		}

		Subsequence(str.substring(1), ans + str.charAt(0));
		Subsequence(str.substring(1), ans);
	}

	private static String getcode(char ch) {
		if (ch == '1') {
			return "abc";
		} else if (ch == '2') {
			return "def";
		} else if (ch == '3') {
			return "ghi";
		} else if (ch == '4') {
			return "gil";
		} else if (ch == '5') {
			return "mno";
		} else if (ch == '6') {
			return "pqrs";
		} else if (ch == '7') {
			return "tuv";
		} else if (ch == '8') {
			return "wx";
		} else if (ch == '9') {
			return "yz";
		} else {
			return "./_";
		}
	}

	private static void keyPad(String str, String ans) throws IOException {
		if (str.length() == 0) {
			pnter.printLine(ans);
			return;
		}

		char ch = str.charAt(0);
		String roq = str.substring(1);
		String code = getcode(ch);
		for (int i = 0; i < code.length(); i++) {
			keyPad(roq, ans + code.charAt(i));
		}
	}

	private static ArrayList<String> MazePathAL_HV(int cr, int cc, int er, int ec) { // countRow,countcolumn,endrow,endcol.
		if (cr == er && cc == ec) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}

		ArrayList<String> myres = new ArrayList<>();

		if (cr + 1 <= er && cc <= ec) {
			ArrayList<String> recRes = MazePathAL_HV(cr + 1, cc, er, ec);
			for (String res : recRes) {
				myres.add("H" + res);
			}
		}

		if (cc + 1 <= ec && cr <= er) {
			ArrayList<String> recRes = MazePathAL_HV(cr, cc + 1, er, ec);
			for (String res : recRes) {
				myres.add("V" + res);
			}
		}

		return myres;

	}

	private static ArrayList<String> MazePathAL_HVD(int cr, int cc, int er, int ec) { // countRow,countcolumn,endrow,endcol.
		if (cr == er && cc == ec) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}

		ArrayList<String> myres = new ArrayList<>();

		if (cr + 1 <= er && cc <= ec) {
			ArrayList<String> recRes = MazePathAL_HVD(cr + 1, cc, er, ec);
			for (String res : recRes) {
				myres.add("H" + res);
			}
		}

		if (cc + 1 <= ec && cr <= er) {
			ArrayList<String> recRes = MazePathAL_HVD(cr, cc + 1, er, ec);
			for (String res : recRes) {
				myres.add("V" + res);
			}
		}

		if (cr + 1 <= er && cc + 1 <= ec) {
			ArrayList<String> recRes = MazePathAL_HVD(cr + 1, cc + 1, er, ec);
			for (String res : recRes) {
				myres.add("D" + res);
			}
		}

		return myres;

	}

	private static ArrayList<String> MazePathAL_MutiHVD(int cr, int cc, int er, int ec) { // countRow,countcolumn,endrow,endcol.
		if (cr == er && cc == ec) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}

		ArrayList<String> myres = new ArrayList<>();

		for (int i = 1; cr + i <= er && cc <= ec; i++) {
			ArrayList<String> recRes = MazePathAL_MutiHVD(cr + i, cc, er, ec);
			for (String res : recRes) {
				myres.add("H" + i + res);
			}
		}

		for (int i = 1; cc + i <= ec && cr <= er; i++) {
			ArrayList<String> recRes = MazePathAL_MutiHVD(cr, cc + i, er, ec);
			for (String res : recRes) {
				myres.add("V" + i + res);
			}
		}

		for (int i = 1; cr + i <= er && cc + i <= ec; i++) {
			ArrayList<String> recRes = MazePathAL_MutiHVD(cr + i, cc + i, er, ec);
			for (String res : recRes) {
				myres.add("D" + i + res);
			}
		}

		return myres;

	}

	private static void mazePath_HV(int cr, int cc, int er, int ec, String ans) throws IOException {
		if (cr == er && cc == ec) {
			pnter.printLine(ans + " ");
			return;
		}

		if (cr + 1 <= er && cc <= ec) {
			mazePath_HV(cr + 1, cc, er, ec, ans + "H");
		}

		if (cc + 1 <= ec && cr <= er) {
			mazePath_HV(cr, cc + 1, er, ec, ans + "V");
		}

	}

	private static void mazePath_HVD(int cr, int cc, int er, int ec, String ans) throws IOException {
		if (cr == er && cc == ec) {
			pnter.printLine(ans + " ");
			return;
		}

		if (cr + 1 <= er && cc <= ec) {
			mazePath_HVD(cr + 1, cc, er, ec, ans + "H");
		}

		if (cc + 1 <= ec && cr <= er) {
			mazePath_HVD(cr, cc + 1, er, ec, ans + "V");
		}

		if (cc + 1 <= ec && cr + 1 <= er) {
			mazePath_HVD(cr + 1, cc + 1, er, ec, ans + "D");
		}
	}

	private static void mazePath_MultiHVD(int cr, int cc, int er, int ec, String ans) throws IOException {

		if (cr == er && cc == ec) {
			pnter.printLine(ans);
			return;
		}

		for (int iH = 1; cr + iH <= er && cc <= ec; iH++) {
			mazePath_MultiHVD(cr + iH, cc, er, ec, ans + "H" + iH);
		}

		for (int iV = 1; cr <= er && cc + iV <= ec; iV++) {
			mazePath_MultiHVD(cr, cc + iV, er, ec, ans + "V" + iV);
		}

		for (int iD = 1; cr + iD <= er && cc + iD <= ec; iD++) {
			mazePath_MultiHVD(cr + iD, cc + iD, er, ec, ans + "D" + iD);
		}
	}

	private static void floodFill(int sr, int sc, int[][] maze, String path, boolean[][] isdone) throws IOException {
		// If_I_remove_all_elseif()_with_if()_then_we_get_all_backtracks.

		if (sr == maze.length - 1 && sc == maze[0].length - 1) {
			pnter.printLine(path + "");
			return;
		}

		if (sr + 1 <= maze.length - 1 && maze[sr + 1][sc] != 1 && !isdone[sr + 1][sc]) {
			isdone[sr + 1][sc] = true;
			floodFill(sr + 1, sc, maze, path + "(" + sr + ", " + sc + ") ", isdone);
			isdone[sr + 1][sc] = false;
		}

		else if (sc + 1 <= maze[0].length - 1 && maze[sr][sc + 1] != 1 && !isdone[sr][sc + 1]) {
			isdone[sr][sc + 1] = true;
			floodFill(sr, sc + 1, maze, path + "(" + sr + ", " + sc + ") ", isdone);
			isdone[sr][sc + 1] = false;
		}

		else if (sr + 1 <= maze.length - 1 && sc + 1 <= maze[0].length - 1 && maze[sr + 1][sc + 1] != 1
				&& !isdone[sr + 1][sc + 1]) {
			isdone[sr + 1][sc + 1] = true;
			floodFill(sr + 1, sc + 1, maze, path + "(" + sr + ", " + sc + ") ", isdone);
			isdone[sr + 1][sc + 1] = false;
		}

		else if (sr - 1 >= 0 && maze[sr - 1][sc] != 1 && !isdone[sr - 1][sc]) {
			isdone[sr - 1][sc] = true;
			floodFill(sr - 1, sc, maze, path + "(" + sr + ", " + sc + ") ", isdone);
			isdone[sr - 1][sc] = false;
		}

		else if (sc - 1 >= 0 && maze[sr][sc - 1] != 1 && !isdone[sr][sc - 1]) {
			isdone[sr][sc - 1] = true;
			floodFill(sr, sc - 1, maze, path + "(" + sr + ", " + sc + ") ", isdone);
			isdone[sr][sc - 1] = false;
		}

		else if (sr - 1 >= 0 && sc - 1 >= 0 && maze[sr - 1][sc - 1] != 1 && !isdone[sr - 1][sc]) {
			isdone[sr - 1][sc - 1] = true;
			floodFill(sr - 1, sc - 1, maze, path + "(" + sr + ", " + sc + ") ", isdone);
			isdone[sr - 1][sc - 1] = false;
		}
	}
	// -------------------------------------------------------------------------------------------------------------

	private static int[][] Eightdirction() {
		int[][] dirc = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

		return dirc;

	}
