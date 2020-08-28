package tdd.args;

/**
 * @author Simon
 * @date 2020/8/28 00:10
 */
public class StringArgument extends Argument{
    public StringArgument(String flagName, Schema schema, String value) {
        super(flagName, schema, value);
    }

    @Override
    public String getValue() {
        return value;
    }
}
