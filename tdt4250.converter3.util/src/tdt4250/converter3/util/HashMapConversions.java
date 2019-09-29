package tdt4250.converter3.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import tdt4250.converter3.util.internal.AbstractMutableConversions;

public class HashMapConversions extends AbstractMutableConversions {
	
	private Map<CharSequence, CharSequence> conversionMap = new HashMap<CharSequence, CharSequence>();

	@Override
	public void addConversion(CharSequence toUnit, CharSequence expression) {
		conversionMap.put(toUnit, expression);
	}

	@Override
	public CharSequence getConversion(CharSequence toUnit) {
		return conversionMap.get(toUnit);
	}

	@Override
	public Iterator<Entry<CharSequence, CharSequence>> iterator() {
		return conversionMap.entrySet().iterator();
	}

}
