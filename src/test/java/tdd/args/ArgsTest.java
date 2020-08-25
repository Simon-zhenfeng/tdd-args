package tdd.args;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsTest {

    @Test
    public void when_input_args_with_value_then_get_string_value() {
        String[] input = {"-d", "/usr/logs", "-p", "8080"};
        Args args = new Args(input);
        assertThat(args.getValue("d")).isEqualTo("/usr/logs");
        assertThat(args.getValue("p")).isEqualTo("8080");
    }

    @Test
    public void when_input_args_with_none_value_then_get_null_value() {
        String[] input = {"-d", "/usr/logs", "-p", "8080", "-l"};
        Args args = new Args(input);
        assertThat(args.getValue("d")).isEqualTo("/usr/logs");
        assertThat(args.getValue("p")).isEqualTo("8080");
        assertThat(args.getValue("l")).isNull();
    }

    @Test
    public void when_input_args_with_none_value_then_is_contains() {
        String[] input = {"-d", "/usr/logs", "-p", "8080", "-l"};
        Args args = new Args(input);
        assertThat(args.contains("l")).isTrue();
    }

    @Test
    public void when_flag_is_not_in_input_args_then_return_null_and_is_not_contains() {
        String[] input = {"-d", "/usr/logs", "-p", "8080", "-l"};
        Args args = new Args(input);
        assertThat(args.contains("v")).isFalse();
        assertThat(args.getValue("v")).isNull();
    }
}