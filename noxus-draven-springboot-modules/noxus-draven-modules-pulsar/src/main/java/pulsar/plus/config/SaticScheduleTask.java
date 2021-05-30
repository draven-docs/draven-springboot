package pulsar.plus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.time.LocalDateTime;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {
    @Autowired
    private TestClass testClass;
    //3.添加定时任务
    //@Scheduled(cron = "0/30 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() throws IOException, InterruptedException {
        System.err.println("执行静态定时任务时间开始: " + LocalDateTime.now());
        //testClass.getTOrder1();
        testClass.sendClient();
        System.err.println("执行静态定时任务时间结束: " + LocalDateTime.now());
        Thread.sleep(5000);
        testClass.getClientList();
    }
}
