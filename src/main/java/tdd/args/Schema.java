package tdd.args;

/**
 * @author Simon
 * @date 2020/8/25 07:56
 */
public class Schema {
    private final Args args;

    public Schema(Args args, String schemaAsString) {

        this.args = args;
    }

    public Object getValue(String flagName) {
        String valueAsString = args.getValue(flagName);
        if (flagName.equals("p")) {
            if (valueAsString == null) {
                return 0;
            }
            return Integer.parseInt(valueAsString);
        }
        if (flagName.equals("d")) {
            if (valueAsString == null) {
                return "";
            }
            return valueAsString;
        }
        if (flagName.equals("l")) {
            return Boolean.parseBoolean(valueAsString) || args.contains(flagName);
        }
        return null;
    }
}
