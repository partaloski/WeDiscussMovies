//package com.wediscussmovies.project.web.controller;
//
//import com.wediscussmovies.project.model.PasswordEncoder;
//import com.wediscussmovies.project.model.*;
//import com.wediscussmovies.project.model.exception.InvalidUserCredentialsException;
//import com.wediscussmovies.project.service.UserService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpServletRequest;
//import java.security.NoSuchAlgorithmException;
//import java.util.Optional;
//
//@Controller
//public class UsersController{
//    private final UserService userService;
//
//    public UsersController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/login")
//    public String getLoginPage(Model model){
//        return "login";
//    }
//
//    @PostMapping("/login/confirm")
//    public String confirmLogin(HttpServletRequest request, Model model,
//                               @RequestParam String username,
//                               @RequestParam String password){
//        Optional<User> user;
//        try{
//            password = PasswordEncoder.getEncodedPasswordString(password);
//        }
//        catch (NoSuchAlgorithmException ex){
//            model.addAttribute("hasError", true);
//            model.addAttribute("error", ex.getMessage());
//            return "login";
//        }
//
//        try{
//            user = this.userService.login(username, password);
//            request.getSession().setAttribute("user", user);
//            request.getSession().setAttribute("loggedIn",true);
//            return "redirect:/movies";
//        }
//        catch (InvalidUserCredentialsException ex){
//            model.addAttribute("hasError", true);
//            model.addAttribute("error", ex.getMessage());
//            return "login";
//        }
//    }
//
//    @GetMapping("/register")
//    public String getRegisterPage(){
//        return "register";
//    }
//
//    @PostMapping("/login/confirm")
//    public String confirmRegister(HttpServletRequest request,
//                                  @RequestParam String username,
//                                  @RequestParam String email,
//                                  @RequestParam String password,
//                                  @RequestParam String confirmPassword,
//                                  @RequestParam String name,
//                                  @RequestParam String surname){
//        Optional<User> user;
//
//        try{
//            password = PasswordEncoder.getEncodedPasswordString(password);
//            confirmPassword = PasswordEncoder.getEncodedPasswordString(confirmPassword);
//        }
//        catch (NoSuchAlgorithmException ex){
//            request.getSession().setAttribute("error", "Contact the administrators!");
//            request.getSession().setAttribute("hasError", "true");
//            return "redirect:/movies";
//        }
//
//        user = this.userService.register(request, email, password, confirmPassword, username, name, surname);
//        if(user.isEmpty()){
//            request.setAttribute("hasError", "true");
//        }else{
//            request.getSession().setAttribute("hasError", "false");
//            request.getSession().setAttribute("user", user.get());
//            request.getSession().setAttribute("loggedIn",true);
//        }
//        return "redirect:/movies";
//    }
//
//    @GetMapping
//    public String logout(HttpServletRequest request){
//        request.getSession().invalidate();
//        return "redirect:/login";
//    }
//}
