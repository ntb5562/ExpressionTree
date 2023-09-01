
//used textbook for prefix, infix, and postfix methods
public class ExpressionTree {
	
	private Node root;
	
	public ExpressionTree() {
		root = null;
	}
	public Node convert(String ex) {
		
		Converter convert = new Converter(ex);
		//convert ex to postfix
		String post = convert.toPostFix();
		Stack<Node> stac = new LinkedStack<>();
		//split postfix to an array of operands and operators
		String [] token = post.split(" ");;
		for(int i = 0; i < token.length; i++) {
			try {
				int number = Integer.parseInt(token[i]);
				//if it's a number make into a leaf node
				Node num = new Node(number);
				stac.push(num);
			}catch (NumberFormatException nfe) {
				//if operator make into a parent node w/ right and left children
				root = new Node(token[i], stac.pop(),stac.pop());
				stac.push(root);
			}
		}
		//finalized tree remaining
		root = stac.pop();
		return root;
		
	}
	//preorder tranversal
	public void prefix() {
		prefix(root);
		System.out.println();
	}
	private void prefix(Node tree) {
		if (tree == null)
			return;
		System.out.print(tree.toString());
		prefix(tree.leftChild);
		prefix(tree.rightChild);
	}
	
	//inorder transversal
	public void infix() {
		infix(root);
		System.out.println();
	}
	private void infix(Node tree) {
		if(tree.leftChild != null) {
			System.out.print("(");
			infix(tree.leftChild);
		}
		System.out.print(tree.toString());
		if(tree.rightChild != null) {
			infix(tree.rightChild);
			System.out.print(")");
		}
		
	}
	
	//postorder transversal
	public void postfix() {
		postfix(root);
		System.out.println();
	}
	private void postfix(Node tree) {
		if (tree == null)
			return;
		postfix(tree.leftChild);
		postfix(tree.rightChild);
		System.out.print(tree.toString());
		
	}
	

}
