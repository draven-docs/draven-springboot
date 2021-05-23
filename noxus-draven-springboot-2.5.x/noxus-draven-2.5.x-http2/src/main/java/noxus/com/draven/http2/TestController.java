package noxus.com.draven.http2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈功能概述〉<br>
 *
 * @className: TestController
 * @package: noxus.com.draven.prefix
 * @author: draven
 * @date: 2021/5/22 21:03
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping("/get")
    public String get(HttpServletRequest request){
        String protocol = request.getProtocol();
        return "12345";
    }
}
