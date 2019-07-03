package while_ut2.ast;

import java.util.*;

/** Representación de las llamadas a funciones.
*/
public class FunctionCall extends StmtExp {
	public final String id;
	public final Exp[] expressions;

	public FunctionCall(String id, Exp[] expressions) {
		this.id = id;
		this.expressions = expressions;
	}

	@Override public int precedence() {
		return 10;
	}

	@Override public String unparse() {
		StringBuilder buffer = new StringBuilder(id +"(");
		for (int i = 0; i < expressions.length; ++i) {
		buffer.append(i > 0 ? ", " : "")
		.append(expressions[i].unparse());
		}
		return buffer.append(")").toString();
	}

	@Override public String toString() {
		return "FunctionCall("+ id +", "+ Arrays.toString(expressions) +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.id == null ? 0 : this.id.hashCode());
		result = result * 31 + Arrays.hashCode(this.expressions);
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		FunctionCall other = (FunctionCall)obj;
		return (this.id == null ? other.id == null : this.id.equals(other.id))
			&& Arrays.equals(this.expressions, other.expressions);
	}

	public static FunctionCall generate(Random random, int min, int max) {
		String id; Exp[] expressions; 
		id = ""+"abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(26));
		expressions = new Exp[random.nextInt(Math.max(0, max)+1)];
		for (int i = 0; i < expressions.length; i++) {
			expressions[i] = Exp.generate(random, min-1, max-1);
		}
		return new FunctionCall(id, expressions);
	}
}
