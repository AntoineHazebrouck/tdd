package jez;

import java.util.HashMap;
import java.util.Map;

public class Rack {
	private final Map<Integer, SupplyStack> rack = new HashMap<>();

	public Rack(Integer size) {
		for (int count = 1; count <= size; count++) {
			rack.put(count, new SupplyStack());
		}
	}

	public Integer size() {
		return rack.size();
	}

	public SupplyStack get(Integer index) {
		return rack.get(index);
	}

}
