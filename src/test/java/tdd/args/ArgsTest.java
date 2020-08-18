package tdd.args;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/8/17 07:45
 */
public class ArgsTest {
    @Test
    public void when_input_params_then_get_value_by_flag() {
        Args args = new Args("d:string, l:boolean, p:integer", "-l true -p 8080 -d /usr/logs");
        assertThat(args.getValue("d")).isEqualTo("/usr/logs");
        assertThat(args.getValue("l")).isEqualTo(true);
        assertThat(args.getValue("p")).isEqualTo(8080);
    }

    @Test
    public void when_parse_flag_with_null_then_get_default_value() {
        Args args = new Args("d:string, l:boolean, p:integer", "-l -p 8080 -d /usr/logs");
        assertThat(args.getValue("l")).isEqualTo(false);
    }
}
