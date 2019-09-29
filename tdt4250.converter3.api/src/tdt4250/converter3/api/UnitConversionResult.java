package tdt4250.converter3.api;

import java.net.URI;

public class UnitConversionResult {
	private final boolean success;
	private final String message;
	private final URI link;
	
	public UnitConversionResult(boolean success, String message, URI link) {
		super();
		this.success = success;
		this.message = message;
		this.link = link;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public String getMessage() {
		return message;
	}
	
	public URI getLink() {
		return link;
	}
}
