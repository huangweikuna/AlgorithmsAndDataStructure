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
		// �������1��ʼ�ƵĻ� ��Ϊindex/2
		return (index - 1) / 2;
	}

	private int leftChild(int index) {
		// ����Ǵ�1 ��ʼ�ƵĻ�Ϊ index * 2
		return index * 2 + 1;
	}

	@SuppressWarnings("unused")
	private int rightChil(int index) {
		// ����Ǵ�1��ʼ�ƵĻ�Ϊ index * 2 + 1
		return index * 2 + 2;
	}
	//ÿ�δ���������һ��λ�ÿ�ʼ����  Ȼ����жѵ�������
	//���ǳ��������Ϊ�ϸ�����
	public void add(E e) {
		data.addLast(e);
		//�����һ����㿪ʼ�ϸ�
		siftUp(data.getSize() - 1);
	}
	//Ԫ�ص��ϸ�����
	private void siftUp(int index) {
		//�������������Լ��ĸ��ڵ�  �򽻻��������
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
	//���������  Ҳ���ǶѶ�
	public E extractMax() {
		E ret = findMax();
		//���������еĵ�һ���������һ����
		data.swap(0, data.getSize() - 1);
		//ɾ�����һ����  ���ڸղŽ���֮��  ɾ������Ϊ�ѵĵ�һ����
		data.removeLast();
		//֮�����³�����
		siftDown(0);
		return ret;
	}
	private void siftDown(int index) {
		//�ҳ��³��Ľ�����������������Ƚϵ����ֵ
		while(leftChild(index) < data.getSize()) {
			int j = leftChild(index);
			if(j + 1 < data.getSize() &&
					data.get(j + 1).compareTo(data.get(j)) > 0) {
				j++;
			}
			//data[j] ΪleftChild �� rightChild �е����ֵ
			if(data.get(index).compareTo(data.get(j)) >= 0)
				break;
			data.swap(index, j);
			index = j;
		}
	}
}