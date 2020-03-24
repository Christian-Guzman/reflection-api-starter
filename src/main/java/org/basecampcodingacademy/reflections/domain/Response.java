package org.basecampcodingacademy.reflections.domain;
import java.util.List;

public class Response {
    public Integer id;
    public Integer reflectionId;
    public String username;
    public List<Object> answers;

    public Response() {}

    public Response(Integer id, Integer reflectionId, String username, List<Object> answers){
        this.id = id;
        this.reflectionId = reflectionId;
        this.username = username;
        this.answers = answers;
    }
}

