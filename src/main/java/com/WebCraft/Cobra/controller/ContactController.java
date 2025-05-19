package com.WebCraft.Cobra.controller;

import com.WebCraft.Cobra.model.ContactMessage;
import com.WebCraft.Cobra.repository.ContactRepository;
import com.WebCraft.Cobra.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private MailService mailService;

    @GetMapping("/contact")
    public String contactForm() {
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(@RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String subject,
                                 @RequestParam String message) {

        // Save to DB
        ContactMessage contactMessage = new ContactMessage(name, email, subject, message);
        contactRepository.save(contactMessage);

        // Send email
        String content = String.format("Name: %s\nEmail: %s\nSubject: %s\nMessage:\n%s",
                name, email, subject, message);

        mailService.sendContactNotification(
                "thani1998chalam@gmail.com",
                "New Contact Form Submission",
                content
        );

        return "redirect:/contact?success";
    }
}
