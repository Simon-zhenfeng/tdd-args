package tdd.args;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Simon
 * @date 2020/8/30 23:49
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
            String flagName = getFlagName(inputArgs[index].trim());
            int valueIndex = index + 1;
            if (valueIndex < inputArgs.length && isNotFlag(inputArgs[valueIndex].trim())) {
                argsMarshallerMap.get(flagName).setValue(inputArgs[valueIndex].trim());
                index = valueIndex;
            } else {
                argsMarshallerMap.get(flagName).setValue(null);
            }
        }

    }

    private boolean isNotFlag(String inputArg) {
        Pattern pattern = Pattern.compile("^-[a-z]$");
        return !pattern.matcher(inputArg).matches();
    }

    private String getFlagName(String flag) {
        return flag.substring(1);
    }

    private void parseSchema(String schemaAsString) {
        Arrays.stream(schemaAsString.split(","))
                .forEach(schemaElement ->
                        parseSchemaElement(schemaElement.trim())
                );
    }

    private void parseSchemaElement(String schemaElement) {
        String[] pair = schemaElement.split(":");
        String flagName = pair[0].trim();
        Schema schema = Schema.of(pair[1].trim());
        argsMarshallerMap.put(flagName, ArgsMarshaller.of(schema));
    }

    public Object getValue(String flagName) {
        return argsMarshallerMap.get(flagName).getValue();
    }
}
