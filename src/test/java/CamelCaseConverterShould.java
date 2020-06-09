import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CamelCaseConverterShould {
    /*
        TODO LIST:
            - "" -> ""
            - hola -> hola
            - hola_amigo -> holaAmigo
            - hola-amigo -> holaAmigo
            - hola;amigo -> hola;amigo
            - Hola-amigo -> HolaAmigo
            - hola-amigo-ketal ->holaAmigoKetal
            - hola_amigo-ketal -> hola_amigo-ketal
     */

    private CamelCaseConverter camelCaseConverter;

    @BeforeEach
    public void initializeInstance(){
        camelCaseConverter = new CamelCaseConverter();
    }

    @Test
    public void return_empty_string_when_empty_input_provided(){
        assertThat(camelCaseConverter.parse("")).isEqualTo("");
    }

    @Test
    public void return_same_value_when_one_word_provided(){
        assertThat(camelCaseConverter.parse("hola")).isEqualTo("hola");
    }

    @Test
    public void return_parsed_text_to_camel_case_when_underscore_provided_as_delimiter(){
        assertThat(camelCaseConverter.parse("hola_amigo")).isEqualTo("holaAmigo");
    }

    @Test
    public void return_parsed_text_to_camel_case_when_dash_provided_as_delimiter(){
        assertThat(camelCaseConverter.parse("hola-amigo")).isEqualTo("holaAmigo");
    }

    @Test
    public void return_parsed_text_to_camel_case_when_several_words_provided(){
        assertThat(camelCaseConverter.parse("hola-amigo-ketal")).isEqualTo("holaAmigoKetal");
    }
}
