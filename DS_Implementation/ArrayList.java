package BuildDS;
import java.util.Arrays;
public class ArrayList {
    private int[] data;
    private static int DEFAULT_SIZE=10;
    private int index=0;

    public ArrayList() //constructor
    {
        this.data=new int[DEFAULT_SIZE];
    }

    private boolean isFull()
    {
        return index==data.length;
    }

    private void resize()
    {
        data=Arrays.copyOf(data, DEFAULT_SIZE*2);
    }
    public void add(int num)
    {
        if(isFull())
        {
            resize();
        }
        data[index++]=num;
    }
    public int remove()
    {
        int removed=data[--index];
        return removed;
    }
    public int get(int i)
    {
        return data[i];
    }
    public int size()
    {
        return index;
    }

    public void set(int index,int value)
    {
        data[index]=value;
    }
    @Override
    public String toString()
    {
        return "List{"+Arrays.toString(data)+"}";
    }
    public static void main(String[] args) {
        ArrayList list=new ArrayList();
        list.add(5);
        list.add(5);
        list.add(7);
        int size=list.size();
        for(int i=0;i<size;i++)
        {
            System.out.print(list.get(i)+" ");
        }
    }
}
