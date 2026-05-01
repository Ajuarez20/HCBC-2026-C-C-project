package com.example;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class model{

    public static void main(String[] args){
    
        ChatLanguageModel model = GoogleAiGeminiChatModel.builder()
            .apiKey("AIzaSyBWfhwH32npKjUFsyqPycKCdZem2CCpnM0")
            .modelName("gemini-2.5-flash")
            .build();
        
        String response = model.chat("Are mexicans sexy");

        System.out.println(response);
    }


}