package guru.springframework.springaiaudio.services;

import guru.springframework.springaiaudio.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.OpenAiAudioSpeechClient;
import org.springframework.ai.openai.OpenAiAudioSpeechOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.ai.openai.audio.speech.SpeechPrompt;
import org.springframework.ai.openai.audio.speech.SpeechResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jt, Spring Framework Guru.
 */
@RequiredArgsConstructor
@Service
public class OpenAIServiceImpl implements OpenAIService {

    private final OpenAiAudioSpeechClient speechClient;

    @Override
    public String getTranscript(MultipartFile file) {
        return "";
    }

    @Override
    public byte[] getSpeech(Question question) {
        OpenAiAudioSpeechOptions speechOptions = OpenAiAudioSpeechOptions.builder()
                .withVoice(OpenAiAudioApi.SpeechRequest.Voice.ALLOY)
                .withSpeed(1.0f)
                .withResponseFormat(OpenAiAudioApi.SpeechRequest.AudioResponseFormat.MP3)
                .withModel(OpenAiAudioApi.TtsModel.TTS_1.value)
                .build();

        SpeechPrompt speechPrompt = new SpeechPrompt(question.question(),
                speechOptions);

        SpeechResponse response = speechClient.call(speechPrompt);

        return response.getResult().getOutput();
    }
}



















