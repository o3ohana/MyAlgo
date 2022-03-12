package SKICT;

import java.util.Arrays;

public class HN2 {
	static int dy1[] = { 0, 1, 0, -1 };
	static int dx1[] = { 1, 0, -1, 0 };
	static int dy2[] = { 1, 0, -1, 0 };
	static int dx2[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		int n = 3;
		boolean clockwise = true;
		int[][] answer = new int[n][n];
		boolean odd = n % 2 == 0 ? false : true;

		int init[][] = new int[4][2];
		if (clockwise) {
			init[0][0] = 0; // y
			init[0][1] = -1; // x
			init[1][0] = -1;
			init[1][1] = n - 1;
			init[2][0] = n - 1;
			init[2][1] = n;
			init[3][0] = n;
			init[3][1] = 0;
		} else {
			init[0][0] = -1; // y
			init[0][1] = 0; // x
			init[1][0] = n - 1;
			init[1][1] = -1;
			init[2][0] = n;
			init[2][1] = n - 1;
			init[3][0] = 0;
			init[3][1] = n;
		}

		int gab = 1;
		int cnt = 1;
		int dir = 0;
		int max = 0;
		if (clockwise) {
			for (int i = 0; i < 4; i++) {
				gab = 1;
				cnt = 1;
				dir = i;
				while (gab < n) {
					for (int j = 0; j < n - gab; j++) {
						init[i][0] += dy1[dir];
						init[i][1] += dx1[dir];
						answer[init[i][0]][init[i][1]] = cnt++;
					}
					gab += 2;
					dir = (dir + 1) % 4;
				}
				if (odd)
					max = Math.max(cnt, max);
			}
			if (odd)
				answer[n / 2][n / 2] = max;
		} else {
			for (int i = 0; i < 4; i++) {
				gab = 1;
				cnt = 1;
				dir = i;
				while (gab < n) {
					for (int j = 0; j < n - gab; j++) {
						init[i][0] += dy2[dir];
						init[i][1] += dx2[dir];
						answer[init[i][0]][init[i][1]] = cnt++;
					}
					gab += 2;
					dir = (dir + 1) % 4;
				}
				if (odd)
					max = Math.max(cnt, max);
			}
			if (odd)
				answer[n / 2][n / 2] = max;
		}
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(answer[i]));
		}
	}
}
