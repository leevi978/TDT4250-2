package tdt4250.converter3.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.script.ScriptException;

public class UnitConversion {
	private static final String DEFAULT_MESSAGE = "Sorry, no conversion function found";
	private Collection<Unit> units = new ArrayList<Unit>();
	
	public void addUnit(Unit unit) {
		units.add(unit);
	}

	public void removeUnit(Unit unit) {
		units.remove(unit);
	}
	
	public UnitConversion(Unit... unitz) {
		units.addAll(Arrays.asList(unitz));
	}
	
	public UnitConversionResult convert(String fromUnit, String toUnit, Double value) throws ScriptException {
		StringBuilder messages = new StringBuilder();
		URI link = null;
		boolean success = false;
		
		Iterable<Unit> unitz = units.stream().filter(unit -> unit.getUnitName().equals(fromUnit)).collect(Collectors.toList());
		for (Unit unit : unitz) {
			UnitConversionResult result = unit.convert(toUnit, value);
			if (result.isSuccess()) {
				messages.append(result.getMessage());
				success = true;
				if (link == null) {
					link = result.getLink();
				}
			}
		}
		if (messages.length() == 0) {
			messages.append(DEFAULT_MESSAGE);
		}
		return new UnitConversionResult(success, messages.toString(), link);
	}
}
