package tdd.args;

/**
 * @author Simon
 * @date 2020/8/17 07:54
 */
public class Args {

    private final Param param;

    public Args(String schema, String params) {
        param = new Param(params);
    }

    public Object getValue(String flag) {
        String value = param.getValue(flag);
        if (flag.equals("l")) {
            return Boolean.parseBoolean(value);
        }
        if (flag.equals("p")) {
            return Integer.parseInt(value);
        }
        return value;
    }
}
