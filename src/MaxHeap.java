import java.util.Arrays;
public final class MaxHeap<T extends Comparable<? super T>> implements MaxHeapInterface<T> 
{
	private T[] heap;
	private int lastIndex;
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
	private int numSwaps = 0; // number of swaps


	public MaxHeap()
	{
		this(DEFAULT_CAPACITY); // call next constructor
	}

	public MaxHeap(int initialCapacity)
	{
		if(initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else
			checkCapacity(initialCapacity);

		@SuppressWarnings("unchecked")
		T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
		heap = tempHeap;
		lastIndex = 0;
		initialized = true;
	}

	/**
	 * Optimal method in the form of a constructor. Calls reheap() function.
	 * @param entries Array of comparable data type
	 */
	public MaxHeap(T[] entries)
	{
		this(entries.length); // call other constructor
		lastIndex = entries.length;
		assert initialized = true;

		// copy given array to data field
		for (int index = 0; index < entries.length; index++)
		{
			heap[index + 1] = entries[index];
		}

		// create heap
		for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
		{
			reheap(rootIndex);
		}
	} // end constructor

	/**
	 * Constructor that calls private method sequential insertion method. Takes in an array of comparable data type and
	 * a boolean flag.
	 * @param entries
	 * @param flag If flag is set to true, will call the sequential insertion private method. Else, will print statement
	 */
	public MaxHeap(T[] entries, boolean flag)
	{
		this(entries.length);
		// just added
		if (flag)
		{
			sequentialInsertion(entries);
		}
		else
		{
			System.out.println("If you would like call the optimal method, please remove boolean flag. ");
		}
	}

	public T getMax()
	{
		checkInitialization();
		T root = null;
		if(!isEmpty())
			root = heap[1];
		return root;
	} // end getMax

	public boolean isEmpty()
	{
		return lastIndex < 1;
	} // end isEmpty

	public int getSize()
	{
		return lastIndex;
	} // end getSize

	public void clear()
	{
		checkInitialization();
		while (lastIndex > -1)
		{
			heap[lastIndex] = null;
			lastIndex--;
		}
		lastIndex = 0;
	} // end clear

	public void add(T newEntry)
	{
		checkInitialization();
		int newIndex = lastIndex + 1;
		int parentIndex = newIndex / 2;
		while((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)
		{
			heap[newIndex] = heap[parentIndex];
			newIndex = parentIndex;
			parentIndex = newIndex / 2;
			numSwaps++; // keep track of the number of swaps
		} // end while
		heap[newIndex] = newEntry;
		lastIndex++;
		ensureCapacity();
	} // end add

	public T removeMax()
	{
		checkInitialization();
		T root = null;
		if(!isEmpty())
		{
			root = heap[1];	// return value
			heap[1] = heap[lastIndex];	// form a semiheap
			lastIndex--;	// decrease size
			reheap(1);	// transform to a heap
		}
		return root;
	} // end removeMax

	private void reheap(int rootIndex)
	{
		boolean done = false;
		T orphan = heap[rootIndex];
		int leftChildIndex = 2 * rootIndex;

		while (!done && leftChildIndex <= lastIndex)
		{
			int largerChildIndex = leftChildIndex; // assume larger
			int rightChildIndex = leftChildIndex + 1;
			if((rightChildIndex <= lastIndex) && heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0)
			{
				largerChildIndex = rightChildIndex;
			} // endif

			if(orphan.compareTo(heap[largerChildIndex]) < 0)
			{
				heap[rootIndex] = heap[largerChildIndex];
				rootIndex = largerChildIndex;
				leftChildIndex = 2 * rootIndex;

				// Keep track of the number of swaps
				numSwaps++;
			}
			else
			{
				done = true;
			}
		} // end while
		heap[rootIndex] = orphan;
	} // end reheap

	public int getNumSwaps() {return numSwaps; }

	/**
	 * Takes in an array of comparable data types T and sequentially inserts that data into a heap by calling add.
	 * @param content Array of comparable data type
	 */
	private void sequentialInsertion(T[] content)
	{
		for (int i = 0; i < content.length; i ++)
		{
			this.add(content[i]);
		}
	}

	/**
	 * Returns the heap array
	 * @return T[] Array of data type T
	 */
	public T[] getHeap() { return heap; }

	public void checkCapacity(int capacity)
	{
		if(capacity > MAX_CAPACITY) throw new IllegalStateException("Attempt to create a heap whose" +
				" capacity exceeds allowed " + "maximum of " + MAX_CAPACITY);
//			lastIndex = 0; // need to make exception
			
	} // end checkCapacity

	public void ensureCapacity()
	{
		checkCapacity(lastIndex);
		if (lastIndex >= heap.length - 1)
		{
			int newLength = 2 * heap.length;
			checkCapacity(newLength);
			heap = Arrays.copyOf(heap, newLength);
		}

	} // end ensureCapacity()

	public void checkInitialization()
	{
		if(!initialized)
			lastIndex = 0; // need to make exception
	
	} // end checkINitialization
}
