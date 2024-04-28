package guru.springframework.springaiaudio.controllers;


import guru.springframework.springaiaudio.model.Question;
import guru.springframework.springaiaudio.services.OpenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by jt, Spring Framework Guru.
 */
@RequiredArgsConstructor
@RestController
public class QuestionController {

    private final OpenAIService openAIService;

    @PostMapping(value = "/file", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, String>> upload(
            @Validated @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name
    ) {

        Map<String, String> response = Map.of("response", openAIService.getTranscript(file));

        return ResponseEntity.ok(response);
    }

    @PostMapping(value ="/talk", produces = "audio/mpeg")
    public byte[] talkTalk(@RequestBody Question question) {
        return openAIService.getSpeech(question);
    }
}
