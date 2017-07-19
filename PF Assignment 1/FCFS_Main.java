package PF_Session_1;

public class FCFS_Main {

	public static void main(String args[]) {
		int a_Time[] = new int[] { 1, 5, 9, 25 }, job_Size[] = new int[] { 12,7, 2, 5 };

		FCFS fc = new FCFS();
		fc.fcfs(a_Time, job_Size);
	}
}

class FCFS {

	int a, b, c, d, i, j;

	public int[][] fcfs(int[] a_Time, int[] job_Size) {

		int[][] arr = new int[4][4];

		for (i = 0; i < a_Time.length; i++) {

			if (i == 0) {
				arr[i][0] = a_Time[i];
				arr[i][2] = 1;
				arr[i][1] = arr[i][2] - arr[i][0];
				arr[i][3] = job_Size[i];

			}

			else {
				arr[i][0] = a_Time[i];
				arr[i][2] = arr[i - 1][3] + 1;
				arr[i][1] = arr[i][2] - arr[i][0];
				arr[i][3] = job_Size[i] + arr[i - 1][3];

				if (arr[i][1] < 0) {
					arr[i][1] = 0;
					arr[i][3] = job_Size[i] + a_Time[i] - 1;
					arr[i][2] = a_Time[i];
				}

			}

		}

		for (i = 0; i < a_Time.length; i++) {

			for (j = 0; j < a_Time.length; j++) {
				System.out.print(arr[i][j] + "  ");
			}

			System.out.println();

		}
		
		
		return arr;

	}
}
