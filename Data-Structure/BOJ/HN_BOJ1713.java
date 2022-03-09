package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class HN_BOJ1713 {
	static final int limit = 100;
	static int N, M;
	static int[] cnt, answer;
	static boolean[] in;

	static class Student {
		int no, recommend, time;

		public Student(int no, int recommend, int time) {
			this.no = no;
			this.recommend = recommend;
			this.time = time;
		}
	}

	static PriorityQueue<Student> table;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		table = new PriorityQueue<>((s1, s2) -> {
			if (s1.recommend == s2.recommend) {
				return Integer.compare(s1.time, s2.time);
			}
			return Integer.compare(s1.recommend, s2.recommend);
		});

		cnt = new int[limit + 1];
		in = new boolean[limit + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Student> q = new LinkedList<>();
		int idx = 0;
		for (int m = 0; m < M; m++) {
			idx = Integer.parseInt(st.nextToken());
			if (in[idx]) {
				int size = table.size();
				for (int i = 0; i < size; i++) {
					Student s = table.poll();
					if (s.no == idx) {
						s.recommend += 1;
						table.add(s);
						break;
					} else {
						q.add(s);
					}
				}
				while (!q.isEmpty()) {
					table.add(q.poll());
				}
			} else {
				if (table.size() >= N) {
					Student s = table.poll();
					in[s.no] = false;
					cnt[s.no] = 0;
				}
				in[idx] = true;
				table.add(new Student(idx, 1, m));
			}
		}

		PriorityQueue<Student> answer = new PriorityQueue<>((s1, s2) -> Integer.compare(s1.no, s2.no));
		int i = 0;
		while (!table.isEmpty()) {
			answer.add(table.poll());
		}

		StringBuilder sb = new StringBuilder();
		while (!answer.isEmpty()) {
			sb.append(answer.poll().no).append(" ");
		}
		System.out.println(sb);
	}

}
