
package practise;
public class QueueArray<Item> implements Queue<Item>
{
    protected Item[] array;

    private int first;

    private int N;

    public QueueArray()
    {

        this.array = (Item[]) new Object[Queue.INITIAL_LENGTH];
        this.N = 0;
        this.first = 0;
    }

    public int capacity()
    {
        return this.array.length;
    }

    /* (non-Javadoc)
     * @see practise.Queue#deque()
     */
    public Item deque()
    {
        if (this.isEmpty())
        {
            return null;
        }

        Item retItem = this.array[this.getFirst()];
        this.first = (++this.first) % this.array.length;
        this.N--;

        if ((this.N > Queue.INITIAL_LENGTH) && ((this.array.length / this.N) > Queue.SHRINK_FACTOR))
        {
            this.resize(this.array.length / Queue.INCREASE_FACTOR);
        }

        // TODO Auto-generated method stub
        return retItem;
    }

    /* (non-Javadoc)
     * @see practise.Queue#enque()
     */
    public void enque(Item data)
    {
        if (this.N >= this.array.length)
        {
            this.resize(Queue.INCREASE_FACTOR * this.array.length);
        }

        this.array[(this.getLast()) % this.array.length] = data;
        this.N++;
        // TODO Auto-generated method stub

    }

    public int getFirst()
    {
        return this.first;
    }

    public int getLast()
    {
        return this.first + this.size();
    }

    /**
     * @return
     */
    private boolean isEmpty()
    {
        // TODO Auto-generated method stub
        return this.getFirst() == this.getLast();
    }

    /**
     *
     */
    private void resize(int newSize)
    {
        // TODO Auto-generated method stub
        Item[] temp = (Item[]) new Object[newSize];
        int i = 0;
        int oldLength = this.N;
        while (i < oldLength)
        {
            temp[i] = this.deque();
            i++;
        }
        this.first = 0;
        this.N = oldLength;
        this.array = temp;
    }

    public void setFirst(int firstIndex)
    {
        this.first = firstIndex;
    }

    /* (non-Javadoc)
     * @see practise.Queue#size()
     */
    public int size()
    {
        // TODO Auto-generated method stub
        return this.N;
    }

    public String toString()
    {
        String ret = "[";
        if (this.isEmpty())
        {
            return ret + " ]";
        }

        int i = this.first;
        int count = 0;
        while (count < this.size())
        {
            ret += " ," + this.array[i];
            i = (++i) % this.array.length;
            count++;
        }

        return ret + " ]";
    }
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        QueueArray<String> queue = new QueueArray<String>();

        for (int i = 0; i < 4; i++)
        {
            queue.enque(Double.toString(Math.random()));
        }

        System.out.println(queue);

        for (int i = 0; i < 4; i++)
        {
            queue.deque();
        }
        System.out.println(queue);

        for (int i = 0; i < 4; i++)
        {
            queue.enque(Integer.toString(i));
        }

        System.out.println(queue);
        queue.enque(Integer.toString(10));
        System.out.println(queue);

        for (int i = 0; i < 1000; i++)
        {
            queue.enque(Double.toString(i));

        }

        for (int i = 0; i < 1000; i++)
        {
            if (i % 125 == 0)
            {
                queue.enque(Double.toString(i));
            }
            else
            {
                queue.deque();
            }

        }
        System.out.println(queue + "size " + queue.size() + " capacity " + queue.capacity());
    }
    
    

}
