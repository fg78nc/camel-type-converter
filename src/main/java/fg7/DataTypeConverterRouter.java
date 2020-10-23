package fg7;

import fg7.domain.Abc;
import org.apache.camel.builder.RouteBuilder;

import org.springframework.stereotype.Component;

@Component
public class DataTypeConverterRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:convert1")
				.convertBodyTo(Abc.class);
	}
}