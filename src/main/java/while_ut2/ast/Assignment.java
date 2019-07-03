package while_ut2.ast;

import java.util.*;

/** Representación de las asignaciones de valores a variables.
*/
public class Assignment extends Stmt {
	public final String id;
	public final Exp exp;

	public Assignment(String id, Exp exp) {
		this.id = id;
		this.exp = exp;
	}

	@Override public String unparse() {
		return id +" = "+ exp.unparse() +";";
	}

	@Override public String toString() {
		return "Assignment("+ id +", "+ exp +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.id == null ? 0 : this.id.hashCode());
		result = result * 31 + (this.exp == null ? 0 : this.exp.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Assignment other = (Assignment)obj;
		return (this.id == null ? other.id == null : this.id.equals(other.id))
			&& (this.exp == null ? other.exp == null : this.exp.equals(other.exp));
	}

	public static Assignment generate(Random random, int min, int max) {
		String id; Exp exp; 
		id = ""+"abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(26));
		exp = Exp.generate(random, min-1, max-1);
		return new Assignment(id, exp);
	}
}
