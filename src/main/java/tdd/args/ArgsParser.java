package tdd.args;

/**
 * @author Simon
 * @date 2020/8/18 09:13
 */
public class ArgsParser {

    private final Argument argument;
    private final Schema schema;

    public ArgsParser(String schemas, String args) {
        schema = new Schema(schemas);
        argument = new Argument(args);
    }

    public Object getValue(String flag) {
        String value = argument.getValue(flag);
        return schema.convertTo(flag, value);
    }
}
