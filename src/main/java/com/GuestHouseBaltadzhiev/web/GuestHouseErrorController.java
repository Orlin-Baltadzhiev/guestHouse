package com.GuestHouseBaltadzhiev.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class GuestHouseErrorController implements ErrorController {


    @RequestMapping("/error")
    public String handleErrors(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if(status !=null){
            Integer statusCode = Integer.valueOf(status.toString());

                if(statusCode == HttpStatus.NOT_FOUND.value()){
                    return "error404";
                }

        }

        return "errors";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
