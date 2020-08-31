package tdd.args;

/**
 * @author Simon
 * @date 2020/8/31 09:03
 */
public class IntegerArgsMarshaller extends ArgsMarshaller {
    private String stringValue;

    @Override
    public void setValue(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public Object getValue() {
        return stringValue == null ? 0 : Integer.parseInt(stringValue);
    }
}
