package fg7;

import java.util.List;


import fg7.domain.Abc;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@CamelSpringBootTest
@SpringBootTest(classes = {MyApplication.class}, properties = {"camel.springboot.java-routes-include-pattern=**/Data*"})
public class Camel2ConverterTest {

	@Autowired
	CamelContext context;

	ProducerTemplate producerTemplate;

	@BeforeEach
	public void setup() {
		producerTemplate = context.createProducerTemplate();
	}

	@Test
	public void testCustomConverter() {
//		context.getTypeConverterRegistry().addTypeConverters(new AbcConverter());

		byte[] data = "John Doe 22".getBytes();
		final Abc abc = producerTemplate.requestBody("direct:convert1", data, Abc.class);

		assertNotNull(abc);

		assertEquals("John", abc.getFirstName());
		assertEquals("Doe", abc.getLastName());
		assertEquals(22, abc.getAge());
	}

}
