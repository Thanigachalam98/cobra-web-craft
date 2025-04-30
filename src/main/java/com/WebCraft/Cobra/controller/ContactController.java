package com.WebCraft.Cobra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String contactForm() {
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(@RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String subject,
                                 @RequestParam String message) {
        // Here you can log, email, or save the message
        System.out.printf("New contact message from %s (%s): %s%n%s%n", name, email, subject, message);
        return "redirect:/contact?success";
    }
}

