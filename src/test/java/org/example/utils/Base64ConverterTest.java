package org.example.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Base64ConverterTest {


    @Test
    void encodeToBase64() {
        String result = Base64Converter.encodeToBase64("testtest");
        Assertions.assertThat(result).isEqualTo("dGVzdHRlc3Q=");
    }
}