package tdd.args;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/8/30 23:44
 */
public class ArgsParserTest {
    @Test
    public void when_parse_args_then_get_values() {
        String schemaAsString = "l:boolean,d:string,p:integer";
        String[] args = new String[]{"-l", "-d", "/usr/logs", "-p", "8080"};
        ArgsParser parser = new ArgsParser(schemaAsString, args);
        assertThat(parser.getValue("l")).isEqualTo(true);
        assertThat(parser.getValue("d")).isEqualTo("/usr/logs");
        assertThat(parser.getValue("p")).isEqualTo(8080);
    }

    @Test
    public void when_parse_no_input_args_then_get_default_values() {
        String schemaAsString = "l:boolean,d:string,p:integer";
        String[] args = new String[]{};
        ArgsParser parser = new ArgsParser(schemaAsString, args);
        assertThat(parser.getValue("l")).isEqualTo(false);
        assertThat(parser.getValue("d")).isEqualTo("");
        assertThat(parser.getValue("p")).isEqualTo(0);
    }

    @Test
    public void when_parse_input_args_no_value_then_get_default_values() {
        String schemaAsString = "l:boolean,d:string,p:integer";
        String[] args = new String[]{"-l", "-p", "-d"};
        ArgsParser parser = new ArgsParser(schemaAsString, args);
        assertThat(parser.getValue("l")).isEqualTo(true);
        assertThat(parser.getValue("d")).isEqualTo("");
        assertThat(parser.getValue("p")).isEqualTo(0);
    }

    @Test
    public void when_parse_string_arg_then_get_string_value() {
        String schemaAsString = "d:string";
        String[] args = new String[]{"-d", "/usr/logs"};
        ArgsParser parser = new ArgsParser(schemaAsString, args);
        assertThat(parser.getValue("d")).isEqualTo("/usr/logs");
    }


    @Test
    public void when_parse_integer_arg_then_get_integer_value() {
        String schemaAsString = "p:integer";
        String[] args = new String[]{"-p", "8081"};
        ArgsParser parser = new ArgsParser(schemaAsString, args);
        assertThat(parser.getValue("p")).isEqualTo(8081);
    }

}
