package com.example.Digital.library.Controller;

import com.example.Digital.library.Configuration.RedisConfig;
import com.example.Digital.library.Service.RedisServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class RedisController {


    private final RedisServices redisService;

    @Autowired
    public RedisController (RedisServices redisService){
        this.redisService =redisService;
    }

    @PostMapping("/save")
    public String save(@RequestParam String key, @RequestBody Object value) {
        redisService.save(key, value);
        return "Saved key: " + key;
    }

    @GetMapping("/get/{key}")
    public Object get(@PathVariable String key) {
        return redisService.get(key);
    }

    @DeleteMapping("/delete/{key}")
    public String delete(@PathVariable String key) {
        redisService.delete(key);
        return "Deleted key: " + key;
    }
}
