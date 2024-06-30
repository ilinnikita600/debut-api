package org.example.config.feign;

import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterCandidateConfig {

    @Bean
    public Decoder feignDecoder() {
        return new JacksonDecoder();
    }
}
