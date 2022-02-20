package ssafy.Day05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HN_BOJ2206 {
	static boolean visited[][][];
	static int map[][];
	static int[] dx = {1, -1, 0, 0}; 
	static int[] dy = {0, 0, 1, -1}; 
	static int N, M, answer;
	static class Block {
		int y, x;
		boolean crush;
		public Block(int y, int x, boolean crush) {
			this.y = y;
			this.x = x;
			this.crush = crush;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][M][2];
		map = new int[N][M];
		
		for (int n = 0; n < N; n++) {
			char[] tmp = br.readLine().toCharArray();
			for (int m = 0; m < M; m++) {
				map[n][m] = tmp[m] - '0';
			}
		}
		
		answer = -1;
		bfs();
		System.out.println(answer);
	}
	private static void bfs() {
		Queue<Block> q = new LinkedList<>();
		q.add(new Block(0, 0, false));
		visited[0][0][0] = true;
		
		int level = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			level++;
			for (int s = 0; s < size; s++) {
				Block b = q.poll();
				
				if(b.y == N-1 && b.x == M-1) {
					answer = level;
					return;
				}
				
				for (int i = 0; i < dx.length; i++) {
					int ny = b.y + dy[i];
					int nx = b.x + dx[i];
					
					if( ny < 0 || ny >= N || nx < 0 || nx >= M ) continue;
					
					int idx = b.crush ? 1 : 0;
					if(map[ny][nx] == 0 && !visited[ny][nx][idx]) {
						visited[ny][nx][idx] = true;
						q.add(new Block(ny, nx, b.crush));
					}else if(map[ny][nx] == 1 && b.crush == false) {
						visited[ny][nx][1] = true;
						q.add(new Block(ny, nx, true));
					}
					
				}
			}
		}
	}

}
