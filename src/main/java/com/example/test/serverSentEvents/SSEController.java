package com.example.test.serverSentEvents;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Controller
public class SSEController {

    @RequestMapping("/sseEmitter")
    @ResponseBody
    public SseEmitter sseEmitterCall() {
        // SseEmitter用于异步返回多个结果，直到调用sseEmitter.complete()结束返回
        SseEmitter sseEmitter = new SseEmitter();
        Thread t = new Thread(new TestRun(sseEmitter));
        t.start();
        return sseEmitter;
    }

    @RequestMapping("/sse")
    public String sse(){
        return "sse";
    }

    class TestRun implements Runnable {
        private SseEmitter sseEmitter;
        private int times = 0;

        public TestRun(SseEmitter sseEmitter) {
            this.sseEmitter = sseEmitter;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("当前times=" + times);
                    sseEmitter.send(System.currentTimeMillis());
                    times++;
                    Thread.sleep(1000);
                    if (times > 4) {
                        System.out.println("发送finish事件");
                        sseEmitter.send(SseEmitter.event().name("finish").id("6666").data("哈哈"));
                        System.out.println("调用complete");
                        sseEmitter.complete();
                        System.out.println("complete！times=" + times);
                        break;
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
