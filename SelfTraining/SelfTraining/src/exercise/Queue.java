
package practise;
public interface Queue<Item>
{
    final int INITIAL_LENGTH = 4;

    final int SHRINK_FACTOR = 4;

    final int INCREASE_FACTOR = 2;

    public Item deque();

    public void enque(Item data);

    public int size();
}
