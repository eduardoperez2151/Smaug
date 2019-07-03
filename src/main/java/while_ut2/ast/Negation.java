package while_ut2.ast;

import java.util.*;

/** Representación de las negaciones de expresiones booleanas.
*/
public class Negation extends Exp {
	public final Exp condition;

	public Negation(Exp condition) {
		this.condition = condition;
	}

	@Override public int precedence() {
		return 6;
	}

	@Override public String unparse() {
		return "!"+ condition.unparse(precedence());
	}

	@Override public String toString() {
		return "Negation("+ condition +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.condition == null ? 0 : this.condition.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Negation other = (Negation)obj;
		return (this.condition == null ? other.condition == null : this.condition.equals(other.condition));
	}

	public static Negation generate(Random random, int min, int max) {
		Exp condition; 
		condition = Exp.generate(random, min-1, max-1);
		return new Negation(condition);
	}
}
