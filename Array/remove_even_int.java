package Array;

import java.util.ArrayList;

class CheckRemoveEven {

	public static ArrayList<Integer> removeEven(int[] arr) {

		// Write - Your - Code- Here

		ArrayList<Integer> oddarr = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {

			if (arr[i]%2 != 0) {
				oddarr.add(arr[i]);
				
			}
		}
		return oddarr; // change this and return the correct result array
	}

	public static void main(String[] args) {


		int[] nums = {1,2,4,5,10,6,3};

		System.out.println(removeEven(nums));
	}
}