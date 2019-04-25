package MaxHeap;
public class Array<E> {

    private E[] data;
    private int size;

    // 鏋勯�犲嚱鏁帮紝浼犲叆鏁扮粍鐨勫閲廲apacity鏋勯�燗rray
    @SuppressWarnings("unchecked")
	public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 鏃犲弬鏁扮殑鏋勯�犲嚱鏁帮紝榛樿鏁扮粍鐨勫閲廲apacity=10
    public Array(){
        this(10);
    }

    @SuppressWarnings("unchecked")
	public Array(E[] arr){
        data = (E[])new Object[arr.length];
        for(int i = 0 ; i < arr.length ; i ++)
            data[i] = arr[i];
        size = arr.length;
    }

    // 鑾峰彇鏁扮粍鐨勫閲�
    public int getCapacity(){
        return data.length;
    }

    // 鑾峰彇鏁扮粍涓殑鍏冪礌涓暟
    public int getSize(){
        return size;
    }

    // 杩斿洖鏁扮粍鏄惁涓虹┖
    public boolean isEmpty(){
        return size == 0;
    }

    // 鍦╥ndex绱㈠紩鐨勪綅缃彃鍏ヤ竴涓柊鍏冪礌e
    public void add(int index, E e){

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        if(size == data.length)
            resize(2 * data.length);

        for(int i = size - 1; i >= index ; i --)
            data[i + 1] = data[i];

        data[index] = e;

        size ++;
    }

    // 鍚戞墍鏈夊厓绱犲悗娣诲姞涓�涓柊鍏冪礌
    public void addLast(E e){
        add(size, e);
    }

    // 鍦ㄦ墍鏈夊厓绱犲墠娣诲姞涓�涓柊鍏冪礌
    public void addFirst(E e){
        add(0, e);
    }

    // 鑾峰彇index绱㈠紩浣嶇疆鐨勫厓绱�
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    // 淇敼index绱㈠紩浣嶇疆鐨勫厓绱犱负e
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    // 鏌ユ壘鏁扮粍涓槸鍚︽湁鍏冪礌e
    public boolean contains(E e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    // 鏌ユ壘鏁扮粍涓厓绱爀鎵�鍦ㄧ殑绱㈠紩锛屽鏋滀笉瀛樺湪鍏冪礌e锛屽垯杩斿洖-1
    public int find(E e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    // 浠庢暟缁勪腑鍒犻櫎index浣嶇疆鐨勫厓绱�, 杩斿洖鍒犻櫎鐨勫厓绱�
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E ret = data[index];
        for(int i = index + 1 ; i < size ; i ++)
            data[i - 1] = data[i];
        size --;
        data[size] = null; // loitering objects != memory leak

        if(size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    // 浠庢暟缁勪腑鍒犻櫎绗竴涓厓绱�, 杩斿洖鍒犻櫎鐨勫厓绱�
    public E removeFirst(){
        return remove(0);
    }

    // 浠庢暟缁勪腑鍒犻櫎鏈�鍚庝竴涓厓绱�, 杩斿洖鍒犻櫎鐨勫厓绱�
    public E removeLast(){
        return remove(size - 1);
    }

    // 浠庢暟缁勪腑鍒犻櫎鍏冪礌e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }

    public void swap(int i, int j){

        if(i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal.");

        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    // 灏嗘暟缁勭┖闂寸殑瀹归噺鍙樻垚newCapacity澶у皬
    private void resize(int newCapacity){

        @SuppressWarnings("unchecked")
		E[] newData = (E[])new Object[newCapacity];
        for(int i = 0 ; i < size ; i ++)
            newData[i] = data[i];
        data = newData;
    }
}
