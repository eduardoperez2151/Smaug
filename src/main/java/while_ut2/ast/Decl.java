package while_ut2.ast;

import java.util.*;

/** Categoría sintáctica de las declaraciones de While, las construcciones del 
	definen la organización del código del programa.
*/
public abstract class Decl {

	public abstract String unparse();

	@Override public abstract String toString();

	@Override public abstract int hashCode();

	@Override public abstract boolean equals(Object obj);

	public static Decl generate(Random random, int min, int max) {
		final int TERMINAL_COUNT = 0;
		final int NONTERMINAL_COUNT = 1;
		int i = random.nextInt(TERMINAL_COUNT + NONTERMINAL_COUNT);
		switch (i) {
		//Terminals
		//Non terminals
			case 0: return FunctionDefinition.generate(random, min-1, max-1);
			default: throw new Error("Unexpected error at Decl.generate()!");
		}
	}
}
