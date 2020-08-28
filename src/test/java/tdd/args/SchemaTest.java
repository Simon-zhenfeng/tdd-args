package tdd.args;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SchemaTest {

    @Test
    public void create_schema_by_name() {
        assertThat(Schema.of("string")).isEqualTo(Schema.STRING);
        assertThat(Schema.of("boolean")).isEqualTo(Schema.BOOLEAN);
        assertThat(Schema.of("integer")).isEqualTo(Schema.INTEGER);
    }

    @Test(expected = ArgsException.class)
    public void when_schema_type_not_exist_then_throw_exception() {
        assertThat(Schema.of("vip")).isEqualTo(Schema.INTEGER);
    }
}