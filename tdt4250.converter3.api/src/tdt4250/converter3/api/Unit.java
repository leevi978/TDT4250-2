package tdt4250.converter3.api;

import javax.script.ScriptException;

public interface Unit {
	String getUnitName();
	UnitConversionResult convert(String toUnit, Double value) throws ScriptException;
}
