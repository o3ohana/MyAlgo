package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HN_BOJ10164 {
	static int M, N, K;
	static int dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[N + 1][M + 1];
		Arrays.fill(dp[1], 1);
		for (int i = 2; i <= N; i++) {
			dp[i][1] = 1;
			for (int j = 2; j <= M; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		if (K == 0 || N == 1 || M == 1) {
			System.out.println(dp[N][M]);
		} else {
			int x1 = (K % M) == 0 ? M : (K % M);
			int y1 = x1 == M ? (K / M) : (K / M) + 1;
			int y2 = N - y1 + 1;
			int x2 = M - x1 + 1;

			System.out.println(dp[y1][x1] * dp[y2][x2]);
		}
	}
}
