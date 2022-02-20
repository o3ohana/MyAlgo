package com.ssafy.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HN_SWEA3124_2 {
	static class Node implements Comparable<Node> {
		int from, to, value;

		public Node(int from, int to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.value, n.value);
		}
	}

	static int TC, V, E;
	static int[] minDistance;
	static int[] parent;
	static boolean visited[];
	static Node nlists[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			// make Set
			parent = new int[V + 1];
			for (int v = 1; v <= V; v++) {
				parent[v] = v;
			}
			
			nlists = new Node[E];
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());

				nlists[e] = new Node(from, to, value);
			}
			
			Arrays.sort(nlists);
			int cnt = 0;
			long answer = 0;
			for (Node n : nlists) {
				if(union(n.from, n.to)) {
					answer += n.value;
					if(++cnt == V - 1) {
						break;
					}
				}
			}
			
			System.out.println("#" + tc + " "+answer);
		}
	}

	private static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa != pb ) {
			parent[pa] = pb;
			return true;
		}
		return false;
	}

	private static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

}
