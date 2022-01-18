package com.wediscussmovies.project.web.controller;

import com.wediscussmovies.project.service.ReplyService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class ReplyController {
    private final ReplyService replyService;

    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @GetMapping("/edit/{id}")
    public String getReplyEdit(@PathVariable Integer id, Model model){
        Optional<Reply> reply = replyService.findById(id);
        if(reply.isEmpty())
            return "redirect:/movies";
        model.addAttribute("reply", reply.get());
        model.addAttribute("templateContext", "replyEdit");
        return "template";
    }

    @PostMapping("/edit/confirm/{id}")
    public String getReplyEdit(@PathVariable Integer id, @RequestParam String text){
        Optional<Reply> replyOp = replyService.findById(id);
        if(replyOp.isEmpty())
            return "redirect:/discussions";
        Reply reply = replyOp.get();
        replyService.delete(reply);
        reply.setText(text);
        replyService.save(reply);
        return "redirect:/discussions/"+reply.getDiscussion().getDiscussion_id();
    }
}
