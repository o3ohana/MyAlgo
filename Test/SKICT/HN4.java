package SKICT;

import java.util.*;

public class HN4 {
	static List<Integer> list[];
	static boolean visited[];
	static long answer = 0;

	public static void main(String[] args) {
		int n = 4;
		int[][] edges = { { 0, 1 }, { 2, 3 }, { 1, 2 } };

		list = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new LinkedList<Integer>();
		}

		int len = edges.length;
		int from, to;
		for (int i = 0; i < len; i++) {
			from = edges[i][0];
			to = edges[i][1];
			list[from].add(to);
			list[to].add(from);
		}
		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			find(i);
		}
		System.out.println(answer);

	}

	private static void find(int start) {
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.add(start);
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			level++;
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				if (level > 2) {
					answer += (level - 2);
				}
				for (Integer next : list[cur]) {
					if (!visited[next]) {
						visited[next] = true;
						q.add(next);
					}
				}
			}
		}
	}
}
