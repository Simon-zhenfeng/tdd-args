package tdd.args;

/**
 * @author Simon
 * @date 2020/8/26 08:25
 */
public class BooleanFlag extends Flag {
    public BooleanFlag(String name) {
        super(name);
    }

    @Override
    public Object getValue(Args args) {
        if (args.contains(name)) {
            return true;
        }
        return Boolean.parseBoolean(args.getValue(name));
    }
}
