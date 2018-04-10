import java.util.ArrayList;

/**
 * Implements a priority queue of Integer objects as an ArrayList<Integer>
 * sorted in descending order
 * 
 * @author Sean Gibbons
 *
 */
public class PriorityQueue {
	private ArrayList<Integer> queue;

	public PriorityQueue() {
		queue = new ArrayList<Integer>();
	}

	/**
	 * Adds an element to the priority queue
	 * 
	 * @param i
	 */
	public void add(Integer i) {
		queue.add(searchPos(i), i);
	}

	/**
	 * Returns true if this list contains no elements
	 * 
	 * @return true if this list contains no elements
	 */
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices).
	 * 
	 * @param i
	 *            the index of the element to be removed
	 * @return the element that was removed from the list
	 */
	public int remove(int i) {
		return queue.remove(i);
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param i
	 *            index of the element to return
	 * @return the element at the specified position in this list
	 */
	public int get(int i) {
		return queue.get(i);
	}

	/**
	 * A private helper method that takes an int and returns the correct spot in the
	 * queue
	 * 
	 * @param i
	 *            the int which will be searched for
	 * @return the position where the int belongs
	 */
	private int searchPos(int i) {
		if (queue.size() == 0)
			return 0;
		int r = queue.size() - 1;
		int l = 0;
		int mid;
		while (r <= l) {
			mid = (l + r) / 2;
			if (queue.get(mid) < i)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return l;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i : queue) {
			s += i + " ";
		}
		return s;
	}

	public static void main(String[] args) {
		PriorityQueue q = new PriorityQueue();
		int[] toAdd = { 1, 4, 7, 9 };
		for (int i : toAdd) {
			q.add(i);
		}

		System.out.println(q);

	}
}
