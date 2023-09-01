
public class Converter {
	
	private String infix;
	
	private char [] input;
	
	public Converter(String infix) {
		this.infix=infix;
	}
	
	public String getInfix() {
		return infix;
	}

	public void setInfix(String infix) {
		this.infix = infix;
	}

	public int precedence(char operator) {
		if (operator == '^') {
			return 3;
		}
		else if (operator == '*' || operator == '/') {
			return 2;
		}else if (operator == '+' || operator == '-') {
			return 1;
		}
		return 0;
		
	}
	
	public String toPostFix() {
		Stack<String> operators = new LinkedStack<>();
		
		String output = "";
		//tokenize
		input = new char[this.getInfix().length()];
		for (int i =0; i<input.length;i++) {
			input[i]= this.getInfix().charAt(i);
			//System.out.println(input[i]);
		}
		//List<String> parsed = new ArrayList<String>();
	    for (int i = 0; i < input.length; i++) {
	        char token = input[i];
	        //System.out.println(input[i]);
	        if (Character.isDigit(token)) {
	            //String number = input[i] + "";
	        	if (i==(input.length-1)) {
	        		output += input[i] + " ";
	        	}else {
	        		output += input[i] + "";
	        	}
	        	
	        	for (int j = i + 1; j < input.length; ++j) {
	                if (Character.isDigit(input[j])) {
	                    output += input[j];
	                    i = j;
	                } else {
	                	output += " ";
	                    break;
	                }
	        	}
	        	
	        } else if (token == '(') {
	        	operators.push(token + " ");
	        	
	        }else if ((operators.isEmpty() || operators.top().equals("( ")) && (token == '*' || token == '/' || token == '+' || token == '-' || token == '^')) {
	        	operators.push(token + " ");
	        	//System.out.println("sdfsd" + operators.top());
	         
	       
	        }else if (operators.isEmpty()==false && precedence(token) > precedence(operators.top().charAt(0))) {
	        	operators.push(token + " ");
	        	//System.out.println(operators.top());
	        }else if (token != ')'){
	        	while ((!operators.isEmpty()) && (precedence(token) <= precedence(operators.top().charAt(0)))) {
	        		String add = operators.pop();
	        		//System.out.println(add);
	        		if(add != "( ") {
	        			output += add;
	        		}
		        	
	        	}
	        	operators.push(token + " ");
	        	
	        	
	        }else if (token == ')') {
	        	while ((!operators.isEmpty())&& (!operators.top().equals("( "))) {
	        		//System.out.println("top"+operators.top());
	       
		        	output += operators.pop();
		        
	        			
	        		//System.out.println(output);
	        	}
	        	if (operators.top().equals("( ")) {
	        		operators.pop();
	        	}
	        }
	        		
	    }
	    while (!operators.isEmpty()) {
	    	//System.out.println("last"+operators.top());
	    	output += operators.pop();
	    }
	    //System.out.println(output);
	    
	    
	    
		
	    return output;
		
	}
	
	
}
