package jez;

import java.util.List;
import java.util.Stack;

public class SupplyStack {
	private final Stack<Character> stack = new Stack<>();

	public SupplyStack() {
	}

	public SupplyStack(Character... items) {
		stack.addAll(List.of(items));
	}

	public void push(Character item) {
		stack.push(item);
	}

	public Character pop() {
		return stack.pop();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stack == null) ? 0 : stack.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SupplyStack other = (SupplyStack) obj;

		if (stack == null) {
			if (other.stack != null)
				return false;
		} else if (!stack.equals(other.stack))
			return false;

		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Character character : stack) {
			builder.append(character + ", ");
		}
		return "SupplyStack [stack=" + builder.toString() + "]";
	}

}
