package ru.nsu.fit.oop.lab3;

import java.util.EmptyStackException;


public class Stack <T>{

    private int maxSize;
    private T[] arr;
    private int id;


    @SuppressWarnings("unchecked")
    public Stack (int maxSize)
    {
        this.maxSize = maxSize;
        arr = (T[]) new Object[maxSize];
        id = 0;
    }

    /**
     * amount getter
     * @return Stack.AmountOfElems
     */
    public int getAmount()
    {
        return id;
    }
    @SuppressWarnings("unchecked")
    private void realloc()
    {
        T[] newArray = (T[]) new Object[maxSize * 2];
        System.arraycopy(arr, 0, newArray, 0, id);
        arr = newArray;
        maxSize *=2;
    }

    /**
     * adding to the Stack and realloc array if needed
     * @param elem
     */
    public void push(T elem)
    {
        if (id == maxSize)
            realloc();

        arr[id++] = elem;

    }

    /**
     * method for popping from stack.
     * @return the last added elem from the stack
     * @throws EmptyStackException if you'll try to pop from empty stack.
     */
    public T pop() throws EmptyStackException
    {
        if (id == 0)
            throw new EmptyStackException();
        else
            return arr[--id];
    }

    /**
     * method for popping from stack.
     * @return the n last element from stack like type stack
     * @throws EmptyStackException if you'll try to pop from empty stack or if count of pushing stack more than existing one
     */
    public Stack<T> popStack(int count) throws EmptyStackException
    {
        Stack <T> returnStack = new Stack<T>(count);
        if (id == 0 || id < count)
            throw new EmptyStackException();
        else {

            for(int i = 0; i < count; ++i){
                returnStack.push(arr[id-1]);
                arr[id-1] = null;
                --id;
            }
        }
        return returnStack;
    }
}