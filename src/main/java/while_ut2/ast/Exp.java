package while_ut2.ast;

import java.util.*;

/** Categoría sintáctica de las expresiones de While, las 
	construcciones del lenguaje que evalúan a un valor (numérico o booleano).
*/
public abstract class Exp {

	public abstract int precedence();

	public abstract String unparse();

	public String unparse(int scope) {
		return precedence() < scope ? "("+ unparse() +")" : unparse();
	}

	@Override public abstract String toString();

	@Override public abstract int hashCode();

	@Override public abstract boolean equals(Object obj);

	public static Exp generate(Random random, int min, int max) {
		final int TERMINAL_COUNT = 4;
		final int NONTERMINAL_COUNT = 14;
		int i = min > 0 ? random.nextInt(NONTERMINAL_COUNT) + TERMINAL_COUNT
			: random.nextInt(max > 0 ? NONTERMINAL_COUNT + TERMINAL_COUNT: TERMINAL_COUNT);
		switch (i) {
		//Terminals
			case 0: return Numeral.generate(random, min-1, max-1);
			case 1: return Variable.generate(random, min-1, max-1);
			case 2: return TruthValue.generate(random, min-1, max-1);
			case 3: return Time.generate(random, min-1, max-1);
		//Non terminals
			case 4: return Negation.generate(random, min-1, max-1);
			case 5: return Multiplication.generate(random, min-1, max-1);
			case 6: return Division.generate(random, min-1, max-1);
			case 7: return Addition.generate(random, min-1, max-1);
			case 8: return Subtraction.generate(random, min-1, max-1);
			case 9: return CompareEqual.generate(random, min-1, max-1);
			case 10: return CompareNotEqual.generate(random, min-1, max-1);
			case 11: return CompareLessOrEqual.generate(random, min-1, max-1);
			case 12: return CompareLess.generate(random, min-1, max-1);
			case 13: return CompareGreaterOrEqual.generate(random, min-1, max-1);
			case 14: return CompareGreater.generate(random, min-1, max-1);
			case 15: return Conjunction.generate(random, min-1, max-1);
			case 16: return Disjunction.generate(random, min-1, max-1);
			case 17: return StmtExp.generate(random, min, max);
			default: throw new Error("Unexpected error at Exp.generate()!");
		}
	}
}
