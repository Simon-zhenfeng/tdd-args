package tdd.args;

/**
 * @author Simon
 * @date 2020/8/31 08:59
 */
public class StringArgsMarshaller extends ArgsMarshaller {
    private String stringValue;


    @Override
    public Object getValue() {
        return stringValue == null ? "" : stringValue.trim();
    }

    @Override
    public void setValue(String stringValue) {
        this.stringValue = stringValue;
    }
}
