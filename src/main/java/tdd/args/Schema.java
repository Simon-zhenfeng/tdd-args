package tdd.args;

import java.util.Arrays;

/**
 * @author Simon
 * @date 2020/8/30 23:56
 */
public enum Schema {
    STRING, INTEGER, BOOLEAN;

    //TODO 没有考虑娶不到的情况
    public static Schema of(String type) {
        return Arrays.stream(Schema.values())
                .filter(schema -> schema.name().equalsIgnoreCase(type))
                .findAny().get();
    }
}
