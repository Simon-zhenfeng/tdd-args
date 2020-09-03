package tdd.args;

/**
 * @author Simon
 * @date 2020/9/2 08:30
 */
public abstract class ArgsMarshaller {

    public static ArgsMarshaller of(Schema schema) {
        switch (schema) {
            case STRING:
                return new StringArgsMarshaller();
            case INTEGER:
                return new IntegerArgsMarshaller();
            case BOOLEAN:
                return new BooleanArgsMarshaller();
        }
        throw new ArgsException("No Args Marshaller with the schema: " + schema);
    }

    public abstract Object getValue();

    public abstract void setValue(String valueAsString);

}
