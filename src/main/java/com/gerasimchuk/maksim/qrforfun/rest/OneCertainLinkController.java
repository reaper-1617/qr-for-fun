package com.gerasimchuk.maksim.qrforfun.rest;


import com.gerasimchuk.maksim.qrforfun.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/link")
@RequiredArgsConstructor
public class OneCertainLinkController {

    private final ContentService contentService;

    @RequestMapping("/hhkjhvfsvdveuygvusyvefyusl")
    String getContent(Model model) {
        String message = contentService.generateResponse();
        model.addAttribute("message", message);
        return "certain_link_template.html";
    }

}
