package tdd.args;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Simon
 * @date 2020/8/27 09:18
 */
public class ArgsParser {
    private final Map<String, Argument> args;
    private final Map<String, Schema> schemas;

    public ArgsParser(String schemaAsString, String[] inputArgs) {
        args = new HashMap<>();
        schemas = new HashMap<>();
        parseSchemas(schemaAsString);
        parseArgs(inputArgs);
    }

    private void parseArgs(String[] inputArgs) {
        for (int index = 0; index < inputArgs.length; index++) {
            String flagName = toFlagName(inputArgs[index]);

            int valueIndex = index + 1;
            String value = null;
            if (valueIndex < inputArgs.length && !isFlag(inputArgs[valueIndex])) {
                value = inputArgs[valueIndex];
                index = valueIndex;
            }
            args.put(flagName, Argument.of(flagName, schemas.get(flagName), value));
        }
    }

    private boolean isFlag(String inputArg) {
        Pattern pattern = Pattern.compile("^-[a-z]$");
        return pattern.matcher(inputArg).matches();
    }

    private String toFlagName(String argName) {
        return argName.substring(1);
    }

    private void parseSchemas(String schemaAsString) {
        
        schemas.put("l", Schema.BOOLEAN);
        schemas.put("p", Schema.INTEGER);
        schemas.put("d", Schema.STRING);
    }

    //TODO 没有实现
    public Object getValue(String flagName) {
        if (flagName.equals("l")) {
            return args.get("l").getValue();
        }
        if (flagName.equals("p")) {
            return args.get("p").getValue();
        }
        if (flagName.equals("d")) {
            return args.get("d").getValue();
        }
        throw new ArgsException("Flag is not exist");
    }

}
