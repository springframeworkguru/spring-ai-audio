package guru.springframework.springaiaudio.services;


import guru.springframework.springaiaudio.model.Question;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface OpenAIService {


    byte[] getSpeech(Question question);

    String getTranscript(MultipartFile file);
}

