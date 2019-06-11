package medium;

public class LeetCode154_Find_Minimum_in_Rotated_Sorted_Array2 {
	public int findMin(int[] array) {
		int low = 0 ; int high = array.length - 1;   
        while(low < high){
            int mid = low + (high - low) / 2;        
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }   
        }
        return array[low];
	}

	public static void main(String[] args) {
		int arr[] = { 1,0,1,1,1 };
		int res = new LeetCode154_Find_Minimum_in_Rotated_Sorted_Array2().findMin(arr);
		System.out.println(res);
	}
}
