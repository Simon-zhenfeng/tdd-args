package tdd.args;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Simon
 * @date 2020/8/25 07:37
 */
public class ArgsParser {
    private final Args args;
    private final Schema schema;

    public ArgsParser(String schemaAsString, String[] inputArgs) {
        args = new Args(inputArgs);
        schema = new Schema(args, schemaAsString);
    }


    public Object getValue(String flagName) {
        return schema.getValue(flagName);
    }
}
