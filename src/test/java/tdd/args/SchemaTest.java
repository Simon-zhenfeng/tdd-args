package tdd.args;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Simon
 * @date 2020/8/13 09:01
 */
public class SchemaTest {
    @Test(expected = IllegalArgumentException.class)
    public void when_input_empty_schema_then_throw_exception() {
        new Schema("");
    }

    @Test
    public void when_flag_exist_then_return_true() {
        Schema schema = new Schema("d string");
        assertThat(schema.exist("d")).isTrue();
    }

    @Test
    public void when_two_flag_exist_then_return_true() {
        Schema schema = new Schema("d string p integer");
        assertThat(schema.exist("p")).isTrue();
    }
}
