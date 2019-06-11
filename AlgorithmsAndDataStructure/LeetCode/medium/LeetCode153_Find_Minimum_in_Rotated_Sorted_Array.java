package medium;

public class LeetCode153_Find_Minimum_in_Rotated_Sorted_Array {
	public int findMin2(int[] nums) {
        if(nums.length == 1)return nums[0];
        int l = 0,r = nums.length - 1;
        int mid = 0;
        while(nums[l] >= nums[r]){
            if(r - l == 1){
                mid = r;
                break;
            }
            mid = (l + r) / 2;
            if(nums[l] <= nums[mid])
                l = mid;
            else if(nums[r] >= nums[mid])
                r = mid;
        }
        return nums[mid];
    }
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
	}
}
