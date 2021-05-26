package apollo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @className: KeyController
 * @package: apollo
 * @author: draven
 * @date: 2021/5/26 12:22
 */
@RestController
@RequestMapping("key")
public class KeyController {

    @Value("${demo}")
    private String keys;


    @GetMapping("getKeys")
    public String getKeys() {

        return keys;
    }


}
