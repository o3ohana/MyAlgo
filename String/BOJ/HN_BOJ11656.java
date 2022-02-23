package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class HN_BOJ11656 {
	static String str;
	static TreeSet<String> ts = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			ts.add(str.substring(i));
		}
		StringBuilder sb = new StringBuilder();
		for (String string : ts) {
			sb.append(string).append("\n");
		}
		System.out.println(sb);
	}
}
