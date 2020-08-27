package tdd.args;

/**
 * @author Simon
 * @date 2020/8/27 09:32
 */
public class Argument {
    private final String flagName;
    private final Schema schema;
    private final String value;

    public Argument(String flagName, Schema schema, String value) {
        this.flagName = flagName;
        this.schema = schema;
        this.value = value;
    }

    public static Argument of(String flagName, Schema schema, String value) {
        if (schema == Schema.BOOLEAN) {
            return new BooleanArgument(flagName, schema, value);
        }
        if (schema == Schema.INTEGER) {
            return new IntegerArgument(flagName, schema, value);
        }
        if (schema == Schema.STRING) {
            return new StringArgument(flagName, schema, value);
        }
        throw new ArgsException("Argument Type is not found");
    }

    public Object getValue() {
        if (flagName.equals("p")) {
            return Integer.parseInt(value);
        }
        if (flagName.equals("d")) {
            return value;
        }
        return true;
    }
}
