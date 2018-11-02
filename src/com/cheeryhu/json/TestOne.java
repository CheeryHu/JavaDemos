package com.cheeryhu.json;

import net.sf.json.JSONObject;

public class TestOne {
    public static void main(String[] args){
        JSONObjectSample();
    }

    /**
     * {
     * 	"name":"Cheery Hu",
     * 	"age":25,
     * 	"birthday":"1993-10-26",
     * 	"school":"ccnu",
     * 	"major":["cs","english","math"],
     * 	"has_boyfriend":false,
     * 	"car":null,
     * 	"house":null
     * }
     */
    private static void JSONObjectSample() {
        JSONObject jsonObject = new JSONObject();
        Object nullObj = null;
        jsonObject.put("name","CheeryHu");
        jsonObject.put("age",25);
        jsonObject.put("major",new String[]{"cs","english","math"});
        jsonObject.put("car", nullObj);
        jsonObject.put("has_boyfriend", false);
        System.out.println(jsonObject.toString());
    }
}













