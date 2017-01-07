package uchidb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ActualContainer<T,S> implements Containers<T, S> {
	
	Map<S,T> map;
	@Override
	public Set<T> initSet(T[] tArray) {
		return new HashSet<T>(Arrays.asList(tArray));
	}

	@Override
	public List<T> initList(T[] tArray) {
		return new ArrayList<T>(Arrays.asList(tArray));
	}

	@Override
	public Map<S, T> initEmptyMap() {
		return new HashMap<S,T>();
	}

	@Override
	public void storeMap(Map<S, T> mapToStoreInClass) {
		this.map = mapToStoreInClass;
	}

	@Override
	public boolean addToMap(S key, T value, boolean overwriteExistingKey) {
		if(this.map.containsKey(key)) {
			if(!overwriteExistingKey) {
				return false;
			}	
		}
		this.map.put(key, value);
		return true;
	}

	@Override
	public T getValueFromMap(S key) {
		return this.map.get(key);
	}

	@Override
	public T getValueFromMap(S key, T defaultValue) {
		if(this.map.containsKey(key)) {
			return this.map.get(key);
		} else {
			return defaultValue;
		}
	}


}
