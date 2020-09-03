package tdd.args;

/**
 * @author Simon
 * @date 2020/9/3 08:09
 */
public class StringArgsMarshaller extends ArgsMarshaller {
    private String valueAsString;

    public StringArgsMarshaller() {
    }

    @Override
    public Object getValue() {
        return valueAsString == null ? "" : valueAsString;
    }

    @Override
    public void setValue(String valueAsString) {
        this.valueAsString = valueAsString;
    }
}
