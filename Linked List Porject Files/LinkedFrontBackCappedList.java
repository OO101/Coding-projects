public class LinkedFrontBackCappedList<T> implements FrontBackCappedList<T>
 {

	private Node head, tail;
	private int size;
	private int capacity;
   // YOUR CLASS CODE GOES HERE!

	public class Node {
		public T data; 
		public Node next; 

		private Node(T dataValue) {
			data = dataValue;
			next = null;
		}

		private Node(T dataValue, Node nextNode) {
			data = dataValue;
			next = nextNode;
		}

		private T getData() {
			return data;
		}

		private void setData(T newData) {
			data = newData;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} 
	}

	public LinkedFrontBackCappedList(int capacity) {
		head = null;
		tail = null;
		size = 0;
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		String s ="[";
		Node currentNode = head;
		while(currentNode!=null) {
			s += currentNode.data + ", ";
			currentNode = currentNode.next;
		}
		if(!isEmpty()) {
			s = s.substring(0, s.length()-2);
			
			String t = "]"+" size="+ size +" " + "capacity=" + this.capacity + "   "+"  head=" + head.data +" tail="+ tail.data;
			s += t;
			return s;
		}
		
		s += "] "+" size="+ size +" " + "capacity=" + this.capacity;
		return s;
	}

	@Override
	public boolean addFront(T newEntry) {
	
		//Check if the Linked list is Empty.
		if(isEmpty()) {
			
	//If not then add the newEntry within the head Node.
		head = new Node (newEntry);
		
	//Assign tail to head to get and point the at the same element head Node has.
		tail = head;
		
	//Increase the size.
		size++;
	
	//Return true.
		return true;
			
		}
	
	//Enter else if statement if does not meet isEmpty() conditions.
		else if (!isFull()){
			
		//Assign the node current to take in the newEntry.
			Node current = new Node(newEntry);
			
		/*Assign current.next to take in the head Node in order to shift the elements to
		 * the left to add to front.
		 */
				current.next = head;
				
		// Connect head to current.
				head = current;
		//Increase size.
				size++;
				
		//Return true.
				return true;
			}
		
	//If does not meet previous conditions then return false.
		return false;
				
	}

	@Override
	public boolean addBack(T newEntry) {
		
	//Add boolean flag and assign to true to not stop program early if true.
	boolean flag = true;
	
	//Assign current to newEntry.
	Node current = new Node(newEntry);
	
	//Check if the Linked List is empty.
		if(isEmpty()) {
	
	//If not then assign both head and tail to current to take in and point to newEntry.
			head = current;
			tail = current;
			
	//Increase size.
			size++;
			
	//return true.
			return flag;
		}
	
	//If does not meet isEmpty() conditions then enter this if statement.
		if(!isFull()) {
	
	//Assign tail.next to add in newEntry.
		tail.next = current;
		
	/*Assign the tail to current to connect to the new node at the back 
	 * of the Linked List.
	 */
		tail = current;
		
	//Increase size.
		size++;
		
	//Return true.
		return flag;
		}
	
	//If does not meet previous conditions then return flag and assign to false.
		return flag == false;
		}

	@Override
	public T removeFront() {
		
	//Check if the Linked List is empty.
		if(isEmpty()) {
	
		//Return null if it is.
		return null;
		
		}
		
	//Enter else statement if does not meet previous conditions.
		else {
	
	//Assign a generic T type variable of nodeData to get the head Node's data.
		T nodeData = head.data;
		
	/*Then assign head to head.next to remove from the front and shift the Linked List
	 * to the right.
	 */
		head = head.next;
		
	//Decrease size.
		size--;
		
	//Return the head's Node data that was removed.
		return nodeData;
		}
	}

	@Override
	public T removeBack() {
		
	//Check if the Linked List is empty.
	if(isEmpty()) {
	//Return null if it is.	
		return null;
	}
	
	//Enter in else if statement if the Linked List has one single element within it.
	else if(head.next == null) {
		
	//Assign currentNode to head.
		Node currentNode = head;
		
	/*Assign generic T type variable nodeData to currnetNode.data
	 * to take in the data before deletion.
	 */
		T nodeData = currentNode.data;
		
	//Assign head to null to delete the element from the Linked List.
		head = null;
		
	//Decrease size.
		size--;
		
	//Return the element that was deleted/removed from the Linked List.
		return nodeData;
	}
	
	//Enter in else statement if does not meet previous two conditions.
	else{
		
		//Assign Node secondLast to head & Node temp to null.
		Node secondLast = head;
		Node temp = null;
		
		/*Iterate while the two elements ahead of secondLast does not equal
		 * to null.
		 */
		while(secondLast.next.next != null) {
			
			//Assign Node secondLast to the second to last Node of the Linked List.
			secondLast = secondLast.next;
			
		}
		
		//Decrease size.
		size--;
		
		//Assign Node temp to the secondLast.next to obtain data.
		temp = secondLast.next;
		
		//Assign secondLast.next to null to delete/remove element from Linked List.
		secondLast.next = null;
		
		//Assign tail to secondLast to keep check on where the end of the Linked List is.
		tail = secondLast;
		
		/*Assign generic T type nodeData to temp.getData() to obtain the removed element data from
		 * the Linked List.
		 */
		T nodeData = temp.getData();
			
		//Lastly return the element that was deleted/removed from the Linked List.
		return nodeData;
	}
	
	
	}
	
	@Override
	public void clear() {
		
		//Iterate while head does not equal to null.
		while(head != null) {
			
		//Assign head.data to null.
			head.data = null;
			
		/*Assign head to next to keep iterating/connecting to the next
		 * node to delete.
		 */
			head = head.next;
			
		}
		
		//Lastly assign size to 0.
		size = 0;
	}

	@Override
	public T getEntry(int givenPosition) {
		
		/*Assign current to head, assign index to 0, and 
		 * assign a generic T type varible of returnValue to null.
		 */
		Node current = head;
		int index = 0;
		T returnValue = null;
		
	//Iterate while current.next does not equal to null.
	while(current != null) {
		
	
	//Check within the while-loop if index is equal to the givenPosition.
		if(index ==givenPosition) {
			
	/*Assign returnValue to current.getData() to retreive the data from
	 * the Linked List.
	 */
		 returnValue = current.getData();
		 
	//Return returnValue element's if the givenPosition is found.
		 return returnValue;
		}
		
	//Enter else statement if does not meet previous inner condition.
		else {
		
	//Assign current to current.next to keep iterating through the Linked List.
		current = current.next;
		
	//Increase index.
		index++;
		}
	}
	
	//Return null if specific position is not within the Linked List.
	return null;
	}

	@Override
	public int indexOf(T anEntry) {
		
		/*Assign index to 0 and
		 * Node current to head.
		 */
		int index = 0;
		Node current = head;
		
		//Iterate while current does not equal to null.
			while(current != null) {
				
		//Check if the current data is logically equivalent to anEntry.
			if(current.data.equals(anEntry)) {
		//Return index if it is.	
				return index;
			}
		/*If does not meet previous inner condition increment index
		 * and continue iterating through the Linked List.
		 */
			index++;
			current = current.next;
		}
			
		//Return -1 if does not meet previous condition.
		return -1;
	}

	@Override
	public int lastIndexOf(T anEntry) {
		
		/*Assign Node current to head and
		 * target to -1.
		 */
		Node current = head;
		int target = -1;
		
		//Iterate through the Linked List 
		for(int i = 0; current != null; i++) {
			
		//Check if the current data is logically equivalent to anEntry.
			if(current.data.equals(anEntry)) {
		
		//If it is then assign target to i.
				target = i;
				
			}
			
		//Assign current to current.next to iterate through the Linked List.
			current = current.next;
			
		}
		
	//Return target if it meets previous condition or not.
		return target;
	}

	@Override
	public boolean contains(T anEntry) {
		
	//Assign Node current to head.
		Node current = head;
		
		//Iterate while current does not equal null.
		while(current!=null) {
			
		//Check if the current data is logically equivalent to anEntry.
		if(current.data.equals(anEntry)) {
				
		//Return true if it does.
			return true;
		} 
		
		//Enter else statement if does not meet previous condition.
		else {
			
		//Iterate through the Linked List.
				current = current.next;
			}
		}
		
	//Return false if does not meet previous conditions.
		return false;	
	}

	@Override
	public int size() {
		
	//Return size.
		return size;
	}

	@Override
	public boolean isEmpty() {
		
	//Return true if size equals to 0 & if head equals to null.
		return size==0 && head==null;
	}

	@Override
	public boolean isFull() {
		
	//Return if size equals to this.capacity.
		return size == this.capacity;
	}

	public int compareTo(LinkedFrontBackCappedList<T> listB) {
		return capacity;

	}
}
