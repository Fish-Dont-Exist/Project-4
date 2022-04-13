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

	public MaxHeap(T[] entries)
	{
		this(entries.length); // call other constructor
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

		while (!done && leftChildIndex <- lastIndex)
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
			}
			else
				done = true;
		} // end while
		heap[rootIndex] = orphan;
	} // end reheap

	public int getNumSwaps() {return numSwaps; }

	public void checkCapacity(int cap)
	{
		if(cap > MAX_CAPACITY || cap < 0)
			lastIndex = 0; // need to make exception
			
	} // end checkCapacity

	public void ensureCapacity()
	{
		checkCapacity(lastIndex);
	} // end ensureCapacity()

	public void checkInitialization()
	{
		if(!initialized)
			lastIndex = 0; // need to make exception
	
	} // end checkINitialization



}
