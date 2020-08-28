package tdd.args;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/8/27 09:29
 */
public class ArgumentTest {
    @Test
    public void when_boolean_type_then_create_boolean_argument() {
        Argument argument = Argument.of("l", Schema.BOOLEAN, null);
        assertThat(argument).isInstanceOf(BooleanArgument.class);
    }

    @Test
    public void when_integer_type_then_create_integer_argument() {
        Argument argument = Argument.of("p", Schema.INTEGER, null);
        assertThat(argument).isInstanceOf(IntegerArgument.class);
    }

    @Test
    public void when_string_type_then_create_string_argument() {
        Argument argument = Argument.of("d", Schema.STRING, null);
        assertThat(argument).isInstanceOf(StringArgument.class);
    }

    @Test
    public void when_string_type_then_get_string_value() {
        Argument argument = Argument.of("d", Schema.STRING, "/usr/tmp");
        assertThat(argument.getValue()).isEqualTo("/usr/tmp");
    }

    @Test
    public void when_boolean_type_then_get_boolean_value() {
        assertThat(Argument.of("l", Schema.BOOLEAN, "true").getValue()).isEqualTo(true);
        assertThat(Argument.of("l", Schema.BOOLEAN, null).getValue()).isEqualTo(true);
        assertThat(Argument.of("l", Schema.BOOLEAN, "false").getValue()).isEqualTo(false);
    }

    @Test
    public void when_integer_type_then_get_integer_value() {
        assertThat(Argument.of("l", Schema.INTEGER, "80").getValue()).isEqualTo(80);
    }


}

