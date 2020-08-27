package tdd.args;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/8/25 07:32
 */
public class ArgsPasterTest {

    @Test
    public void when_parse_string_args_with_schema_then_get_values() {
        String schema = "d:string,l:boolean,p:integer";
        String[] args = {"-l", "-p", "8080", "-d", "/usr/logs"};
        ArgsParser parser = new ArgsParser(schema, args);
        assertThat(parser.getValue("l")).isEqualTo(true);
        assertThat(parser.getValue("p")).isEqualTo(8080);
        assertThat(parser.getValue("d")).isEqualTo("/usr/logs");
    }

    @Test(expected = ArgsException.class)
    public void when_flag_is_not_in_schema_then_throw_arg_exception() {
        String schema = "d:string,l:boolean,p:integer";
        String[] args = {"-l", "-p", "8080", "-d", "/usr/logs", "-v", "vip"};
        ArgsParser parser = new ArgsParser(schema, args);
    }
}
