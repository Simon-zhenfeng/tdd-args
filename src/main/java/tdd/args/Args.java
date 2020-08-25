package tdd.args;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Simon
 * @date 2020/8/25 07:54
 */
public class Args {
    private final Map<String, String> argsMap;

    public Args(String[] inputArgs) {
        argsMap = new HashMap<>();
        parseInputArgs(inputArgs);
    }

    private void parseInputArgs(String[] inputArgs) {
        for (int index = 0; index < inputArgs.length; index++) {
            String flagName = flagName(inputArgs[index]);
            int valueIndex = index + 1;
            if (valueIndex >= inputArgs.length || isFlag(inputArgs[valueIndex])) {
                argsMap.put(flagName, null);
            } else {
                argsMap.put(flagName, inputArgs[valueIndex]);
                index = valueIndex;
            }
        }
    }

    private boolean isFlag(String value) {
        Pattern pattern = Pattern.compile("^-[a-z]$");
        return pattern.matcher(value).matches();
    }

    private String flagName(String flag) {
        return flag.substring(1);
    }

    public String getValue(String flagName) {
        return argsMap.get(flagName);
    }

    public boolean contains(String flag) {
        return argsMap.containsKey(flag);
    }
}
