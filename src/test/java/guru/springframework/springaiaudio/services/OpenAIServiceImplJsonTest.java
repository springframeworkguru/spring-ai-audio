package guru.springframework.springaiaudio.services;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by jt, Spring Framework Guru.
 */
@ActiveProfiles("json")
@SpringBootTest
public class OpenAIServiceImplJsonTest extends BaseTest {

    @Test //returns text
    void testJson() {

        val response = openAIService.getJson(file);

        System.out.println(response);

        assert isJSONValid(response);
    }

    @Test //returns text
    void testJson2() {

        val response = openAIService.getTranscript(file);

        System.out.println(response);

        assert isJSONValid(response);
    }
}
