import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int row, col;
	static int[][] arr;
	static int height, width, k, l, size;
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
				if (arr[i][j] < 1)
					continue;

				k = 1;
				while (j + k < col && arr[i][j + k] > 0) {
					k++;
				}
				width = k;
				for (int q = 1; q <= width; q++) {
					l = 1;
					height = 0;
					size = 0;
					outerA: while (i + l < row && arr[i + l][j] > 0) {
						for (int w = 1; w < q; w++) {
							if (arr[i + l][j + w] < 1) {
								break outerA;
							}
						}
						l++;
					}
					height = l;
					size = q * height;
					if (maxSize < size)
						maxSize = size;
				}

				k = 1;
				while (i + k < row && arr[i + k][j] > 0) {
					k++;
				}
				height = k;
				for (int q = 1; q <= height; q++) {
					l = 1;
					width = 0;
					size = 0;
					outerB: while (j + l < col && arr[i][j + l] > 0) {
						for (int h = 1; h < q; h++) {
							if (arr[i + h][j + l] < 1) {
								break outerB;
							}
						}
						l++;
					}
					width = l;
					size = width * q;
					if (maxSize < size)
						maxSize = size;
				}

//				System.out.println(i);
//				System.out.println(j);
//				System.out.println(size);
//				System.out.println("=================");
			}
		}
		System.out.println(maxSize > 0 ? maxSize : -1);
	}

}