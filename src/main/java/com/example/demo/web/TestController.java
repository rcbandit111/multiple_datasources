package com.example.demo.web;

import com.example.demo.config.TxPrimary;
import com.example.demo.config.TxSecond;
import org.springframework.web.bind.annotation.*;
import com.example.demo.primary.repo.UserPrimaryRepo;
import com.example.demo.secondary.repo.UserSecondaryRepo;

@RestController
@RequestMapping("/test")
public class TestController {

    private final UserPrimaryRepo p;
    private final UserSecondaryRepo s;

    public TestController(UserPrimaryRepo p, UserSecondaryRepo s) {
        this.p = p;
        this.s = s;
    }

    @PostMapping("/primary")
    @TxPrimary
    public Object saveP(@RequestParam String name) {
        var u = new com.example.demo.primary.entity.UserPrimary();
        u.setName(name);
        return p.save(u);
    }

    @PostMapping("/secondary")
    @TxSecond
    public Object saveS(@RequestParam String desc) {
        var u = new com.example.demo.secondary.entity.UserSecondary();
        u.setDescription(desc);
        return s.save(u);
    }
}
