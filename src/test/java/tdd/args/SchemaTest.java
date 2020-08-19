package tdd.args;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/8/19 08:38
 */
public class SchemaTest {
    @Test
    public void when_string_type_then_convert_to_string_value() {
        Schema schema = new Schema("d:string,l:boolean");
        Object value = schema.convertTo("d", "/usr/logs");
        assertThat(value).isEqualTo("/usr/logs");
    }

    @Test
    public void when_boolean_type_then_convert_to_boolean_value() {
        Schema schema = new Schema("d:string,l:boolean");
        Object value = schema.convertTo("l", "true");
        assertThat(value).isEqualTo(true);
    }

    @Test
    public void when_boolean_type_and_value_is_empty_convert_to_true() {
        Schema schema = new Schema("d:string,l:boolean");
        Object value = schema.convertTo("l", "");
        assertThat(value).isEqualTo(true);
    }

    @Test
    public void when_boolean_type_and_value_is_null_convert_to_false() {
        Schema schema = new Schema("d:string,l:boolean");
        Object value = schema.convertTo("l", null);
        assertThat(value).isEqualTo(false);
    }

    @Test
    public void when_integer_type_and_value_is_null_convert_to_0() {
        Schema schema = new Schema("d:string,l:boolean,p:integer");
        Object value = schema.convertTo("p", null);
        assertThat(value).isEqualTo(0);
    }

    @Test
    public void when_integer_type_convert_to_integer() {
        Schema schema = new Schema("d:string,l:boolean,p:integer");
        Object value = schema.convertTo("p", "8080");
        assertThat(value).isEqualTo(8080);
    }



}
