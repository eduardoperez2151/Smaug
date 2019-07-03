package while_ut2.ast;

import java.util.*;

/** Subcategoría de las expresiones que pueden ocupar el lugar de sentencias.
*/
public abstract class StmtExp extends Exp {

	@Override public abstract String toString();

	@Override public abstract int hashCode();

	@Override public abstract boolean equals(Object obj);

	public static StmtExp generate(Random random, int min, int max) {
		final int TERMINAL_COUNT = 0;
		final int NONTERMINAL_COUNT = 1;
		int i = random.nextInt(TERMINAL_COUNT + NONTERMINAL_COUNT);
		switch (i) {
		//Terminals
		//Non terminals
			case 0: return FunctionCall.generate(random, min-1, max-1);
			default: throw new Error("Unexpected error at StmtExp.generate()!");
		}
	}
}
