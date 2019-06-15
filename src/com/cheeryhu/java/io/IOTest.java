package com.cheeryhu.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class IOTest {

    public static void main(String[] args) throws IOException {

        // 输出字符
        InputStream inputStream = IOTest.class.getClassLoader().getResourceAsStream("input.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = null;
        StringBuilder sb = new StringBuilder();
        while ((s = bufferedReader.readLine()) != null){
//            System.out.println(s);
            sb.append(s);
        }
        String graphString = sb.toString();
        String[] paths = graphString.split(",");
        for(String path: paths){
            char[] pathInfo = path.toCharArray();
//            pathInfo[0];
//            pathInfo[1];
//            pathInfo[2];
        }



//        test1();
    }

    private static void test1() {
        try (InputStream inputStream = IOTest.class.getClassLoader().getResourceAsStream("input.txt")) {
            byte[] bytes = new byte[inputStream.available()];
            if (-1 != inputStream.read()) {
                String s = new String(bytes, Charset.forName("UTF-8"));
                System.out.println(s);
            }

        } catch (Exception e) {

        }
    }
}
