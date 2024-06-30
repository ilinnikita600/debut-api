package org.example.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.assertj.core.api.Assertions;
import org.example.domain.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.example.domain.Role.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoleEnumDeserializerTest {
    @Mock
    private JsonParser jsonParser;
    @Mock
    private DeserializationContext deserializationContext;
    private final RoleEnumDeserializer deserializer = new RoleEnumDeserializer();

    @Test
    void deserializeSystemsAnalyst() throws IOException {
        when(jsonParser.readValueAs(String.class)).thenReturn("Прикладной администратор");

        Role result = deserializer.deserialize(jsonParser, deserializationContext);

        Assertions.assertThat(result).isEqualTo(APPLICATION_ADMIN);
    }

    @Test
    void deserializeJavaDeveloper() throws IOException {
        when(jsonParser.readValueAs(String.class)).thenReturn("Разработчик Java");

        Role result = deserializer.deserialize(jsonParser, deserializationContext);

        Assertions.assertThat(result).isEqualTo(JAVA_DEVELOPER);
    }
}