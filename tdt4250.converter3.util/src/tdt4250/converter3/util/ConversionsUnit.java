package tdt4250.converter3.util;

import java.io.IOException;
import java.io.InputStream;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import tdt4250.converter3.api.UnitConversionResult;

public abstract class ConversionsUnit {

	private Conversions conversions;
	
	protected ConversionsUnit(Conversions conversions) {
		this.conversions = conversions;
	}

	protected ConversionsUnit(InputStream input) throws IOException {
		this.conversions = new ResourceConversions(input);
	}

	protected String getSuccessMessageStringFormat() {
		return "Yes, %s could be converter!";
	}

	protected String getFailureMessageStringFormat() {
		return "No, %s could not be converted!";
	}
	
	public UnitConversionResult convert(String toUnit, Double value) throws ScriptException {
		CharSequence expression = conversions.getConversion(toUnit);
		if (expression != null) {
			ScriptEngineManager mgr = new ScriptEngineManager();
		    ScriptEngine engine = mgr.getEngineByName("JavaScript");
		    engine.put("x", value);
		    String result = engine.eval(expression.toString()).toString();
			return new UnitConversionResult(true, result + " " + toUnit, null);
		} else {
			return new UnitConversionResult(false, "Conversion to" + toUnit + " wasn't found...", null);
		}
	}
}
