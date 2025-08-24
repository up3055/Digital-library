package com.example.Digital.library.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {


    @GetMapping("/login")
    public String welcomeMessage(HttpServletRequest request){
        return "Welcome to Digital Library" + request.getSession().getId();
    }

//    @GetMapping("/crsf")
//    public CsrfToken getCrsfToken(HttpServletRequest request){
//        return (CsrfToken) request.getAttribute("_csrf");
//    }


}
