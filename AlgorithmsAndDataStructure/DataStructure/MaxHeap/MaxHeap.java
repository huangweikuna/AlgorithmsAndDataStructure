package MaxHeap;

public class MaxHeap<E extends Comparable<E>> {
	private Array<E> data;

	public MaxHeap(int capacity) {
		data = new Array<>(capacity);
	}

	public MaxHeap() {
		data = new Array<>();
	}

	public MaxHeap(E[] arr) {
		data = new Array<>(arr);
	}

	public int getSize() {
		return data.getSize();
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	private int parent(int index) {
		if (index == 0)
			throw new IllegalArgumentException("index 0 doesn't have parent!");
		// 如果是重1开始计的话 则为index/2
		return (index - 1) / 2;
	}

	private int leftChild(int index) {
		// 如果是从1 开始计的话为 index * 2
		return index * 2 + 1;
	}

	@SuppressWarnings("unused")
	private int rightChil(int index) {
		// 如果是从1开始计的话为 index * 2 + 1
		return index * 2 + 2;
	}
	//每次从数组的最后一个位置开始插入  然后进行堆的重排序
	//我们称这个过程为上浮操作
	public void add(E e) {
		data.addLast(e);
		//从最后一个结点开始上浮
		siftUp(data.getSize() - 1);
	}
	//元素的上浮操作
	private void siftUp(int index) {
		//如果这个结点大于自己的父节点  则交换两个结点
		while(index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
			data.swap(index, parent(index));
			index = parent(index);
		}
	}
	public E findMax() {
		if(data.getSize() == 0)
			return null;
		return data.get(0);
	}
	//弹出最大数  也就是堆顶
	public E extractMax() {
		E ret = findMax();
		//交换链表中的第一个数个最后一个数
		data.swap(0, data.getSize() - 1);
		//删除最后一个数  由于刚才交换之后  删除的数为堆的第一个数
		data.removeLast();
		//之后做下沉操作
		siftDown(0);
		return ret;
	}
	private void siftDown(int index) {
		//找出下沉的结点左子树和右子树比较的最大值
		while(leftChild(index) < data.getSize()) {
			int j = leftChild(index);
			if(j + 1 < data.getSize() &&
					data.get(j + 1).compareTo(data.get(j)) > 0) {
				j++;
			}
			//data[j] 为leftChild 和 rightChild 中的最大值
			if(data.get(index).compareTo(data.get(j)) >= 0)
				break;
			data.swap(index, j);
			index = j;
		}
	}
}