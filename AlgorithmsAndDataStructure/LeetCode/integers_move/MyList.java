package integers_move;
public class MyList<T> {
	int size;
	int capacity;
	T[] data;

	@SuppressWarnings("unchecked")
	MyList() {
		data = (T[]) new Object[10];
		size = 0;
		capacity = 10;
	}

	public void push_back(T e) {
		if (size == capacity) {
			resize(2 * capacity);
		}
		data[size++] = e;
	}

	public T pop_back() {
		T ret = data[size - 1];
		size--;
		// æ˘ÃØ∏¥‘”∂» -- ±‹√‚∏¥‘”∂»’µ¥
		if (size == capacity / 2) {
			resize(capacity / 2);
		}
		return ret;
	}

	private void resize(int i) {
		@SuppressWarnings("unchecked")
		T[] newData = (T[]) new Object[i];
		for (int j = 0; j < size; j++) {
			newData[j] = data[j];
		}
		capacity = i;
		data = newData;
	}

	public static void main(String[] args) {
		
		MyList<Integer> list = new MyList<Integer>();
		for (int i = 0; i < 100; i++) {
			long begin;
			long end;
			list.push_back(10);
			if (i == 9) {
				begin = System.currentTimeMillis();
				for (int j = 0; j < 4000000; j++) {
					list.push_back(10);
					list.pop_back();
				}
				end = System.currentTimeMillis();
				System.out.println( end);
				System.out.println( begin);
				System.out.println( end - begin);
				break;
			}
		}
		

	}
}