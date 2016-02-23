package com.yilv.base.common.entity.json;

import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

public class MyObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
	private SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);

	public MyObjectMapper() {
		super();

		setDateFormat(dateFormat);
		setAnnotationIntrospector(new MyAnnotationIntrospector());
	}

	private class MyAnnotationIntrospector extends JacksonAnnotationIntrospector {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";

		@Override
		public Object findSerializer(Annotated a) {
			if (a instanceof AnnotatedMethod) {
				AnnotatedElement m = a.getAnnotated();
				DateTimeFormat an = m.getAnnotation(DateTimeFormat.class);
				if (an != null) {
					if (!DEFAULT_DATE_FORMAT.equals(an.pattern())) {
						return new JsonDateSerializer(an.pattern());
					}
				}
			}
			return super.findSerializer(a);
		}

		/**
		 * 覆盖父类的方法，循环向上寻找JsonIgnoreProperties注解，<br>
		 * 原方法不支持父类的注解
		 * 
		 */
		@Override
		public String[] findPropertiesToIgnore(Annotated ac) {
			List<String> list = new ArrayList<String>();
			try {
				Class<?> clz = Class.forName(ac.getName());
				for (Class<?> superClass = clz; superClass != Object.class; superClass = superClass.getSuperclass()) {
					JsonIgnoreProperties ignore = superClass.getAnnotation(JsonIgnoreProperties.class);
					if (ignore != null) {
						for (String str : ignore.value()) {
							list.add(str);
						}
					}
				}
			} catch (ClassNotFoundException e) {
				return null;
			}
			return list.toArray(new String[0]);
		}
	}

	private class JsonDateSerializer extends JsonSerializer<Date> {
		private SimpleDateFormat dateFormat;

		public JsonDateSerializer(String format) {
			dateFormat = new SimpleDateFormat(format);
		}

		@Override
		public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException,
				JsonProcessingException {
			if (date != null) {
				String value = dateFormat.format(date);
				gen.writeString(value);
			}
		}
	}

}
