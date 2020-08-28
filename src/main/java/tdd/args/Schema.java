package tdd.args;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author Simon
 * @date 2020/8/27 09:35
 */
public enum Schema {
    STRING, BOOLEAN, INTEGER;

    public static Schema of(String schemaName) {
        Optional<Schema> optional = Arrays.stream(Schema.values())
                .filter(schema -> schema.name().equalsIgnoreCase(schemaName))
                .findAny();
        return optional.orElseThrow(() -> new ArgsException("Schema is not exist: " + schemaName));
    }
}
