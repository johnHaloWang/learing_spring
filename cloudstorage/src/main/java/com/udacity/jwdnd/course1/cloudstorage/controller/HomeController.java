package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.services.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
//    private NoteService noteService;
//    private CredentialService credentialService;

    @Autowired
    private EncryptionService encryptionService;

    public HomeController(UserService userService, EncryptionService encryptionService) {
        this.userService = userService;
        this.encryptionService = encryptionService;
    }

    @GetMapping(value = {"/", "/home"})
    public String homeView(Authentication authentication, Model model, HttpSession session){
        Integer userId = null;
        if(session.getAttribute("userId") == null){
            String username = authentication.getName();
            userId = Integer.valueOf(userService.getUser(username).getUserId());
            session.setAttribute("userId", userId);
        }else{
            userId = Integer.valueOf((int)session.getAttribute("userId"));
        }

//        List<Note> notes = noteService.getAllUserName(userId.intValue());
//        List<Credential> credentials = credentialService.getAllUserCredentials(userId.intValue());
        model.addAttribute("enS", encryptionService);
//        model.addAttribute("noteList", notes);
//        NoteForm noteForm = new NoteForm();
//        model.addAttribute("noteForm", noteForm);
        return "home";
    }
}
