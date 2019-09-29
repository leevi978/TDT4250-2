package tdt4250.converter3.gogo;

import tdt4250.converter3.api.Unit;
import tdt4250.converter3.util.Conversions;
import tdt4250.converter3.util.ConversionsUnit;

public class CommandUnit extends ConversionsUnit implements Unit {

	private final String fromUnit;
	
	public CommandUnit(String fromUnit, Conversions conversions) {
		super(conversions);
		this.fromUnit = fromUnit;
	}

	@Override
	public String getUnitName() {
		return fromUnit;
	}

}
