package com.qbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassNme BaseAdminApplication
 * @Description　実行クラス、入り口メソッド、プログラム実行できます。
 * @Author chenpei
 * @Date 2024/09/07 17:27
 * @Version 1.0
 **/
@SpringBootApplication
public class BaseAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseAdminApplication.class, args);
    }
}

@Slf4j
@Configuration
class IndexController {


}
