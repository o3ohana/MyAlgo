package BOJ;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class HN_BOJ2164 {
	static int N;
	static Queue<Integer> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		q = new LinkedList<>();
		for (int n = 1; n <= N; n++) {
			q.add(n);
		}
		int answer = 0;
		boolean pass = false;
		while (!q.isEmpty()) {
			answer = q.poll();
			if (pass) {
				pass = false;
				q.add(answer);
			} else {
				pass = true;
			}
		}
		System.out.println(answer);
	}

}
