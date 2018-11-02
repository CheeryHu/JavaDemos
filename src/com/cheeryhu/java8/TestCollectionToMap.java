package com.cheeryhu.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestCollectionToMap {

    public static void main(String[] args){
        List<Response> responseList = new ArrayList<>();
        Response r1 = new Response();
        r1.setDeptCode("755");
        r1.setDistCode(null);
        Response r2 = new Response();
        r2.setDeptCode(null);
        responseList.add(r1);
        responseList.add(r2);

        Map<String, String> responseMap = responseList.stream().filter(r -> r.getDeptCode() != null && r.getDistCode() != null).collect(Collectors.toMap(Response::getDeptCode, Response::getDistCode, (o1,o2)->o1));
        System.out.println(responseMap.size());
    }
}

class Response{
    private String deptCode;
    private String distCode;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDistCode() {
        return distCode;
    }

    public void setDistCode(String distCode) {
        this.distCode = distCode;
    }
}
