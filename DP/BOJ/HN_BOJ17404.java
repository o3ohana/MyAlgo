package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HN_BOJ17404 {
	static int map[][], dp[][];
	static int N, answer;
	static final int INF = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][3];
		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = INF;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				dp[0][j] = INF;
			}
			dp[0][i] = map[0][i];
			for (int j = 1; j < N; j++) {
				dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + map[j][0];
				dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + map[j][1];
				dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + map[j][2];
			}

			for (int j = 0; j < 3; j++) {
				if (i == j)
					continue;
				answer = Math.min(answer, dp[N - 1][j]);
			}
		}

		System.out.println(answer);
	}

}
