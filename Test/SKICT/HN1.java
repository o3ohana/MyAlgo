package SKICT;

import java.util.Arrays;

public class HN1 {
	static final int limit = 987654321;
	static int table[];
	public static void main(String[] args) {
		int money = 4578;
		int costs[] = {1, 4, 99, 35, 50, 1000};
		table = new int[money+1];
        Arrays.fill(table, limit);
        table[0] = 0;
        boolean k = true;
        int value = 1;
        for(int i = 0; i <= 5; i++){
            for(int m = value; m <= money; m++){
                table[m] = Math.min(table[m], table[m-value]+costs[i]);
            }
            if(k) {
            	k = false;
            	value *= 5;
            }else {
            	k = true;
            	value *=2;
            }
        }
        int answer = table[money];
        System.out.println(answer);
	}
}
