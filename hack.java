import java.util.*;
import java.io.*;

class hack {
	public static void main(String args[]) throws Exception{
		Scanner file = new Scanner(new File("out.txt"));
		while(file.hasNextInt()) {
			System.out.print(file.nextInt()+", ");
		}
	}
}
