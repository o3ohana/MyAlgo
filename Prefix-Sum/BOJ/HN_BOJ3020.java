package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HN_BOJ3020 {
	static int low[], high[];
	static int N, H, min, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		low = new int[H + 1];
		high = new int[H + 1];
		int halfN = N >> 1;
		int temp = 0;
		for (int n = 0; n < halfN; n++) {
			temp = Integer.parseInt(br.readLine());
			low[temp]++;

			temp = Integer.parseInt(br.readLine());
			high[temp]++;
		}

		for (int h = H - 1; h >= 1; h--) {
			high[h] += high[h + 1];
			low[h] += low[h + 1];
		}
		min = Integer.MAX_VALUE;
		for (int h = H; h >= 1; h--) {
			if (min > high[h] + low[H - h + 1]) {
				min = high[h] + low[H - h + 1];
				cnt = 1;
			} else if (min == high[h] + low[H - h + 1]) {
				cnt++;
			}
		}

		System.out.println(min + " " + cnt);
	}

}
