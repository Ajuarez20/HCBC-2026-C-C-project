package demo.src.main.java.com.example;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class model {

    public static ChatLanguageModel chatbot = createChatbot();

    public static ChatLanguageModel createChatbot() {
        String apiKey = "AIzaSyAwFBVl73nze3EB3j5E6gRIfR7xNt67F44";

        return GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash")
                .build();
    }
}