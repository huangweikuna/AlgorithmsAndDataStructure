package integers_move;
//消除数组中的规定的数val
//数组是未排序数组
public class LeetCode27 {
	//使用双指针  把满足的数放到数组的末尾
	public int removeElement(int[] nums, int val) {
		int l = 0, r = nums.length -1;
		while(l <= r) {
			if(nums[l] == val) {
				int temp = nums[l];
				nums[l] = nums[r];
				nums[r] = temp;
				r--;
			}else {
				l++;
			}
		}
		return l;
	}
	public static void main(String[] args) {
		int []nums = {1};
		LeetCode27 test = new LeetCode27();
		System.out.println(test.removeElement(nums,1));
	}
}
