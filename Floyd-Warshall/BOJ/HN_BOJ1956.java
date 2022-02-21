package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HN_BOJ1956 {
	static int V, E, answer;
	static int map[][];
	static final int INF = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;

		map = new int[V + 1][V + 1];
		for (int v = 0; v <= V; v++) {
			Arrays.fill(map[v], INF);
		}
		int from, to, W;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map[from][to] = W;
		}

		for (int m = 1; m <= V; m++) {
			for (int s = 1; s <= V; s++) {
				if (s == m || map[s][m] == INF)
					continue;

				for (int e = 1; e <= V; e++) {
					if (m == e || map[m][e] == INF)
						continue;
					int temp = map[s][m] + map[m][e];
					map[s][e] = Math.min(map[s][e], temp);
					if (s == e) {
						answer = Math.min(answer, map[s][e]);
					}
				} // for
			} // for
		} // for

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

}
