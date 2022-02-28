package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class HN_BOJ2310 {
	static int N, temp;
	static int[] cost, visited;
	static char[] type;
	static boolean pass;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			type = new char[N + 1];
			cost = new int[N + 1];
			visited = new int[N + 1];
			Arrays.fill(visited, -1);
			list = new LinkedList[N + 1];
			for (int n = 1; n <= N; n++) {
				st = new StringTokenizer(br.readLine());
				list[n] = new LinkedList<>();
				type[n] = st.nextToken().charAt(0);
				cost[n] = Integer.parseInt(st.nextToken());
				while ((temp = Integer.parseInt(st.nextToken())) != 0) {
					list[n].add(temp);
				}
			}
			pass = true;
			bfs();
			sb.append(pass ? "Yes" : "No").append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 1, 0 });

		while (!q.isEmpty()) {
			int temp[] = q.poll();
			int cur = temp[0];
			int remain = temp[1];

			if (type[cur] == 'L' && remain < cost[cur]) {
				remain = cost[cur];
			} else if (type[cur] == 'T') {
				if (remain < cost[cur]) {
					continue;
				}
				remain -= cost[cur];
			}
			
			if (cur == N)
				return;

			for (int next : list[cur]) {
				if (visited[next] < remain) {
					visited[next] = remain;
					q.add(new int[] { next, remain });
				}
			}
		}

		pass = false;
	}

}
