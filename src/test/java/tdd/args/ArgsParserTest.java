package tdd.args;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/8/27 09:14
 */
public class ArgsParserTest {
    @Test
    public void when_parse_input_args_then_get_the_value() {
        String schemaAsString = "l:boolean, d:string, p:integer";
        String[] inputArgs = {"-p", "8080", "-d", "/usr/logs", "-l"};
        ArgsParser parser = new ArgsParser(schemaAsString, inputArgs);
        assertThat(parser.getValue("l")).isEqualTo(true);
        assertThat(parser.getValue("d")).isEqualTo("/usr/logs");
        assertThat(parser.getValue("p")).isEqualTo(8080);
    }

    @Test(expected = ArgsException.class)
    public void when_get_value_flag_not_exist_then_throw_exception() {
        String schemaAsString = "l:boolean, d:string, p:integer";
        String[] inputArgs = {"-p", "8080", "-d", "/usr/logs", "-l"};
        ArgsParser parser = new ArgsParser(schemaAsString, inputArgs);
        assertThat(parser.getValue("l")).isEqualTo(true);
        assertThat(parser.getValue("d")).isEqualTo("/usr/logs");
        assertThat(parser.getValue("p")).isEqualTo(8080);
        assertThat(parser.getValue("v")).isEqualTo(8080);
    }


}
