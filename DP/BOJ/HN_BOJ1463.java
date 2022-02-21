package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HN_BOJ1463 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int cnt[] = new int[X+1];
		cnt[1] = 0 ;
		
		for (int x = 2; x <= X; x++) {
			cnt[x] = cnt[x-1] +1;
			if(x % 3 == 0) {
				cnt[x] = Math.min(cnt[x], cnt[x/3] + 1);
			}
			if(x % 2 == 0) {
				cnt[x] = Math.min(cnt[x], cnt[x/2] + 1);
			}
		}
		System.out.println(cnt[X]);
	}

}
