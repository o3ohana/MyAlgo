package com.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class HN_BOJ14002 {
	static int TC, N;
	static int[] data, lis;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 수열의 길이
		data = new int[N + 1]; // 입력되는 값들 저장 배열 
		lis = new int[N + 1]; // LIS 길이 저장할 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			data[n] = Integer.parseInt(st.nextToken());
		}
		
		// max lis 값 찾기
		int max = 0;
		
		//LIS[i]는 ARR[i]를 포함하는 LIS 길이
		for (int i = 1; i <= N; i++) {
			lis[i] = 1; // 초기값 : 자기 자신으로만 이루어진 수열의 경우
			for (int j = 0; j < i; j++) {
				if (data[i] > data[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
			
			max = Math.max(lis[i], max);
		}
		System.out.println(max);
		
		// lis 구성 숫자 찾아 출력하기
		int value = max;
		Stack<Integer> stack = new Stack<>();
		for (int i = N; i > 0; i--) {
			if(value == lis[i]) {
				stack.push(data[i]);
				value--;
			}
			
			if(value == 0)
				break;
		}
		
		StringBuffer buf = new StringBuffer();
		while(!stack.isEmpty()) {
			buf.append(stack.pop()).append(" ");
		}
		
		System.out.println(buf.toString());
	}

}
