package tdd.args;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Simon
 * @date 2020/9/1 08:35
 */
public class ArgsParser {
    private final Map<String, ArgsMarshaller> argsMarshallerMap;

    public ArgsParser(String schemaAsString, String[] inputArgs) {
        argsMarshallerMap = new HashMap<>();
        parseSchema(schemaAsString);
        parseArgs(inputArgs);
    }

    private void parseArgs(String[] inputArgs) {
        for (int index = 0; index < inputArgs.length; index++) {
            String flag = inputArgs[index].trim();
            int valueIndex = index + 1;
            if (valueIndex < inputArgs.length && isNotFlag(inputArgs[valueIndex].trim())) {
                parseSingleArg(flag, inputArgs[valueIndex].trim());
                index = valueIndex;
            } else {
                parseSingleArg(flag, null);
            }
        }
    }

    private boolean isNotFlag(String inputArg) {
        Pattern pattern = Pattern.compile("^-[a-z]$");
        return !pattern.matcher(inputArg).matches();
    }

    private void parseSingleArg(String flag, String value) {
        String flagName = flagName(flag);
        if (!argsMarshallerMap.containsKey(flagName)) {
            throw new ArgsException("Input flag is not in the schema: " + flagName);
        }
        argsMarshallerMap.get(flagName).setValue(value);
    }

    private String flagName(String flag) {
        return flag.substring(1);
    }

    private void parseSchema(String schemaAsString) {
        Arrays.stream(schemaAsString.split(","))
                .forEach(pair -> parseSingleSchema(pair.trim()));
    }

    private void parseSingleSchema(String singleSchema) {
        String[] pairs = singleSchema.split(":");
        String flagName = pairs[0].trim();
        Schema schema = Schema.of(pairs[1].trim());
        argsMarshallerMap.put(flagName, ArgsMarshaller.of(schema));
    }

    public Object getValue(String flagName) {
        if (!argsMarshallerMap.containsKey(flagName)) {
            throw new ArgsException("Flag is not exist: " + flagName);
        }
        return argsMarshallerMap.get(flagName).getValue();
    }
}
