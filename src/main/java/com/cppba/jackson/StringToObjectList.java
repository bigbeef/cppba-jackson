package com.cppba.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class StringToObjectList {
    public static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        String jsonStr = "[{\"id\":\"1\",\"values\":[\"1\",\"2\"]},{\"id\":\"2\",\"values\":[\"11\",\"22\"]}]";
        JsonArrayToList[] jsonArrayToList = objectMapper.readValue(jsonStr, JsonArrayToList[].class);
        for (JsonArrayToList jatl : jsonArrayToList) {
            System.out.println(jatl.toString());
        }
    }
}

class JsonArrayToList {
    @JsonProperty("id")
    private String id;

    @JsonProperty("values")
    private List<Integer> values;

    @Override
    public String toString() {
        return "JsonArrayToList{" +
                "id='" + id + '\'' +
                ", values=" + values +
                '}';
    }
}

/*public class StringToObject {
    public static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        String jsonStr = "[{\"id\":\"1\",\"values\":[\"1\",\"2\"]},{\"id\":\"2\",\"values\":[\"11\",\"22\"]}]";
        JavaType javaType = getCollectionType(ArrayList.class, JsonArrayToList.class);
        List<JsonArrayToList> list = objectMapper.readValue(jsonStr, javaType);
        for (JsonArrayToList jatl : list) {
            System.out.println(jatl.toString());
        }
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}

class JsonArrayToList {
    @JsonProperty("id")
    private String id;

    @JsonProperty("values")
    private List<Integer> values;

    @Override
    public String toString() {
        return "JsonArrayToList{" +
                "id='" + id + '\'' +
                ", values=" + values +
                '}';
    }
}*/

