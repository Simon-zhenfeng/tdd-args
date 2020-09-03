package tdd.args;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/9/1 08:31
 */
public class ArgsParserTest {
    @Test
    public void when_input_schema_and_args_then_get_the_args_value() {
        final String schemaAsString = "l:boolean, d:string, p:integer";
        final String[] inputArgs = {"-l", "-p", "8080", "-d", "/usr/logs"};
        ArgsParser parser = new ArgsParser(schemaAsString, inputArgs);
        assertThat(parser.getValue("d")).isEqualTo("/usr/logs");
        assertThat(parser.getValue("p")).isEqualTo(8080);
        assertThat(parser.getValue("l")).isEqualTo(true);
    }

    @Test
    public void when_input_schema_and_no_args_then_get_the_default_value() {
        final String schemaAsString = "l:boolean, d:string, p:integer";
        final String[] inputArgs = {};
        ArgsParser parser = new ArgsParser(schemaAsString, inputArgs);
        assertThat(parser.getValue("d")).isEqualTo("");
        assertThat(parser.getValue("p")).isEqualTo(0);
        assertThat(parser.getValue("l")).isEqualTo(false);
    }

    @Test
    public void when_input_schema_and_args_value_as_null_then_get_the_default_value() {
        final String schemaAsString = "l:boolean, d:string, p:integer";
        final String[] inputArgs = {"-l", "-d", "-p"};
        ArgsParser parser = new ArgsParser(schemaAsString, inputArgs);
        assertThat(parser.getValue("d")).isEqualTo("");
        assertThat(parser.getValue("p")).isEqualTo(0);
        assertThat(parser.getValue("l")).isEqualTo(true);
    }

    @Test
    public void when_input_string_arg_then_get_string_value() {
        final String schemaAsString = "d:string";
        final String[] inputArgs = {"-d", "/usr/log"};
        ArgsParser parser = new ArgsParser(schemaAsString, inputArgs);
        assertThat(parser.getValue("d")).isEqualTo("/usr/log");
    }

    @Test
    public void when_input_integer_arg_then_get_integer_value() {
        final String schemaAsString = "p:integer";
        final String[] inputArgs = {"-p", "80"};
        ArgsParser parser = new ArgsParser(schemaAsString, inputArgs);
        assertThat(parser.getValue("p")).isEqualTo(80);
    }

    @Test(expected = ArgsException.class)
    public void when_input_schema_type_is_not_exist_then_throw_exception() {
        final String schemaAsString = "p:demo";
        final String[] inputArgs = {"-p", "80"};
        ArgsParser parser = new ArgsParser(schemaAsString, inputArgs);
    }

    @Test(expected = ArgsException.class)
    public void when_input_arg_flag_is_not_exist_then_throw_exception() {
        final String schemaAsString = "p:integer";
        final String[] inputArgs = {"-v", "80"};
        ArgsParser parser = new ArgsParser(schemaAsString, inputArgs);
    }

    @Test(expected = ArgsException.class)
    public void when_get_value_flag_is_not_exist_then_throw_exception() {
        final String schemaAsString = "p:integer";
        final String[] inputArgs = {"-p", "80"};
        ArgsParser parser = new ArgsParser(schemaAsString, inputArgs);
        parser.getValue("t");
    }

    @Test
    public void when_input_boolean_arg_as_true_then_get_true() {
        final String schemaAsString = "l:boolean";
        final String[] inputArgs = {"-l", "true"};
        ArgsParser parser = new ArgsParser(schemaAsString, inputArgs);
        assertThat(parser.getValue("l")).isEqualTo(true);
    }

    @Test
    public void when_input_boolean_arg_as_false_then_get_false() {
        final String schemaAsString = "l:boolean";
        final String[] inputArgs = {"-l", "false"};
        ArgsParser parser = new ArgsParser(schemaAsString, inputArgs);
        assertThat(parser.getValue("l")).isEqualTo(false);
    }

    @Test
    public void when_input_boolean_arg_no_value_then_get_true() {
        final String schemaAsString = "l:boolean";
        final String[] inputArgs = {"-l"};
        ArgsParser parser = new ArgsParser(schemaAsString, inputArgs);
        assertThat(parser.getValue("l")).isEqualTo(true);
    }
}
