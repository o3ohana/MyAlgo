package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HN_BOJ1806 {
	static int p1, p2, N, S, answer;
	static int[] input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		int temp = input[0];
		answer = Integer.MAX_VALUE;
		while (p1 < N) {
			if (temp >= S) {
				answer = Math.min(p2 - p1 + 1, answer);
			}

			if (temp < S && p2 < N - 1) {
				p2++;
				temp += input[p2];
			} else {
				temp -= input[p1];
				p1++;
			}
		}
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}

}
