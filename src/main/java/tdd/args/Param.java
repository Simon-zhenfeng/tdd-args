package tdd.args;

import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * @author Simon
 * @date 2020/8/17 08:00
 */
public class Param {

    private final HashMap<String, String> paramMap;

    public Param(String value) {
        paramMap = new HashMap<>();
        String[] values = value.split("\\s+");
        for (int i = 0; i < values.length; i++) {
            int valueIdx = i + 1;
            Pattern pattern = Pattern.compile("^-[a-z]$");
            if (valueIdx < values.length && !pattern.matcher(values[valueIdx]).matches()) {
                paramMap.put(values[i], values[valueIdx]);
                i = valueIdx;
            } else {
                paramMap.put(values[i], null);
            }
        }
    }

    public String getValue(String flag) {
        return paramMap.get("-" + flag);
    }
}
