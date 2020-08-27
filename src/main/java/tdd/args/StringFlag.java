package tdd.args;

/**
 * @author Simon
 * @date 2020/8/26 09:07
 */
public class StringFlag extends Flag {
    public StringFlag(String name) {
        super(name);
    }

    @Override
    public Object getValue(Args args) {
        String value = args.getValue(name);
        return value == null ? "" : value;
    }

}
