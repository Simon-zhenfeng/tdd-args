package tdd.args;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Simon
 * @date 2020/8/25 07:56
 */
public class Schema {
    private final Args args;

    private final Map<String, Flag> flags;


    public Schema(Args args, String schemaAsString) {
        this.args = args;
        flags = new HashMap<>();
        parseSchema(schemaAsString);
    }


    private void parseSchema(String schemaAsString) {
        Arrays.stream(schemaAsString.split(","))
                .forEach(this::parseSchemaPair);
    }

    private void parseSchemaPair(String pair) {
        String[] split = pair.split(":");
        flags.put(split[0], Flag.of(split[0], split[1]));
    }

    public Object getValue(String flagName) {
        return flags.get(flagName).getValue(args);
    }
}
