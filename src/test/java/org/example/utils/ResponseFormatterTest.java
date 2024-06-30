package org.example.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ResponseFormatterTest {

    @Test
    void removeEndQuotesAndLeadingSpacesWhenNull() {
        String input = null;

        String result = ResponseFormatter.removeEndQuotesAndLeadingSpaces(input);

        Assertions.assertThat(result).isEqualTo(input);
    }

    @Test
    void removeEndQuotesAndLeadingSpacesWhenEmptyString() {
        String input = "";

        String result = ResponseFormatter.removeEndQuotesAndLeadingSpaces(input);

        Assertions.assertThat(result).isEqualTo(input);
    }

    @Test
    void removeEndQuotesAndLeadingSpacesWhenStringWithoutQuotes() {
        String input = "testtest22";

        String result = ResponseFormatter.removeEndQuotesAndLeadingSpaces(input);

        Assertions.assertThat(result).isEqualTo(input);
    }

    @Test
    void removeEndQuotesAndLeadingSpacesWhenStringWithQuotesEndSpaces() {
        String input = "   \"\"\"testtest22\"\"";

        String result = ResponseFormatter.removeEndQuotesAndLeadingSpaces(input);

        Assertions.assertThat(result).isEqualTo("testtest22");
    }
}