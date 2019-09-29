package tdt4250.converter3.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.script.ScriptException;
import javax.servlet.*;
import javax.servlet.http.*;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardServletPattern;

import tdt4250.converter3.api.Unit;
import tdt4250.converter3.api.UnitConversion;
import tdt4250.converter3.api.UnitConversionResult;

/**
 *@startuml
 *ConverterServlet -right-> "*" Unit: "units"
 *Unit <|.down. FahrenheitUnit
 *@enduml
 */

/**
 * @startuml
 * circle Unit
 * component ConverterServlet
 * ConverterServlet -right-( "*" Unit: "units"
 * component FahrenheitUnit
 * Unit -- FahrenheitUnit
 *@enduml
 */

@Component
@HttpWhiteboardServletPattern("/converter/*")
public class ConverterServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;
	
	private UnitConversion unitConversion = new UnitConversion();
	
	@Reference(
			cardinality = ReferenceCardinality.MULTIPLE,
			policy = ReferencePolicy.DYNAMIC,
			bind = "addUnit",
			unbind = "removeUnit"
	)
	public void addUnit(Unit unit) {
		unitConversion.addUnit(unit);
	}
	public void removeUnit(Unit unit) {
		unitConversion.removeUnit(unit);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		Double value = Double.parseDouble(request.getParameter("value"));
		UnitConversionResult result = null;
		try {
			result = unitConversion.convert(from, to, value);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/plain");
		PrintWriter writer = response.getWriter();
		if (result.getLink() != null) {
			writer.print(result.getLink());
		}
		writer.print(result.getMessage());
	}

}