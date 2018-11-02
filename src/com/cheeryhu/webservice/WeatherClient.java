package com.cheeryhu.webservice;

public class WeatherClient {
    public static void main(String[] args){
        WebServiceImplService service = new WebServiceImplService();

        WebServiceImpl port = service.getWebServiceImplPort();

        String weatherInfo = port.getWeatherByCity("北京");

        System.out.println(weatherInfo);
    }
}
