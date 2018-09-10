import java.util.NoSuchElementException;

public class LinkedList<T> implements ReadonlyList<T>
{
    private ListNode<T> header = new ListNode<T>();

    public void bubbleSort(Comparator<T> c){
      boolean swapped = true;
      int limit = header.size();
      LinkedListIterator it = header.iterator();
      if(!header.isEmpty()&&iterator.hasNext()){
        iterator.next();
      }
      while(swapped&& !header.isEmpty()&&iterator.hasNext()){
        swapped = false;
        int j = 0;
        while(j +1 != limit){
          
        }
      }
    }
    public static <T> void bubbleSort(T[] a, Comparator<T> c) {
      boolean swapped = true;
      int limit = a.length;
      while (limit != 1 && swapped)
      {
          swapped = false;
          int j = 0;
          while (j + 1 != limit)
          {
              if (c.compare(a[j + 1], a[j]) < 0)
              {
                  swapped = true;
                  T temp = a[j + 1];
                  a[j + 1] = a[j];
                  a[j] = temp;
              }
              j++;
          }
          limit = j;
      }
    }
    public boolean isEmpty()
    {
        return header.getNext() == null;
    }

    public T getFirst()
    {
        ListNode<T> first = header.getNext();
        if (first == null)
        {
            throw new NoSuchElementException("List is empty, no item to get!");
        }
        else
        {
            return first.getValue();
        }
    }

    public void addFirst(T value)
    {
        // Create a new node
        ListNode<T> newNode = new ListNode<T>();

        // Store the new value in the new node
        newNode.setValue(value);

        // Link the new node to the old first node
        newNode.setNext(header.getNext());

        // Set the new node as the first node
        header.setNext(newNode);
    }

    public void removeFirst()
    {
        ListNode<T> first = header.getNext();
        if (first == null)
        {
            throw new NoSuchElementException("List is empty, no item to remove!");
        }
        else
        {
            header.setNext(first.getNext());
        }
    }

    public T get(int index)
    {
        int k = 0;
        ListNode<T> current = header.getNext();

        while (k < index && current != null)
        {
            k++;
            current = current.getNext();
        }

        if (current == null)
        {
            throw new IndexOutOfBoundsException(
                "Index: " + index + ", Size: " + k);
        }
        else
        {
            return current.getValue();
        }
    }

    public int size()
    {
        int k = 0;
        ListNode<T> current = header.getNext();

        while (current != null)
        {
            k++;
            current = current.getNext();
        }

        return k;
    }

    public String toString()
    {
        ListNode<T> current = header.getNext();
        if (current == null)
        {
            return "[]";
        }
        else
        {
            StringBuilder stringBuilder = new StringBuilder("[");
            stringBuilder.append(current.getValue());

            while(current.getNext() != null)
            {
                stringBuilder.append(", ");
                current = current.getNext();
                stringBuilder.append(current.getValue());
            }

            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public LinkedListIterator<T> iterator()
    {
        return new LinkedListIterator<T>(header);
    }
}
