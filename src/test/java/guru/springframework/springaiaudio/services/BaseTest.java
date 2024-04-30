package guru.springframework.springaiaudio.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by jt, Spring Framework Guru.
 */
public class BaseTest {
    @Autowired
    OpenAIServiceImpl openAIService;

    @Value("classpath:/SpringBootProjectReview_01.mp3")
    Resource mp3;

    MultipartFile file;

    @BeforeEach
    void setUp() throws IOException {
        file = new MockMultipartFile(mp3.getFilename(), mp3.getInputStream());
    }

    public static boolean isJSONValid(String jsonInString ) {
        try {
            final ObjectMapper mapper = new ObjectMapper().enable(DeserializationFeature.FAIL_ON_TRAILING_TOKENS);
            val jsonNode = mapper.readTree(jsonInString);

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean isSrtValid(String srt) {
        //get first line of string
        String[] lines = srt.split("\\r?\\n");
        String firstLine = lines[0];

        return StringUtils.isNumeric(firstLine);
    }
}
