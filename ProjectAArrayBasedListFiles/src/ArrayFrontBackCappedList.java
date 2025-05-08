import java.util.Arrays;

public class ArrayFrontBackCappedList <T> implements FrontBackCappedList<T>  {
	private T[] list;
	private int numberOfElements;
	
	
public static final int DEFAULT_CAPACITY = 10;
	
	public ArrayFrontBackCappedList(int capacity) {
		 list = (T[]) new Object[capacity]; 
		    numberOfElements = 0;
	} 
	
	public ArrayFrontBackCappedList() {
		this(DEFAULT_CAPACITY);
	}
	 
	
	@Override
	public String toString() {
		
		String s =  "size="+ numberOfElements +"; " + "capacity=" + DEFAULT_CAPACITY +" [";
		for(int i=0; i< numberOfElements; i++) {
			s += list[i] + ", ";
		}
		if(!isEmpty()) {
			s = s.substring(0, s.length()-2);
		}
		s += "]" ;
		return s;
	}
	
	
	@Override
	public boolean addFront(T newEntry) {
		//Check if the array is full before adding.
		if (!isFull()) {
	      
		/*Access the array with a for-loop but within a reverse way to add the 
		 * elements within the front of the array.
		 */
	        for (int i = numberOfElements; i > 0; i--) {
	        
	        	//Shift the elements to the right.
	            list[i] = list[i - 1]; 
	            
	        }
	        
	       //Add the newEntry elements towards the index of the array.
	        list[0] = newEntry; 
	        
	        //Increase the number of elements.
	        numberOfElements++;
	        
	        //Lastly return true.
	        return true;
	        
	    }
		
		//Enter the else statement if it is full.
		else {
			
			//Return false given the array is full.
	        return false; 
	        
	    }
	}
	
	
	 
	@Override
	public boolean addBack(T newEntry) {
		
	//Check if the array is full.
		if(!isFull()) {
			
		/*Enter the newEntry elements within the numberOfElements of the array.
		 * 
		 *  Basically we're adding the elements within the other spaces of the array at the back for
		 *  when the front part of the array is being added on when putting the elements within the 
		 *  array.
		 */
			list[numberOfElements] = newEntry; 
			
			//Increase the numberOfElements of the array.
	        numberOfElements++; 
	        
	        //Return true when the elements of the array are added on a non-Full array.
	        return true;
			}
		
		//Enter within the else statement if the array is full.
		else {
		//Return false if the array is full.
			return false;
		}
		
	}
	
	@Override
	public T removeFront() {
		
	//Check if the array is empty.
		if(isEmpty()) {
		
		//Return null if it is.
			return null;
   
	    }
		
	/*Assign a new generic type T element called removedElement to take in
	 * the array's "list" index at 0.
	 */
		T removedElement = list [0];
		
	/*Iterate through the array using a for-loop in a reverse fashion to remove elements 
	 * from the front of the array.
	 */
		for(int i = 0; i < numberOfElements - 1; i++) {
			
	/*Access the elements of the array to remove and adding one 
	 * to access the further elements of the array from the front to remove.
	 */
			list[i] = list[i + 1];
		}
		
	//Make the elements at the front of the array equal to null.
		list[numberOfElements - 1] = null;
		
	//Decrease the numberOfElements.
		numberOfElements--;
		
	//Return the removedElement of the array.
		return removedElement;
		
	}
	
	@Override
	public T removeBack() {
	
		//Check if the array is empty.
		if(isEmpty()) {
			
		//If it is then return null.
			return null;
		} 
		

		/*Assign a new generic type T element called elementRemoved to take in
		 * the array's "list" within the back position to access the back elements.
		 */
			T elementRemoved = list[numberOfElements - 1];
			
		//Then make those elements from the back of the array to equal to null.
			list[numberOfElements - 1] = null;
			
		//Decrease the numberOfElements.
			numberOfElements--;
		
		//Lastly return the elementRemoved.
			return elementRemoved;
		
	
		
	}
	
	@Override
	public void clear() {
		
		//Iterate through the array with a for-loop.
			for(int i=0; i < numberOfElements; i++) {
						
		//Make the elements within the array equal to null.
			list[i] = null;
				}
					
		//Then make the numberOfElements equal to 0.
			numberOfElements = 0;
	}
	
	
	
	
	@Override
	public T getEntry(int givenPosition) {
		
	/*Check if the array is empty or if the givenPosition is less than 0 or if the givenPosition is greater than
	 * or equal to numberOfElements.
	 */
	if(isEmpty() || givenPosition < 0 || givenPosition >= numberOfElements) {
		
	//If it meets any of the criterias above then return null.
		return null;
	}
	
	//If it does not meet the criterias above then it enters the else statement.
	else {
	
	//Lastly we return the array's "list's" givenPosition.
			return list[givenPosition];
	}
	
	}
	
	@Override
	public int indexOf(T anEntry) {
		
	//Iterate through the array with a for-loop.
		for(int i=0; i < numberOfElements; i++) {
			
		//Check if the elements of the array equals to the anEntry element.
			if(list[i].equals(anEntry)) {
			
			//If it does then return the index of the element.
				return i;
			}
		}
	
		//If it does not or if the program does not find it then return -1.
		return -1;
	}
	
	@Override
	public int lastIndexOf(T anEntry) {
		
		//Iterate through the array with a for-loop within a reverse manner. 
		for(int i = numberOfElements -1; i >= 0; i--) {
			
		//Check if the elements of the array equals to the anEntry element.
			if(list[i].equals(anEntry)) {
				
		//Return the index of the element if it does.
				return i;
			}
			
		}
		
		//If it does not or if the program does not find it then return -1.
		return -1;
	}
	
	@Override
	public boolean contains(T anEntry) {
		
	/*Return the indexOf anEntry if it is greater than or equal to 0.
	 * 
	 * Meaning if the array contains an element from anEntry then return true or false if 
	 * it does or does not.
	 */
		return indexOf(anEntry) >= 0;
	}
	
	@Override
	public int size() {
		
	//Return the numberOfElements within the array.
		return numberOfElements;
	}
	
	@Override
	public boolean isEmpty() {
		
	/*Check if the numberOfElements equals to 0 and if it does then return true or
	 * false if not.
	 */
		return numberOfElements==0;
	}
	
	@Override
	public boolean isFull() {
		
	/*return true if numberOfElements is equal to the array's "list" length or return
	 * false if not.
	 */
		return numberOfElements == list.length;
	}
}
