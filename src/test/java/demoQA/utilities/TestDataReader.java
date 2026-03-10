package demoQA.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

/**
 * Simple JSON testdata reader. Reads classpath resources under src/test/resources.
 */
public final class TestDataReader {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private TestDataReader() {}

    public static <T> List<T> readJsonList(String resourcePath, Class<T> elementClass) {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new RuntimeException("Test data resource not found: " + resourcePath);
            }
            return MAPPER.readValue(is, MAPPER.getTypeFactory().constructCollectionType(List.class, elementClass));
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON resource '" + resourcePath + "': " + e.getMessage(), e);
        }
    }
}