package com.example;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

public class model{

    public static void main(String[] args){
        
        ChatLanguageModel model = OpenAiChatModel.builder()
        .apiKey("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")
        .modelName("gpt-4o-mini")
        .build();


        String response = model.generate("Explain inheritance in Java");
        System.out.println(response);
    }
}