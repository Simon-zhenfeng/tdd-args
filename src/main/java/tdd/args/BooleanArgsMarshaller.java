package tdd.args;

/**
 * @author Simon
 * @date 2020/8/31 09:03
 */
public class BooleanArgsMarshaller extends ArgsMarshaller {
    private String stringValue;
    private boolean exist;

    @Override
    public void setValue(String stringValue) {
        this.stringValue = stringValue;
        exist = true;
    }

    @Override
    public Object getValue() {
        if (stringValue != null) {
            return Boolean.parseBoolean(stringValue);
        }
        return exist;
    }
}
