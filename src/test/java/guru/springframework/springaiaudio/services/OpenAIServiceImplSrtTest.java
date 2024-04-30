package guru.springframework.springaiaudio.services;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by jt, Spring Framework Guru.
 */
@ActiveProfiles("srt")
@SpringBootTest
public class OpenAIServiceImplSrtTest extends BaseTest {
    @Test //works as expected, returns srt format
    void testAsSrt() {
        val response = openAIService.getTranscript(file);

        System.out.println(response);

        assert isSrtValid(response);
    }

    @Test // Also returns SRT, even though options are set to JSON
    void testAsJson() {
        val response = openAIService.getJson(file);

        System.out.println(response);

        assert isJSONValid(response);
    }
}
