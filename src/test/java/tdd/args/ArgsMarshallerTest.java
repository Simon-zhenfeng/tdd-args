package tdd.args;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsMarshallerTest {

    @Test
    public void should_create_marshaller_by_schema() {
        ArgsMarshaller stringMarshaller = ArgsMarshaller.of(Schema.STRING);
        assertThat(stringMarshaller).isInstanceOf(StringArgsMarshaller.class);
        ArgsMarshaller integerMarshaller = ArgsMarshaller.of(Schema.INTEGER);
        assertThat(integerMarshaller).isInstanceOf(IntegerArgsMarshaller.class);
        ArgsMarshaller booleanMarshaller = ArgsMarshaller.of(Schema.BOOLEAN);
        assertThat(booleanMarshaller).isInstanceOf(BooleanArgsMarshaller.class);
    }
}