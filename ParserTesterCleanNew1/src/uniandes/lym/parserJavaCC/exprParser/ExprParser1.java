package uniandes.lym.parserJavaCC.exprParser;
import java.util.*;

public class ExprParser1
{

Map<String, Integer> mem = new HashMap<String, Integer>(); //Memory to store variables.  



public final int ASG = 0;
public final int PUSH = 1;
public final int PLUS = 2;
public final int TIMES = 3;
public final int DIV = 4;
public final int SUB = 5;
public final int WR = 6;
public final int CHS = 7;
public final int GET = 8;

public final String []  names = {"ASG", "PUSH", "PLUS", "TIMES", "DIV", "SUB", "WRITE", "CHS", "GET"};


static MyStack myStack = new MyStack();

ArrayList <Instruction> code = new ArrayList <Instruction> () ;

public class Instruction {

int type;
Object arg = null;

public Instruction(int t) {
  type = t;
}

public Instruction(int t, Object a) {
  type = t;
  arg =  a;
  
}


public void execute() throws Error {
  switch (type) {
  	case PUSH:   myStack.push(arg) ; break;
  	case PLUS:   myStack.plus() ; break;
	case TIMES:  myStack.times() ; break;
	case DIV:   myStack.div() ; break;
	case SUB:   myStack.minus() ; break;
	case ASG:   mem.put((String) arg, myStack.pop()) ; break;
	case GET:  if (mem.get((String) arg)==null)throw new Error("Undefined variable: "+ arg);
               else myStack.push(mem.get((String) arg)) ; break;
	case CHS:   myStack.chs() ; break;
	case WR:    System.out.println("Output: "+ arg +"=" + mem.get(arg)); break;
	default:    System.out.println("Unknown instruction "+  type); break;
}
}

 
public String toString() {
  if (arg==null)
	return  "      "+names[type] + "\n";
  else
	return  "      "+ names[type] + "  "+  arg + "\n";
}
}



}

