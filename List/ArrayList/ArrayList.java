package List.ArrayList;

import java.util.Arrays;

public class ArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ARRAY = {};

    private int size;
    Object[] array;

    public ArrayList(){
        this.size = 0;
        this.array = EMPTY_ARRAY;
    }

    public ArrayList(int capacity){
        this.size = 0;
        this.array = new Object[capacity];
    }

    private void resize(){
        int array_capacity = array.length;

        if(Arrays.equals(array, EMPTY_ARRAY)){
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        if(size == array_capacity){
            int new_capacity = array_capacity * 2;

            array = Arrays.copyOf(array, new_capacity);
            return;
        }

        if(size < (array_capacity / 2)){
            int new_capacity = array_capacity / 2;

            array = Arrays.copyOf(array, new_capacity);
            return;
        }
    }

    public boolean add(E value){
        addLast(value);
        return true;
    }


    public void add(int index, E value){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if(index == size) {
            addLast(value);
        }else {
            if (size == array.length) resize();

            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }

            array[index] = value;
            size++;
        }
    }

    public void addLast(E value) {
        if(size == array.length){
            resize();
        }
        array[size] = value;
        size++;
    }

    public void addFirst(E value){
        add(0, value);
    }


    public E get(int index){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        return (E) array[index];
    }


    public void set(int index, E value){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        array[index] = value;
    }

    public int indexOf(E value){
        int i = 0;

        for(i = 0;i < size;i++){
            if(array[i].equals(value)){
                return i;
            }
        }

        return -1;
    }

}

