
public class Node {

		
		public Object element;
		
		public Node leftChild;
		public Node rightChild;
		
		public Node (Object o) {
			this (o, null, null);
		}
		
		public Node (Object o, Node r, Node l) {
			element = o;
			rightChild = r;
			leftChild = l;
		}
		
		public String toString() {
			return element.toString();
		}
	
}
