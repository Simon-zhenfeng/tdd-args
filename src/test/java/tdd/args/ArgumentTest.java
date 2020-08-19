package tdd.args;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/8/18 09:17
 */
public class ArgumentTest {
    @Test
    public void when_args_with_value_then_get_args_value() {
        Argument argument = new Argument("-d /usr/logs");
        String result = argument.getValue("d");
        assertThat(result).isEqualTo("/usr/logs");
    }

    @Test
    public void when_args_with_no_value_then_get_empty_string() {
        Argument argument = new Argument("-l -d /usr/logs");
        String result = argument.getValue("l");
        assertThat(result).isEqualTo("");
    }

    @Test
    public void when_flag_not_exist_then_get_null() {
        Argument argument = new Argument("-l -d /usr/logs");
        String result = argument.getValue("p//");
        assertThat(result).isNull();
    }
}
