package tdd.args;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author Simon
 * @date 2020/8/18 09:22
 */
public class Argument {

    private final Map<String, String> argsMap;
    private static final Pattern FLAG_PATTERN = Pattern.compile("^-[a-z]$");

    public Argument(String inputArgs) {
        argsMap = new HashMap<>();
        initInputArgs(inputArgs);
    }

    private void initInputArgs(String inputArgs) {
        String[] argArr = inputArgs.split(" ");
        for (int i = 0; i < argArr.length; i++) {
            String flag = getFlag(argArr[i]);
            int valueIndex = i + 1;
            if (valueIndex < argArr.length && isNotFlag(argArr[valueIndex])) {
                argsMap.put(flag, argArr[valueIndex]);
                i = valueIndex;
            } else {
                argsMap.put(flag, "");
            }
        }
    }

    private String getFlag(String flagArg) {
        return flagArg.split("-")[1];
    }

    private boolean isNotFlag(String flag) {
        return !FLAG_PATTERN.matcher(flag).matches();
    }

    public String getValue(String flag) {
        return argsMap.get(flag);
    }

}
