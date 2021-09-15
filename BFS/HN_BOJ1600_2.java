package com.ssafy.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 최단거리 -> BFS
public class HN_BOJ1600_2 {
	static class coordinate {
		int k, y, x;

		public coordinate(int k, int y, int x) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
	static int[] monky_dx = { 0, 0, -1, 1 };
	static int[] monky_dy = { 1, -1, 0, 0 };
	static int[] hores_dx = { 1, 1, 2, 2, -1, -1, -2, -2 };
	static int[] hores_dy = { 2, -2, 1, -1, 2, -2, 1, -1 };
	static int K, W, H, answer;
	static int map[][];
	static int dp[][][];
	static boolean visited[][][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		for (int h = 0; h < H; h++) {
			st = new StringTokenizer(br.readLine());
			for (int w = 0; w < W; w++) {
				map[h][w] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[K + 1][H][W];
		answer = move();

		System.out.println(answer);

	}

	private static int move() {
		// 원숭이처럼 이동
		Queue<coordinate> q = new LinkedList<>();
		q.add(new coordinate(0, 0, 0));
		visited[0][0][0] = true;
		int level = -1;
		while (!q.isEmpty()) {
			int size = q.size();
			level++;
			for (int s = 0; s < size; s++) {
				coordinate now = q.poll();

				int ck = now.k;
				if (now.y == H - 1 && now.x == W - 1) {
					return level;
				}

				for (int i = 0; i < monky_dx.length; i++) {
					int ny = now.y + monky_dy[i];
					int nx = now.x + monky_dx[i];
					if (ny >= H || ny < 0 || nx >= W || nx < 0 || map[ny][nx] == 1 || visited[ck][ny][nx])
						continue;

					visited[ck][ny][nx] = true;
					q.add(new coordinate(ck, ny, nx));
				}

				if (ck < K) {
					// 말처럼 이동
					for (int i = 0; i < hores_dx.length; i++) {
						int ny = now.y + hores_dy[i];
						int nx = now.x + hores_dx[i];

						if (ny >= H || ny < 0 || nx >= W || nx < 0 || map[ny][nx] == 1 || visited[ck + 1][ny][nx])
							continue;

						visited[ck + 1][ny][nx] = true;
						q.add(new coordinate(ck + 1, ny, nx));
					}
				}

			}
		}
		
		return -1;
	}

}
