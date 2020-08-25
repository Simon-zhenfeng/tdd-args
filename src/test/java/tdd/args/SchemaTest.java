package tdd.args;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SchemaTest {
    @Test
    public void when_input_value_is_null_then_get_default_value() {
        Schema schema = new Schema(new Args(new String[]{}), "l:boolean,d:string,p:integer");
        assertThat(schema.getValue("l")).isEqualTo(false);
        assertThat(schema.getValue("p")).isEqualTo(0);
        assertThat(schema.getValue("d")).isEqualTo("");
    }
}