import java.util.Collection;

public class MyArrayList<E> {

    private Object[] array;
    private int size;

    public MyArrayList(){
        array = new Object[10];
        size = 0;
    }

    public void add(Object value){
        ensureCapacity(size + 1);
        array[size] = value;
        size++;
    }

    public void remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        for(int i = index; i < size - 1; i++){
            array[i]=array[i+1];
        }

        array[size - 1] = null;
        size--;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }

        size = 0;
    }

    public int size(){
        return size;
    }

    public E get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return (E) array[index];
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = array.length;

        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }

            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

}
