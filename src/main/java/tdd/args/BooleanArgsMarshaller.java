package tdd.args;

/**
 * @author Simon
 * @date 2020/9/3 08:09
 */
public class BooleanArgsMarshaller extends ArgsMarshaller {
    private String valueAsString;
    private boolean exist;

    public BooleanArgsMarshaller() {
    }

    @Override
    public Object getValue() {
        if (valueAsString != null && exist) {
            return Boolean.parseBoolean(valueAsString);
        }
        return exist;
    }

    @Override
    public void setValue(String valueAsString) {
        this.valueAsString = valueAsString;
        this.exist = true;
    }
}
