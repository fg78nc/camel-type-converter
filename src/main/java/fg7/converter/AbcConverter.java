package fg7.converter;

import fg7.domain.Abc;
import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.TypeConverter;
import org.apache.camel.TypeConverters;

public class AbcConverter implements TypeConverters {

	@Converter
	public Abc toAbc(byte[] data, Exchange exchange){
		TypeConverter converter = exchange.getContext().getTypeConverter();

		String s = converter.convertTo(String.class, data);

		if (s == null || s.length() < 10){
			throw new IllegalArgumentException("data is invalid");
		}

		final String[] splitData = s.split(" ");
		return new Abc(splitData[0], splitData[1], Integer.parseInt(splitData[2]));
	}


}
