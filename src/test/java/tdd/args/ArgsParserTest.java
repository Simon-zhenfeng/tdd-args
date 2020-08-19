package tdd.args;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/8/18 09:09
 */
public class ArgsParserTest {
    @Test
    public void when_string_argument_then_get_string_value() {
        ArgsParser parser = new ArgsParser("d:string", "-d /usr/logs");
        Object result = parser.getValue("d");
        assertThat(result).isEqualTo("/usr/logs");
    }

    @Test
    public void when_integer_argument_then_get_int_value() {
        ArgsParser parser = new ArgsParser("p:integer", "-p 8080");
        Object result = parser.getValue("p");
        assertThat(result).isEqualTo(8080);
    }

    @Test
    public void when_boolean_value_then_get_boolean_value() {
        ArgsParser parser = new ArgsParser("p:integer,l:boolean", "-p 8080 -l");
        Object result = parser.getValue("l");
        assertThat(result).isEqualTo(true);
    }
}
