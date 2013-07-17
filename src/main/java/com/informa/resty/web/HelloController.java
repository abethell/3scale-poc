package com.informa.resty.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import threescale.v3.api.AuthorizeResponse;
import threescale.v3.api.ParameterMap;
import threescale.v3.api.ServerError;
import threescale.v3.api.ServiceApi;
import threescale.v3.api.impl.ServiceApiDriver;

/**
 * Created by bethella on 16/07/13.
 */
@Controller
@RequestMapping( value = "foo" )
public class HelloController {

    @RequestMapping( method = RequestMethod.GET )
    @ResponseBody
    public String getHello(@RequestParam String appId, @RequestParam String apiKey){

        // todo maybe this could be done with Spring Security - with a custom filter?

        // Create the API object
        ServiceApi serviceApi = new ServiceApiDriver("807a572274720708ece7deca0de53b76");


        ParameterMap params = new ParameterMap();      // the parameters of your call
        params.add("app_id", appId);           // Add app_id of your application for authorization
        params.add("app_key", apiKey);         // Add app_key of your application for authorization
  //      params.add("service_id", "hello"); // Add the service id of your application


        ParameterMap usage = new ParameterMap(); // Add a metric to the call
        usage.add("hits", "1");
        params.add("usage", usage);              // metrics belong inside the usage parameter

        AuthorizeResponse response = null;
        // the 'preferred way' of calling the backend: authrep
        try {
            response = serviceApi.authrep(params);
            System.out.println("AuthRep on App Id Success: " + response.success());
            if (response.success() == true) {
                // your api access got authorized and the  traffic added to 3scale backend
                System.out.println("Plan: " + response.getPlan());


            } else {
                // your api access did not authorized, check why
                System.out.println("Error: " + response.getErrorCode());
                System.out.println("Reason: " + response.getReason());

                return null;
            }
        } catch (ServerError serverError) {
            serverError.printStackTrace();

            return null;
        }





        return "HEY THERE";
    }

}
