package tdt4250.converter3.fahrenheit;

import tdt4250.converter3.api.Unit;
import tdt4250.converter3.api.UnitConversionResult;
import tdt4250.converter3.util.ResourceConversions;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.osgi.service.component.annotations.Component;

@Component
public class FahrenheitUnit implements Unit {
	
	private ResourceConversions conversions = ResourceConversions.create("Fahrenheit");

	@Override
	public String getUnitName() {
		return "Fahrenheit";
	}

	@Override
	public UnitConversionResult convert(String toUnit, Double value) throws ScriptException {
		CharSequence expression = conversions.getConversion(toUnit);
		if (expression != null) {
			// TODO: Move this to another class
			ScriptEngineManager mgr = new ScriptEngineManager();
		    ScriptEngine engine = mgr.getEngineByName("JavaScript");
		    engine.put("x", value);
		    String result = engine.eval(expression.toString()).toString();
			return new UnitConversionResult(true, value.toString() + " " + getUnitName() + " is equal to " + result + " " + toUnit, null);
		} else {
			return new UnitConversionResult(false, "Conversion from " + getUnitName() + " to" + toUnit + " wasn't found...", null);
		}
	}

}
