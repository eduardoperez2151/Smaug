package while_ut2.ast;

import java.util.*;

/** Nodo raíz de todos los programas While.
*/
public class Prog {
	public final Decl[] decls;
	public final Sequence main;

	public Prog(Decl[] decls, Sequence main) {
		this.decls = decls;
		this.main = main;
	}

	public String unparse() {
		StringBuilder buffer = new StringBuilder();
		for (Decl decl : decls) {
		buffer.append(decl.unparse()).append("\n\n");
		}
		return buffer.append(main.unparse()).toString();
	}

	@Override public String toString() {
		return "Prog("+ Arrays.toString(decls) +", "+ main +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + Arrays.hashCode(this.decls);
		result = result * 31 + (this.main == null ? 0 : this.main.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Prog other = (Prog)obj;
		return Arrays.equals(this.decls, other.decls)
			&& (this.main == null ? other.main == null : this.main.equals(other.main));
	}

	public static Prog generate(Random random, int min, int max) {
		Decl[] decls; Sequence main; 
		decls = new Decl[random.nextInt(Math.max(0, max)+1)];
		for (int i = 0; i < decls.length; i++) {
			decls[i] = Decl.generate(random, min-1, max-1);
		}
		main = Sequence.generate(random, min-1, max-1);
		return new Prog(decls, main);
	}
}
