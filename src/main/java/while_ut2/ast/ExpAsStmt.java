package while_ut2.ast;

import java.util.*;

/** Representación de expresiones usadas como sentencias.
*/
public class ExpAsStmt extends Stmt {
	public final StmtExp exp;

	public ExpAsStmt(StmtExp exp) {
		this.exp = exp;
	}

	@Override public String unparse() {
		return exp.unparse() +";";
	}

	@Override public String toString() {
		return "ExpAsStmt("+ exp +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.exp == null ? 0 : this.exp.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		ExpAsStmt other = (ExpAsStmt)obj;
		return (this.exp == null ? other.exp == null : this.exp.equals(other.exp));
	}

	public static ExpAsStmt generate(Random random, int min, int max) {
		StmtExp exp; 
		exp = StmtExp.generate(random, min-1, max-1);
		return new ExpAsStmt(exp);
	}
}
