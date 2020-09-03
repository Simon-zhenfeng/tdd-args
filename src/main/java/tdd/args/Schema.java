package tdd.args;

import java.util.Arrays;

/**
 * @author Simon
 * @date 2020/9/2 08:41
 */
public enum Schema {
    STRING,
    INTEGER,
    BOOLEAN;

    public static Schema of(String type) {
        return Arrays.stream(Schema.values())
                .filter(schema -> schema.name().equalsIgnoreCase(type))
                .findAny()
                .orElseThrow(() -> new ArgsException("The schema type is not exist: " + type));
    }
}
