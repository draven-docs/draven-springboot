package com.noxus.draven.jsons;

/**
 * 〈功能概述〉<br>
 *
 * @className: JacksonJson
 * @package: com.noxus.draven.jsons
 * @author: draven
 * @date: 2020/11/11 16:46
 */
/*@RestController
@RequestMapping
@Slf4j
public class JacksonJson {


    private final ObjectMapper objectMapper;

    public JacksonJson(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @GetMapping("/jacksonJsonMono")
    public Mono<String> jacksonJsonMono(@RequestBody UserJson jsons) throws JsonProcessingException {
        //String username,String password
        //String jsons = "{" + "username" + ":" + "haha" + "," + " password " + ":" + "pass" + "}";
        String u = objectMapper.writeValueAsString(jsons);
        log.info("{}",u);
        return Mono.just(u);
    }
}*/
