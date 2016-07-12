package com.cppba.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class StringToObject {
    public static void main(String[] args) throws IOException {
        String jsonString = "{\"id\":\"1\",\"name\":\"bigbeef\",\"list\":[{\"str\":\"str1\",\"integer\":\"1\"}," +
                "{\"str\":\"str2\",\"integer\":\"2\"}]}";
        ObjectMapper objectMapper = new ObjectMapper();
        MyObject myObject = objectMapper.readValue(jsonString, MyObject.class);
        System.out.println(myObject.toString());
    }
}

class MyObject{
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("list")
    private List<MyListProject> list;

    @Override
    public String toString() {
        return "MyObject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}

class MyListProject{
    @JsonProperty("str")
    private String str;
    @JsonProperty("integer")
    private Integer integer;
    @Override
    public String toString() {
        return "MyListProject{" +
                "str='" + str + '\'' +
                ", integer=" + integer +
                '}';
    }
}
