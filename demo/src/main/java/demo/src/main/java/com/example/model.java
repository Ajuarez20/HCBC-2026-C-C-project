package com.example;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class model {

    public static ChatLanguageModel chatbot = createChatbot();

    public static ChatLanguageModel createChatbot() {
        String apiKey = "AIzaSyDT-ruKgnyzA1YTBlGaEJQn7YRKZYNbUr8";

        return GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash")
                .build();
    }
}