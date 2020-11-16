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
public class GsonJson {


   *//* private final ObjectMapper objectMapper;

    public GsonJson(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }*//*


    @GetMapping("/GjsonMono")
    public Mono<String> GjsonMono(@RequestBody UserJson jsons) throws JsonProcessingException {
        //String username,String password
        //String jsons = "{" + "username" + ":" + "haha" + "," + " password " + ":" + "pass" + "}";
        Gson gson = new Gson();
        String s = gson.toJson(jsons);
        log.info("{}", s);
        return Mono.just(s);
    }
}*/
