package tdt4250.converter3.util.internal;

import java.util.Map.Entry;

import tdt4250.converter3.util.Conversions;
import tdt4250.converter3.util.MutableConversions;

public abstract class AbstractMutableConversions implements MutableConversions {
	
	public static void addAll(MutableConversions mutableConversions, Conversions conversions) {
		for (Entry<CharSequence, CharSequence> conversion : conversions) {
			mutableConversions.addConversion(conversion.getKey(), conversion.getValue());
		}
	}
}
