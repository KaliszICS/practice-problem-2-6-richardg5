public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int[] bubbleSort(double[] nums) {
		boolean swapped = true;
		int swaps = 0;
		int comparisons = 0;
		for (int i = 0; i < nums.length - 1 && swapped; i++) {
			swapped = false;
			for (int e = 0; e < nums.length - 1 - i; e++) {
				comparisons++;
				if (nums[e] > nums[e + 1]) {
					swaps += 3;
					double temp = nums[e];
					nums[e] = nums[e + 1];
					nums[e + 1] = temp;
					swapped = true;
				}
			}
		}
		return new int[]{swaps, comparisons};
	}

	public static int[] selectionSort(double[] nums) {
		int swaps = 0;
		int comparisons = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			int currMin = i;
			for (int e = i + 1; e < nums.length; e++) {
				comparisons++;
				if (nums[e] < nums[currMin]) {
					swaps++;
					currMin = e;
				}
			}
			swaps += 3;
			double temp = nums[i];
			nums[i] = nums[currMin];
			nums[currMin] = temp;
		}
		return new int[]{swaps, comparisons};
	}

	public static int[] insertionSort(double[] nums) {
		int swaps = 0;
		int comparisons = 0;
		for (int i = 1; i < nums.length; i++) {
			swaps++;
			double current = nums[i];
			int index = i - 1;
			while (index >= 0 && nums[index] > current) {
				comparisons++;
				nums[index + 1] = nums[index];
				swaps++;
				index--;
			}
			nums[index + 1] = current;
			swaps++;
		}
		return new int[]{swaps, comparisons};
	}

	public static String leastSwaps(double[] nums) {
		double[] copy = new double[nums.length];
		for (int i = 0; i < nums.length; i++) {
			copy[i] = nums[i];
		}
		int bubbleResult = bubbleSort(copy)[0];
		for (int i = 0; i < nums.length; i++) {
			copy[i] = nums[i];
		}
		int selectionResult = selectionSort(copy)[0];
		for (int i = 0; i < nums.length; i++) {
			copy[i] = nums[i];
		}
		int insertionResult = insertionSort(copy)[0];
		if (bubbleResult <= selectionResult) {
			if (bubbleResult <= insertionResult) {
				return "Bubble";
			} else {
				return "Insertion";
			}
		} else {
			if (selectionResult < insertionResult) {
				return "Selection";
			} else {
				return "Insertion";
			}
		}
	}

	public static String leastIterations(double[] nums) {
		double[] copy = new double[nums.length];
		for (int i = 0; i < nums.length; i++) {
			copy[i] = nums[i];
		}
		int bubbleResult = bubbleSort(copy)[1];
		for (int i = 0; i < nums.length; i++) {
			copy[i] = nums[i];
		}
		int selectionResult = selectionSort(copy)[1];
		for (int i = 0; i < nums.length; i++) {
			copy[i] = nums[i];
		}
		int insertionResult = insertionSort(copy)[1];
		if (bubbleResult <= selectionResult) {
			if (bubbleResult <= insertionResult) {
				return "Bubble";
			} else {
				return "Insertion";
			}
		} else {
			if (selectionResult < insertionResult) {
				return "Selection";
			} else {
				return "Insertion";
			}
		}
	}
}
