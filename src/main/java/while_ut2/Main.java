package while_ut2;

import java.util.*;
import while_ut2.ast.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Random random = new Random(123456L);
			for (int i = 0; i < 30; ++i) {
				Prog randomProgram = Prog.generate(random, i % 5, 1 + i % 5 + i % 8);
				System.out.println("____________________________________________________________________________________________");
				System.out.println(randomProgram +"\n");
				System.out.println("\t"+ randomProgram.unparse().replace("\n", "\n\t") +"\n");
			}
	}
}