package tdd.args;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Simon
 * @date 2020/8/31 08:56
 */
public class ArgsMarshallerTest {
    @Test
    public void should_get_sub_marshaller_by_schema() {
        ArgsMarshaller stringMarshaller = ArgsMarshaller.of(Schema.STRING);
        assertThat(stringMarshaller).isInstanceOf(StringArgsMarshaller.class);
        ArgsMarshaller integerMarshaller = ArgsMarshaller.of(Schema.INTEGER);
        assertThat(integerMarshaller).isInstanceOf(IntegerArgsMarshaller.class);
        ArgsMarshaller booleanMarshaller = ArgsMarshaller.of(Schema.BOOLEAN);
        assertThat(booleanMarshaller).isInstanceOf(BooleanArgsMarshaller.class);
    }

    @Test
    public void when_string_arg_then_get_string_value() {
        ArgsMarshaller stringMarshaller = ArgsMarshaller.of(Schema.STRING);
        stringMarshaller.setValue("abc");
        assertThat(stringMarshaller.getValue()).isEqualTo("abc");
    }

    @Test
    public void when_integer_arg_then_get_integer_value() {
        ArgsMarshaller marshaller = ArgsMarshaller.of(Schema.INTEGER);
        marshaller.setValue("8080");
        assertThat(marshaller.getValue()).isEqualTo(8080);
    }

    @Test
    public void when_boolean_arg_then_get_boolean_value() {
        ArgsMarshaller marshaller = ArgsMarshaller.of(Schema.BOOLEAN);
        marshaller.setValue("true");
        assertThat(marshaller.getValue()).isEqualTo(true);
        marshaller.setValue("false");
        assertThat(marshaller.getValue()).isEqualTo(false);
        marshaller.setValue(null);
        assertThat(marshaller.getValue()).isEqualTo(true);
    }

    @Test
    public void when_no_input_arg_then_get_default_value() {
        ArgsMarshaller stringMarshaller = ArgsMarshaller.of(Schema.STRING);
        assertThat(stringMarshaller.getValue()).isEqualTo("");
        ArgsMarshaller integerMarshaller = ArgsMarshaller.of(Schema.INTEGER);
        assertThat(integerMarshaller.getValue()).isEqualTo(0);
        ArgsMarshaller booleanMarshaller = ArgsMarshaller.of(Schema.BOOLEAN);
        assertThat(booleanMarshaller.getValue()).isEqualTo(false);
    }
}
