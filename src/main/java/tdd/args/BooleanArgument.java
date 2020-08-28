package tdd.args;

/**
 * @author Simon
 * @date 2020/8/28 00:00
 */
public class BooleanArgument extends Argument {
    public BooleanArgument(String flagName, Schema schema, String value) {
        super(flagName, schema, value);
    }

    @Override
    public Boolean getValue() {
        return value == null || value.equalsIgnoreCase("true");
    }
}
