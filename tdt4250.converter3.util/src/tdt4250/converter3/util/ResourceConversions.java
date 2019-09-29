package tdt4250.converter3.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResourceConversions extends HashMapConversions {
	
	private void read(InputStream input) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(input, "utf-8"));
		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(";");
			addConversion(parts[0].trim(), parts[1].trim());
		}
	}

	protected ResourceConversions(InputStream input) {
		try {
			read(input);
		} catch (IOException e) {
		}
	}
	
	public static ResourceConversions create(String fromUnit) {
		return new ResourceConversions(ResourceConversions.class.getResourceAsStream(String.format("%s.txt", fromUnit)));
	}
}
