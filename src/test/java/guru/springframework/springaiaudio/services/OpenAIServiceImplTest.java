package guru.springframework.springaiaudio.services;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenAIServiceImplTest extends BaseTest {

    @Test // expected srt, but return text
    void testAsSrt() {
        val response = openAIService.getTranscript(file);

        System.out.println(response);

        assert isSrtValid(response);
    }

    @Test // expected json, but return text
    void testJson() {

        val response = openAIService.getJson(file);

        System.out.println(response);

        assert isJSONValid(response);
    }


}