import java.io.*;
import java.util.*;

public class Main {
	
	private static FastReader in;
	
	public static void main(String[] args) {
		in = new FastReader();
		int tc = 1;
		tc = in.nextInt();
		for(int t = 0; t < tc; t++) {
			new Solver();
		}
	}
	
	static class Solver { 
		Solver() {
			int n = in.nextInt(), m = in.nextInt();
			int[] p = new int[m];
			for(int i = 0; i < m; i++) {
				p[i] = in.nextInt();
			}
			int[][] arr = new int[n][100];
			int[] c = new int[n];
			for(int i = 0; i < n; i++) {
				c[i] = in.nextInt();
				int[] temp = new int[c[i]];
				for(int j = 0; j < c[i]; j++) {
					temp[j] = in.nextInt();
				}
				Arrays.sort(temp);
				arr[i] = temp;
			}
			long res = 0;
			for(int i = 0; i < m; i++) {
				if(c[p[i]] > 0) {
					res += arr[p[i]][c[p[i]]-1];
					c[p[i]]--;
				}
			}
			System.out.println(res);
		}
	}
		
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
