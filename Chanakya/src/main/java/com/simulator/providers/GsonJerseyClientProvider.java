package com.simulator.providers;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.simulator.util.LogManager;

@Provider
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GsonJerseyClientProvider<T> implements MessageBodyReader<T>, MessageBodyWriter<T> {

	private static final String UTF_8 = "UTF-8";
	private final Gson gson;

	public GsonJerseyClientProvider() {
		GsonBuilder builder = new GsonBuilder().serializeNulls().enableComplexMapKeySerialization();

		this.gson = builder.create();
	}

	public long getSize(T t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return true;
	}

	public void writeTo(T t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException {

		PrintWriter printWriter = new PrintWriter(entityStream);
		try {
			String json;
			json = gson.toJson(t);
			printWriter.write(json);
			printWriter.flush();
		} finally {
			printWriter.close();
		}
	}

	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return true;
	}

	public T readFrom(Class<T> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException {

		InputStreamReader reader = new InputStreamReader(entityStream, UTF_8);
		try {
			return gson.fromJson(reader, type);
		} catch (Exception e) {
			LogManager.errorLog.error("Error in json write	:" + e.getMessage(), e);
			return null;
		} finally {

			reader.close();
		}
	}
}
