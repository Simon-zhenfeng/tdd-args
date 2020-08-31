package tdd.args;

/**
 * @author Simon
 * @date 2020/8/31 00:07
 */
public abstract class ArgsMarshaller {

    public static ArgsMarshaller of(Schema schema) {
        if (schema == Schema.STRING) {
            return new StringArgsMarshaller();
        }
        if (schema == Schema.BOOLEAN) {
            return new BooleanArgsMarshaller();
        }
        if (schema == Schema.INTEGER) {
            return new IntegerArgsMarshaller();
        }
        return null;
    }

    public abstract Object getValue();

    public abstract void setValue(String stringValue);

}
