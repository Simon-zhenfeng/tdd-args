package tdd.args;

/**
 * @author Simon
 * @date 2020/8/26 09:08
 */
public class IntegerFlag extends Flag {
    public IntegerFlag(String name) {
        super(name);
    }

    @Override
    public Object getValue(Args args) {
        String valueAsString = args.getValue(name);

        if (valueAsString == null) {
            return 0;
        }
        return Integer.parseInt(valueAsString);

    }
}
