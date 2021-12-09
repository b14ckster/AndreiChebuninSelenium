package hw5.context;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private static TestContext instance = new TestContext();
    private Map<String, Object> context = new HashMap<>();

    private TestContext() {}

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }

    public TestContext setTestObject(String key, Object value) {
        context.put(key, value);
        return this;
    }

    public <T> T getTestObject(String key) {
        return (T) context.get(key);
    }

    public void clearContext() {
        context.clear();
        instance = null;
    }
}
