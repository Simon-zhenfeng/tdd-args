package tdd.args;

/**
 * @author Simon
 * @date 2020/8/26 08:24
 */
public abstract class Flag {
    protected final String name;

    public Flag(String name) {
        this.name = name;
    }

    public static Flag of(String name, String type) {
        if (type.equals("boolean")) {
            return new BooleanFlag(name);
        }
        if(type.equals("integer")) {
            return new IntegerFlag(name);
        }
        if (type.equals("string")) {
            return new StringFlag(name);
        }
        return null;
    }

    public abstract Object getValue(Args args);
}
