package tdd.args;

/**
 * @author Simon
 * @date 2020/9/3 08:09
 */
public class IntegerArgsMarshaller extends ArgsMarshaller {
    private String valueAsString;

    public IntegerArgsMarshaller() {
    }

    @Override
    public Object getValue() {
        if (valueAsString == null || valueAsString.trim().length() == 0) {
            return 0;
        }
        return Integer.parseInt(valueAsString);
    }

    @Override
    public void setValue(String valueAsString) {
        this.valueAsString = valueAsString;
    }
}
