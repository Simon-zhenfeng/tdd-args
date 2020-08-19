package tdd.args;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Simon
 * @date 2020/8/19 08:41
 */
public class Schema {

    private final HashMap<String, String> flagTypeMap;

    public Schema(String schemaString) {
        flagTypeMap = new HashMap<>();
        Arrays.stream(schemaString.split(","))
                .forEach(pair -> {
                    String[] pairs = pair.trim().split(":");
                    flagTypeMap.put(pairs[0], pairs[1]);
                });
    }

    public Object convertTo(String flag, String value) {
        switch (flagTypeMap.get(flag)) {
            case "boolean":
                return toBooleanValue(value);

            case "integer":
                return toIntegerValue(value);
            default:
                return value;
        }
    }

    private int toIntegerValue(String value) {
        if (value == null) {
            return 0;
        }
        return Integer.parseInt(value);
    }

    private boolean toBooleanValue(String value) {
        if (value == null) {
            return false;
        }
        if (value.equals("")) {
            return true;
        }
        return Boolean.parseBoolean(value);
    }
}
