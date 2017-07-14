package PF_Session_1;

public class FCFS_Main {

	public static void main(String args[]) {
		int a_time[] = new int[] { 1, 5, 9, 25 }, job_size[] = new int[] { 12,
				7, 2, 5 };
		FCFS fc = new FCFS();
		fc.fcfs(a_time, job_size);
	}
}

class FCFS {

	int a, b, c, d, i, j;

	public int[][] fcfs(int[] a_time, int[] job_size) {

		int[][] arr = new int[4][4];

		for (i = 0; i < a_time.length; i++) {

			if (i == 0) {
				arr[i][0] = a_time[i];
				arr[i][2] = 1;
				arr[i][1] = arr[i][2] - arr[i][0];
				arr[i][3] = job_size[i];

			}

			else {
				arr[i][0] = a_time[i];
				arr[i][2] = arr[i - 1][3] + 1;
				arr[i][1] = arr[i][2] - arr[i][0];
				arr[i][3] = job_size[i] + arr[i - 1][3];

				if (arr[i][1] < 0) {
					arr[i][1] = 0;
					arr[i][3] = job_size[i] + a_time[i] - 1;
					arr[i][2] = a_time[i];
				}

			}

		}

		for (i = 0; i < a_time.length; i++) {

			for (j = 0; j < a_time.length; j++) {
				System.out.print(arr[i][j] + "  ");
			}

			System.out.println();

		}
		
		
		return arr;

	}
}
