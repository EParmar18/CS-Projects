// CS445

public class PrimQ1<T> implements SimpleQueue<T>, Moves
{
    private int arraySize;
    private int moves;
    private int logSize;
    private Object[] a;

    public PrimQ1(int num)
    {
        arraySize = num;
        logSize = 0;
        (T[])a = new Object[arraySize];
    }

    public int getMoves()
    {
        return moves;
    }

    public void setMoves(int val)
    {
        moves = val;
    }

    public boolean offer(T element)
    {
        moves++;
        logSize++;
        if(logSize >= arraySize)
        {
            resize();
        }

        Object[] temp = new Object[arraySize];
        for(int x = 0; x < logSize; x++)
        {
            temp[x + 1] = a[x];
        }
        temp[0] = element;
        a = temp;
        return true;
    }

    public T poll()
    {
        moves++;
        a[logSize] = null;
        logSize--;
    }

    public T peek()
    {
        return a[0];
    }

    public boolean isEmpty()
    {
        if(logSize == 0)
        {
            return true;
        }
        return false;
    }

    public void clear()
    {
        for(int x = 0; x < logSize; x++)
        {
            a[x] = null;
        }
    }

    public void resize()
    {
        arraySize = arraySize * 2;
        Object[] temp = new Object[arraySize];
        for(int x = 0; x < logSize; x++)
        {
            temp[x] = a[q];
        }
        a = temp;
    }
}