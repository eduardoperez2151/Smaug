package while_ut2.ast;

import java.util.*;

/** Representación de las declaraciones de funciones.
*/
public class FunctionDefinition extends Decl {
	public final String id;
	public final String[] args;
	public final Sequence body;

	public FunctionDefinition(String id, String[] args, Sequence body) {
		this.id = id;
		this.args = args;
		this.body = body;
	}

	@Override public String unparse() {
		StringBuilder buffer = new StringBuilder("function "+ id +"(");
		for (int i = 0; i < args.length; ++i) {
		buffer.append(i > 0 ? ", " : "").append(args[i]);
		}
		return buffer.append(") ").append(body.unparse()).toString();
	}

	@Override public String toString() {
		return "FunctionDefinition("+ id +", "+ Arrays.toString(args) +", "+ body +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.id == null ? 0 : this.id.hashCode());
		result = result * 31 + Arrays.hashCode(this.args);
		result = result * 31 + (this.body == null ? 0 : this.body.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		FunctionDefinition other = (FunctionDefinition)obj;
		return (this.id == null ? other.id == null : this.id.equals(other.id))
			&& Arrays.equals(this.args, other.args)
			&& (this.body == null ? other.body == null : this.body.equals(other.body));
	}

	public static FunctionDefinition generate(Random random, int min, int max) {
		String id; String[] args; Sequence body; 
		id = ""+"abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(26));
		args = new String[random.nextInt(Math.max(0, max)+1)];
		for (int i = 0; i < args.length; i++) {
			args[i] = ""+"abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(26));
		}
		body = Sequence.generate(random, min-1, max-1);
		return new FunctionDefinition(id, args, body);
	}
}
