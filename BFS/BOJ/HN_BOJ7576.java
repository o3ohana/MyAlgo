package ssafy.Day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HN_BOJ7576 {
	static int[][] map;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1 };
	static int M, N, day;
	static class Tomato {
		int y, x, d;

		public Tomato(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
	static Queue<Tomato> q = new LinkedList<>();
 	public static void main(String[] args) throws Exception{
		// 익을 수 있는 환경인지 확인 필요
		// 익을 수 있는 환경이 아니면 -1
		// 1인 위치를 초기에 q에 넣는다.
		// 0을 1로 바꾸면 그때 q에 넣는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) q.add(new Tomato(i, j, 0));
			}
		}
		
		day = 0;
		bfs();
		
		System.out.println(day);
	}
 	// 지도를 바꾸면 안될 때, 방문 배열로 체크한다.
 	// 지도를 바꿔도 되지만 돌아가면 안될 때, 방문 배열을 쓴다.
	private static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Tomato t = q.poll();
				
				for (int d = 0; d < dx.length; d++) {
					int ny = t.y + dy[d];
					int nx = t.x + dx[d];
					
					if(ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] != 0)
						continue;
					
					map[ny][nx] = 1;
					q.add(new Tomato(ny, nx, t.d + 1));
					day = Math.max(day, t.d + 1);
				}
			}
		}
		
		// 익지 않은 토마토 존재
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0)
					day = -1;
			}
		}
		
	}

}
