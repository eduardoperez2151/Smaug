package while_ut2.ast;

import java.util.*;

/** Representación de las comparaciones por diferente.
*/
public class CompareNotEqual extends Exp {
	public final Exp left;
	public final Exp right;

	public CompareNotEqual(Exp left, Exp right) {
		this.left = left;
		this.right = right;
	}

	@Override public int precedence() {
		return 3;
	}

	@Override public String unparse() {
		return left.unparse(precedence()) +" != "+ right.unparse(precedence());
	}

	@Override public String toString() {
		return "CompareNotEqual("+ left +", "+ right +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.left == null ? 0 : this.left.hashCode());
		result = result * 31 + (this.right == null ? 0 : this.right.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		CompareNotEqual other = (CompareNotEqual)obj;
		return (this.left == null ? other.left == null : this.left.equals(other.left))
			&& (this.right == null ? other.right == null : this.right.equals(other.right));
	}

	public static CompareNotEqual generate(Random random, int min, int max) {
		Exp left; Exp right; 
		left = Exp.generate(random, min-1, max-1);
		right = Exp.generate(random, min-1, max-1);
		return new CompareNotEqual(left, right);
	}
}
