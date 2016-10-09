package Backtracking;
public class TugOfWar {


	public static void main(String[] args)
	{
		 int[] a = {12 , 45, -34,23 , 0};//, 98, -99, 4, 189, -1, 4 };
		 int n = a.length;
		 int minDiff = Integer.MAX_VALUE;
		 boolean[] solution = new boolean[n];
		 boolean[] selected = new boolean[n];
		solve(0, a, n, minDiff, solution, selected);
		print(solution,a,n);
	}

	// the solution is simple,

	// 1. in each iteration, either add or remove the current element from the selected array
	// 2. check if we have already selected the requried number of elements, in that case update solution
	// 3. check if have already reached the end of the array, in that case, simply return
	protected static void solve(int currentIndex, int[] a, int n, int minDiff,boolean[] solution, boolean[] selected) {

		// get size of selected
		int selectedSize = 0;
		for (int i = 0; i < n; i++)
			if (selected[i])
				selectedSize++;

		if (selectedSize == n / 2) {
			// check if diff < minDiff, update solution
			int diff = getDiff(selected,a, n);
			if (diff < minDiff) {
				minDiff = diff;
				updateSolution(solution,selected,n);
			}
		}

		// check if currentIndex == n and return
		if (currentIndex >= n)
			return;

		// add curindex to selected
		selected[currentIndex] = true;
		solve(currentIndex + 1,a, n, minDiff, solution, selected);

		// remove curindex from selected
		selected[currentIndex] = false;
		solve(currentIndex + 1,a, n, minDiff, solution, selected);
	}

	protected static void updateSolution(boolean[] solution, boolean[] selected, int n)
	{
		for (int i = 0; i <n ; i++) {
			solution[i] = selected[i];
		}
	}

	protected static void print(boolean[] solution, int[] a, int n) {
		for (int i = 0; i < n; i++) {
			if (solution[i]) {
				System.out.print(a[i]);
				System.out.print(",");
			}
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			if (!solution[i]) {
				System.out.print(a[i]);
				System.out.print(",");
			}
		}
		System.out.println();
	}

	protected static int getDiff(boolean[] selected,int[] a, int n) {

		int leftSum = 0;
		int rightSum = 0;

		for (int i = 0; i < n; i++) {
			if (selected[i])
				leftSum += a[i];
			else
				rightSum += a[i];
		}

		return Math.abs(rightSum - leftSum);
	}
}