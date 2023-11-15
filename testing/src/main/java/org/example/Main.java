package org.example;

public class Main {
    public static void main(String[] args) {
        String credentialsPath = "/Users/mac/Desktop/UET/OOP/demo/src/main/resources/testapi-402514-71998670d628.json";

        GoogleTranslateService translator = new GoogleTranslateService(credentialsPath);

        String textToTranslate = "Hello, world!";
        String targetLanguage = "vi"; //

        String translatedText = translator.translateText(textToTranslate, targetLanguage);

        System.out.println(translatedText);
    }
}