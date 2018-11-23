package com.ey.piit.core.format;

import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.ey.piit.core.utils.DateUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@Component 
public class JsonTimeSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		jsonGenerator.writeString(DateUtils.formatTime(date));
	}
	
}
