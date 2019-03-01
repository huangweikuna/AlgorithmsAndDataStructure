package SegmentTree;

//�߶���
public class SegmentTree<E> {
	private E[] data;
	private E[] tree;
	private Merger<E> merger;

	public SegmentTree(E[] arr, Merger<E> merger) {
		this.merger = merger;
		data = (E[]) new Object[arr.length];
		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
		}
		// �߶����Ĵ�С���Ϊ�����4��
		tree = (E[]) new Object[arr.length * 4];
		bulidSegmentTree(0, 0, arr.length - 1);
	}

	// ��treeIndex��λ�ô���[l...r]���߶���
	private void bulidSegmentTree(int treeIndex, int l, int r) {
		if (l == r) {
			tree[treeIndex] = data[l];
			return;
		}
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);
		int mid = l + (r - l) / 2;

		bulidSegmentTree(leftTreeIndex, l, mid);
		bulidSegmentTree(rightTreeIndex, mid + 1, r);
		tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
	}

	public int getSize() {
		return data.length;
	}

	public E get(int index) {
		if (index < 0 || data.length <= index)
			return null;
		return data[index];
	}

	private int rightChild(int treeIndex) {
		return treeIndex * 2 + 2;
	}

	private int leftChild(int treeIndex) {
		return treeIndex * 2 + 1;
	}

	// �������� [queryL...queryR]��ֵ
	public E query(int queryL, int queryR) {
		if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR)
			throw new IllegalArgumentException("Index is illegal.");
		return query(0, 0, data.length - 1, queryL, queryR);
	}

	private E query(int treeIndex, int l, int r, int queryL, int queryR) {
		if (l == queryL && r == queryR) {
			return tree[treeIndex];
		}
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);
		int mid = l + (r - l) / 2;
		// treeIndex�Ľڵ��Ϊ[l...mid]��[mid+1...r]������
		if (queryL >= mid + 1) {
			// ���ȫ�����ӵķ�Χ��
			return query(rightTreeIndex, mid + 1, r, queryL, queryR);
		} else if (queryR <= mid)
			// ���ȫ���Һ��ӵķ�Χ��
			return query(leftTreeIndex, l, mid, queryL, queryR);
		// ���������Χ���еĻ� �ֳ����εݹ������ Ҳ������߽������ӷ�Χ �ұ߽����Һ��ӵķ�Χ
		// [l...mid] ���� [queryL...mid]
		// [mid + 1 ... r] ����[mid + 1 ...queryR]
		E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
		E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
		return merger.merge(leftResult, rightResult);
	}

	public void set(int index,E e) {
		 if(index < 0 || index >= data.length)
	            throw new IllegalArgumentException("Index is illegal");
		 data[index] = e;
		 //�����߶���
		 set(0 ,0 ,data.length -1 ,index ,e);
	}

	// ����treeIndexΪ�����߶��и���index��ֵe
	private void set(int treeIndex, int l, int r, int index, E e) {
		if (l == r) {
			tree[treeIndex] = e;
			return;
		}
		// treeIndex�Ľڵ��Ϊ[l...mid]��[mid+1...r]������
		int leftTreeIndex = leftChild(treeIndex);
		int rightTreeIndex = rightChild(treeIndex);
		int mid = l + (r - l) / 2;
		if (index > mid + 1) {
			set(rightTreeIndex, mid + 1, r, index, e);
		} else {
			set(leftTreeIndex, l, mid, index, e);
		}
		// ����ֵ��Ҫ�������ĸ��ڵ��ֵ
		tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
	}

}