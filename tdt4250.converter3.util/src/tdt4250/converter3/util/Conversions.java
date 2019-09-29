package tdt4250.converter3.util;

import java.util.Map.Entry;

public interface Conversions extends Iterable<Entry<CharSequence, CharSequence>> {
	public CharSequence getConversion(CharSequence toUnit);
}
