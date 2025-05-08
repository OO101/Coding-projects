import java.util.ArrayList;
import java.util.List;
public class ListFrontBackCappedList<T> implements FrontBackCappedList<T> {
	private List<T> list; // initialize to type ArrayList<T> in the ListFrontBackCappedList constructor
	
	private int numberOfElements;
	private int capacity;
	
	public ListFrontBackCappedList(int capacity) {
		   list = new ArrayList<>(capacity);
		   numberOfElements = 0;
		   this.capacity = capacity;
	}
	
	
	@Override
	public String toString() {
		
		String s = "size="+ numberOfElements +";" + "capacity=" + capacity + ";" + "[";
		for(int i=0; i< numberOfElements; i++) {
			s += list.get(i) + ", ";
		}
		if(!isEmpty()) {
			s = s.substring(0, s.length()-2);
		}
		s += "]";
		return s;
	}
	
	@Override
	public boolean addFront(T newEntry) {
		
	//Check if the ArrayList is empty.
		if(isEmpty()) {
	
		//Add the newEntry elements within the index of 0.
			list.add(0,newEntry);
		
		//Increase the numberOfElements.
			numberOfElements++;
			
		//Return true when meets previous condition.
			return true;
			
		}
	/*Enter the else if statement if it is not empty.
	 * Then check if the ArrayList is full.
	 */
		else if (!isFull()) {
		
	//Then if it isn't full then add the newEntry elements at index 0.
		list.add(0,newEntry);

		//Increase the numberOfElements.
		numberOfElements++;
		
	//Return true when meets previous condition.
		return true;
				 
				
	    }

		//Return false if the ArrayList is full.
	        return false; 
	
	}



	@Override
	public boolean addBack(T newEntry) {
	
		//Check if the ArrayList is empty.
		if(isEmpty()) {
			
		//Add the newEntry elements at index 0.
			list.add(0, newEntry);
		
		//Increase the numberOfElements.
			numberOfElements++;
			
		//Return true if meets the previous condition.
			return true;
		
		}
	
	/*Enter the else if statement if it is not empty
	 * and check if the array is full.
	 */
		else if(!isFull()) {
			
		//add the newEntry elements towards the back of the ArrayList.
			list.add(newEntry);
		//Increase the numberOfElements.
			numberOfElements++;
			 
		//Return true when meets the previous condition.
			return true;
			
		}
		
		//Return false if the ArrayList is full.
			return false;
		
	}



	@Override
	public int indexOf(T anEntry) {
		
	//Iterate through the ArrayList with a for-loop.
		for(int i = 0; i < numberOfElements; i++) {
			
		//CHeck if the index's element of ArrayList's "list" is equal to the anEntry element.
			if(list.get(i).equals(anEntry)) {
				
			//Return the index if it does equal to the anEntry element.
				return i;
			}
		}
		
	//Return -1 if index's element of ArrayList's "list"  does not equal to the anEntry element.
		return -1;
	}



	@Override
	public int lastIndexOf(T anEntry) {
		
	//Iterate through the ArrayList with a for-loop in a reverse manner.
		for(int i = size() -1; i >= 0; i--) {
			
	//Check if the ArrayList's "list" index element equals to the anEntry element.
			if(list.get(i).equals(anEntry)) {
				
		//Get the index of that specific element from the ArrayList.
				list.get(i);
				
		//Return the specific index of that element if it does equal to the anEntry element. 
				return i;
			}
			
		}
		//Return -1 if index's element of ArrayList's "list"  does not equal to the anEntry element.
		return -1;
	}



	@Override
	public boolean contains(T anEntry) {
		
	/*Return true if the ArrayList contains the anEntry element using indexOf within the range of 0
	 * and or return false if it does not contain that specific element.
	 */
		return indexOf(anEntry) >= 0;
	}



	@Override
	public T removeFront() {
		
	//Check if the ArrayList is empty.
		if (isEmpty()) {
			
		//Return null if it is.
		      return null;
		}
		
		else {
			
		/*Initialize a generic type T element called "removedElement"
		 * and assign it towards the ArrayList's "list" index 0.
		 */
		T removedElement = list.get(0);
	
		//Then remove that specific element.
			list.remove(removedElement);

			//Decrease the numberOfElements.
			numberOfElements--;
			
		//Lastly return the removedElement.
			return removedElement;
			
		}
	}


	@Override
	public T removeBack() {
		
	//Check if the ArrayList is empty.
		if(isEmpty()) {
			
		//Return null if it is.
			return null;
		} 
		 
		else {
		
			/*Initialize a generic type T element called "elementRemoved"
			 * and assign it towards the ArrayList's "list" reversed index to focus
			 * on the back of the ArrayList.
			 */
			T elementRemoved = list.get(size() - 1);
			
		//Decrease the numberOfElements.
			numberOfElements--;
			
		//Return the elementRemoved.
			return elementRemoved;
			
		}
		
		
	}



	@Override
	public void clear() {
		
		//Iterate through the ArrayList with a for-loop.
		
		for(int i=0; i < numberOfElements; i++) {
			
			/*Initialize a generic type T element called "elementCleared"
			  and assign it towards the ArrayList's "list" index i.
			 */
		T elementCleared = list.get(i);
		
	//Assign the elementCleared to null.
		elementCleared = null;
		}
		
	//Assign/Set the numberOfElements to 0.
		numberOfElements = 0;
	
	
	}


	@Override
	public T getEntry(int givenPosition) {
		
	/*Check if the ArrayList is empty or the givenPosition is less than 0 or the givenPositon is
	 * greater than or equal to numberOfElements.
	 */
		if(isEmpty() || givenPosition < 0 || givenPosition >= numberOfElements) {
			
		//Return null if it meets either of those previous conditions.
			return null;
		}
		
		/*Return the ArrayList's "list" givenPosition if it does not meet those previous 
		 * conditions.
		 */
				return list.get(givenPosition);
		
	}


	@Override
	public int size() {
		
	//Return the numberOfElements.
		return numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		
	/*Return true if the numberOfElements if it equals to 0 or return false if
	 * numberOfElements does not equal to 0.
	 */
		return numberOfElements==0;
	}

	@Override
	public boolean isFull() {
	/* Return true if the numberOfelements equals to this.capacity or return 
	 * false if the numberOfElements does not equal to this.capacity.
	 */
	return numberOfElements == this.capacity;
	
	}
	
	
}
