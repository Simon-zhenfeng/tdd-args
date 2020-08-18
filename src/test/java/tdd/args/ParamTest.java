package tdd.args;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/8/17 08:09
 */
public class ParamTest {
    @Test
    public void when_multi_param_then_get_string_value() {
        Param param = new Param("-p 8080 -l true -d /usr/logs");
        assertThat(param.getValue("p")).isEqualTo("8080");
        assertThat(param.getValue("d")).isEqualTo("/usr/logs");
        assertThat(param.getValue("l")).isEqualTo("true");
    }

    @Test
    public void when_parse_no_value_param_then_get_null() {
        Param param = new Param("-p 8080 -l -d /usr/logs");
        assertThat(param.getValue("l")).isNull();
    }
}
