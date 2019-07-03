package while_ut2.ast;

import java.util.*;

/** Categoría sintáctica de las sentencias (statements) de While, las 
	construcciones del lenguaje que modifican (potencialmente) los 
	valores de las variables en el estado del programa.
*/
public abstract class Stmt {

	public abstract String unparse();

	@Override public abstract String toString();

	@Override public abstract int hashCode();

	@Override public abstract boolean equals(Object obj);

	public static Stmt generate(Random random, int min, int max) {
		final int TERMINAL_COUNT = 0;
		final int NONTERMINAL_COUNT = 6;
		int i = random.nextInt(TERMINAL_COUNT + NONTERMINAL_COUNT);
		switch (i) {
		//Terminals
		//Non terminals
			case 0: return Assignment.generate(random, min-1, max-1);
			case 1: return ExpAsStmt.generate(random, min-1, max-1);
			case 2: return Return.generate(random, min-1, max-1);
			case 3: return Sequence.generate(random, min-1, max-1);
			case 4: return IfThenElse.generate(random, min-1, max-1);
			case 5: return WhileDo.generate(random, min-1, max-1);
			default: throw new Error("Unexpected error at Stmt.generate()!");
		}
	}
}
