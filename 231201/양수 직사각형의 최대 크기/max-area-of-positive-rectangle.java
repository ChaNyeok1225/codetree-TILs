import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int row, col;
	static int[][] arr;
	
	static int maxSize;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		arr = new int[row][col];
		
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int k = 1;
				int l = 1;
				int width = 0;
				int height = 1;
				int size = 0;
				
				if (arr[i][j] < 1) continue;
				
//				크기 체크 추가
				while (j + k < col && arr[i][j + k] > 0) {
					k++;
				}
				width = k;
				
				outer : while (i + l < row && arr[i + l][j] > 0) {
					boolean flag = true;
					for (int w = 1; w < width; w++) {
						if (arr[i + l][j + w] < 1) {
							flag = false;
							break outer;
						}
					}
					l++;
				}
				height = l;
				
				size = width * height;
				if (maxSize < size) maxSize = size;
//				if (size > 4) {
//					System.out.println(i);
//					System.out.println(j);
//					System.out.println(size);
//					System.out.println("==================");
//				}
			}
		}
		System.out.println(maxSize > 0 ? maxSize : -1);
	}
	
}