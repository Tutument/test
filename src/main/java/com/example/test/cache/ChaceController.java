package com.example.test.cache;

import org.infinispan.manager.EmbeddedCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/say")
public class ChaceController {
    @Autowired
    EmbeddedCacheManager cacheManager;

    @RequestMapping("/cache")
    @ResponseBody
    public void testCache(){

        cacheManager.getCache("testCache").put("testKey", "testValue");
        System.out.println("Received value from cache: " + cacheManager.getCache("testCache").get("testKey"));
    }
}
