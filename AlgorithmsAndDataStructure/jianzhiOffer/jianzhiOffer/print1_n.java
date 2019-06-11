package jianzhiOffer;

public class print1_n {
	public void print(int n) {
		char arr[] = new char[n];
		helper(arr,0);
	}
	private void helper(char[] arr,int index) {
		if(index == arr.length) {
			printf(arr);
			return;
		}
		
		for(int i = 0; i < 10; i ++) {
			arr[index] = (char) (i + '0');
			helper(arr,index + 1);
		}
	}
	
	private void printf(char[] arr) {
		boolean flag = true;
		for(char ch : arr) {
			if(flag && ch == '0')continue;
			else
				flag = false;
			
			if(!flag)
				System.out.print(ch);
		}
		if(!flag)System.out.println();
	}
	public double Power(double base, int exponent) {
        if(exponent == 0)return 1;
        if(exponent == 1)return base;
        int n = exponent < 0 ? -exponent : exponent;
        double res = Power(base,n >> 1);
        
        res = res * res;
        
        if((exponent & 1) == 1)
            res *= base;
        if(exponent < 0)return 1 / res;
        return res;
  }
	
	public static void main(String[] args) {
		double res = new print1_n().Power(-2,-2);
		System.out.println(res);
		System.out.println(0.1d == 0.1f);
	}
	
}
