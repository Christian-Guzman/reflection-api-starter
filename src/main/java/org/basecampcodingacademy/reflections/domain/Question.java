package org.basecampcodingacademy.reflections.domain;


public class Question {
    public Integer id;
    public String prompt;
    public Integer reflectionId; // You will have to change this line eventually

    public Question() {}

    public Question(Integer id, String prompt, Integer reflectionId) {
        this.id = id;
        this.prompt = prompt;
        this.reflectionId = reflectionId;
    }
}
