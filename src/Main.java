
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Type your expression: ");
		String exp= input.nextLine();
		while(!exp.equals("end")) {
			
			ExpressionTree tree = new ExpressionTree();
			
			tree.convert(exp);
			
			System.out.print("Prefix: ");
			tree.prefix();
			
			System.out.print("Infix: ");
			tree.infix();
			
			System.out.print("Postfix: ");
			tree.postfix();
			
			System.out.println();
			System.out.println("Type another expression or end: ");
			exp= input.nextLine();
		}
		
	}

}
