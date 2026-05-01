package com.example;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class model {

    public static ChatLanguageModel chatbot = createChatbot();

    public static ChatLanguageModel createChatbot() {
        String apiKey = "AIzaSyB4ELWuuVq8ZS6no8EHuR3T7QPSFwdigVE";

        return GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash")
                .build();
    }
}