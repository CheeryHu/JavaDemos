package com.cheeryhu.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WebServiceI {

    public String getWeatherByCity(String city);

}
