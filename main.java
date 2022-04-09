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
			// for every room, sort the bottles in non-decreasing order (by volume size)
			int[][] arr = new int[n][100];
			int[] c = new int[n];
			for(int room = 0; room < n; room++) {
				c[room] = in.nextInt(); // store the no. of bottles per room
				int[] temp = new int[c[room]];
				for(int bottle = 0; bottle < c[room]; bottle++) {
					temp[bottle] = in.nextInt();
				}
				Arrays.sort(temp);
				arr[room] = temp;
			}
			long ans = 0;
			for(int i = 0; i < m; i++) {
				if(c[p[i]] - 1 >= 0) {
					// for each room, start at the end of the sequence (bottle w/ max volume)
					ans += arr[p[i]][c[p[i]]-1];
					c[p[i]]--; // this will be the new bottle for the next iteration
				}
			}
			System.out.println(ans);
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
