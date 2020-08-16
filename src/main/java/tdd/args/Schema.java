package tdd.args;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Simon
 * @date 2020/8/13 09:03
 */
public class Schema {
    private final Map<String, String> flagAndTypes;

    public Schema(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("schema input is null");
        }
        flagAndTypes = new HashMap<>();
        String[] schemas = input.split(" ");
        for (int i = 0; i < schemas.length; i += 2) {
            flagAndTypes.put(schemas[i], schemas[i + 1]);
        }
    }

    public boolean exist(String flag) {
        return flagAndTypes.containsKey(flag);
    }

    public Object getValue(String flag, String value) {
        if (!exist(flag)) {
            throw new IllegalArgumentException("Flag is not exist");
        }
        switch (flagAndTypes.get(flag)) {
            case "integer":
                return Integer.parseInt(value);

            case "boolean":
                return Boolean.parseBoolean(value);
        }
        return value;
    }

    public Object getDefaultValue(String flag) {
        if (!exist(flag)) {
            throw new IllegalArgumentException("Flag is not exist");
        }
        if (flagAndTypes.get(flag).equals("boolean")) {
            return false;
        }
        return null;
    }
}
