package tdd.args;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Simon
 * @date 2020/8/13 08:33
 */
public class ArgsParser {
    private final Schema schema;
    private final Map<String, Object> argsMap;

    public ArgsParser(String schema, String[] args) {
        this.schema = new Schema(schema);
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("args is null");
        }
        Arrays.stream(args).forEach(arg -> {
            Pattern pattern = Pattern.compile("^-[a-z]$");
            if (pattern.matcher(arg).matches()) {
                if (!this.schema.exist(getFlag(arg))) {
                    throw new IllegalArgumentException("flag is not exist");
                }
            }
        });
        argsMap = new HashMap<>();
        parse(args);
    }

    private void parse(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String flag = getFlag(args[i]);
            int valIndex = i + 1;
            Pattern pattern = Pattern.compile("^-[a-z]$");
            if (valIndex < args.length && !pattern.matcher(args[valIndex]).matches()) {
                argsMap.put(flag, schema.getValue(flag, args[valIndex]));
                i = valIndex;
            } else {
                argsMap.put(flag, schema.getDefaultValue(flag));
            }
        }
    }

    private String getFlag(String arg) {
        return arg.split("-")[1];
    }

    public Object getValue(String flag) {
        return argsMap.get(flag);
    }
}
