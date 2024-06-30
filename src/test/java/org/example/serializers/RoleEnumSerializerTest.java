package org.example.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.assertj.core.api.Assertions;
import org.example.domain.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class RoleEnumSerializerTest {

    @Mock
    private JsonGenerator jsonGenerator;
    @Mock
    private SerializerProvider serializerProvider;
    private String result;
    private final RoleEnumSerializer serializer = new RoleEnumSerializer();

    @BeforeEach
    public void setUp() throws IOException {
        jsonGenerator = mock(JsonGenerator.class);
        doAnswer((ans) -> {
            result = ans.getArgument(0);
            return ans;
        }).when(jsonGenerator).writeString(any(String.class));
    }

    @Test
    void serializeSystemsAnalyst() throws IOException {
        Role role = Role.SYSTEMS_ANALYST;
        serializer.serialize(role, jsonGenerator, serializerProvider);
        Assertions.assertThat(result).isEqualTo("Системный аналитик");
    }

    @Test
    void serializeJavaDeveloper() throws IOException {
        Role role = Role.JAVA_DEVELOPER;
        serializer.serialize(role, jsonGenerator, serializerProvider);
        Assertions.assertThat(result).isEqualTo("Разработчик Java");
    }
}