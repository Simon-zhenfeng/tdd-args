package tdd.args;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/8/13 08:17
 */
public class ArgsParserTest {
    @Test(expected = IllegalArgumentException.class)
    public void when_parse_empty_args_then_return_throw_exception() {
        String[] args = null;
        String schema = "l boolean";
        ArgsParser argsParser = new ArgsParser(schema, args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_parse_empty_schema_then_throw_exception() {
        String[] args = {"args"};
        String schema = "";
        ArgsParser argsParser = new ArgsParser(schema, args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_single_arg_and_flag_is_not_exist_in_schema_then_throw_exception() {
        String[] args = {"-d", "/usr/logs"};
        String schema = "l boolean";
        ArgsParser argsParser = new ArgsParser(schema, args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_more_args_and_flag_is_not_exist_in_schema_than_throw_exception() {
        String[] args = {"-d", "/usr/logs", "-p", "8080"};
        String schema = "d string";
        ArgsParser argsParser = new ArgsParser(schema, args);
    }

    @Test
    public void when_parse_one_string_arg_then_return_the_value() {
        String[] args = {"-d", "/usr/logs"};
        String schema = "d string";
        ArgsParser argsParser = new ArgsParser(schema, args);
        assertThat(argsParser.getValue("d")).isEqualTo("/usr/logs");
    }

    @Test
    public void when_parse_two_string_args_then_return_the_value() {
        String[] args = {"-d", "/usr/logs", "-a", "beijing"};
        String schema = "d string a string";
        ArgsParser argsParser = new ArgsParser(schema, args);
        assertThat(argsParser.getValue("d")).isEqualTo("/usr/logs");
        assertThat(argsParser.getValue("a")).isEqualTo("beijing");
    }

    @Test
    public void when_parse_one_integer_arg_then_return_the_value() {
        String[] args = {"-p", "8080"};
        String schema = "p integer";
        ArgsParser argsParser = new ArgsParser(schema, args);
        assertThat(argsParser.getValue("p")).isEqualTo(8080);
    }

    @Test
    public void when_parse_one_integer_arg_with_negative_value_then_return_value() {
        String[] args = {"-p", "-9"};
        String schema = "p integer";
        ArgsParser argsParser = new ArgsParser(schema, args);
        assertThat(argsParser.getValue("p")).isEqualTo(-9);
    }

    @Test
    public void when_parse_one_boolean_arg_with_true_then_return_true() {
        String[] args = {"-l", "true"};
        String schema = "l boolean";
        ArgsParser argsParser = new ArgsParser(schema, args);
        assertThat(argsParser.getValue("l")).isEqualTo(true);
    }

    @Test
    public void when_one_boolean_arg_with_space_then_return_default() {
        String[] args = {"-l"};
        String schema = "l boolean";
        ArgsParser argsParser = new ArgsParser(schema, args);
        assertThat(argsParser.getValue("l")).isEqualTo(false);
    }

    @Test
    public void when_multiple_args_then_return_the_value() {
        String[] args = {"-l", "-p", "8080", "-d", "/usr/logs"};
        String schema = "l boolean p integer d string";
        ArgsParser argsParser = new ArgsParser(schema, args);
        assertThat(argsParser.getValue("l")).isEqualTo(false);
        assertThat(argsParser.getValue("p")).isEqualTo(8080);
        assertThat(argsParser.getValue("d")).isEqualTo("/usr/logs");

    }
}
