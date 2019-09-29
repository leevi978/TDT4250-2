package tdt4250.converter3.gogo;

import org.apache.felix.service.command.Descriptor;
import org.osgi.service.component.annotations.Component;

import tdt4250.converter3.util.HashMapConversions;
import tdt4250.converter3.util.MutableConversions;

@Component(
		service = UnitCommands.class,
		property = {
			"osgi.command.scope=unit",
			"osgi.command.function=addConversion"
		}
	)
public class UnitCommands {
	
	@Descriptor("add new conversion to existing unit, providing an expression substituting x for the unit to convert from")
	public void addConversion(
			@Descriptor("the existing unit to convert from")
			String fromUnit,
			@Descriptor("the unit to convert to")
			String toUnit,
			@Descriptor("the conversion expression, substituting x for the unit to convert from")
			String expression
			) {
		MutableConversions conversion = new HashMapConversions();
		conversion.addConversion(toUnit, expression);
		
		boolean existed = Activator.getActivator().addUnit(new CommandUnit(fromUnit, conversion));
		System.out.println("\"" + fromUnit + "\" unit " + (existed ? "replaced" : "added"));
	}
	
}