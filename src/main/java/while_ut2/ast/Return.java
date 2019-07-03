package while_ut2.ast;

import java.util.*;

/** Representación de la sentencia usada para definir el valor de retorno de una función.
*/
public class Return extends Stmt {
	public final Exp exp;

	public Return(Exp exp) {
		this.exp = exp;
	}

	@Override public String unparse() {
		return "return "+ exp.unparse() +";";
	}

	@Override public String toString() {
		return "Return("+ exp +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.exp == null ? 0 : this.exp.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Return other = (Return)obj;
		return (this.exp == null ? other.exp == null : this.exp.equals(other.exp));
	}

	public static Return generate(Random random, int min, int max) {
		Exp exp; 
		exp = Exp.generate(random, min-1, max-1);
		return new Return(exp);
	}
}
