package org.example.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.deserializers.RoleEnumDeserializer;
import org.example.serializers.RoleEnumSerializer;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
@JsonSerialize(using = RoleEnumSerializer.class)
@JsonDeserialize(using = RoleEnumDeserializer.class)
public enum Role {
    SYSTEMS_ANALYST("Системный аналитик"),
    JAVA_DEVELOPER("Разработчик Java"),
    JS_OR_REACT_DEVELOPER("Разработчик JS/React"),
    TESTER("Тестировщик"),
    APPLICATION_ADMIN("Прикладной администратор");

    private final String name;

    public static Role getByName(String name) {
        return Arrays.stream(Role.values()).filter(role -> role.getName().equals(name)).findFirst().orElseThrow();
    }
}
