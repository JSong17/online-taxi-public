package com.mashibing.serviceDriverUser.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/*
 *@author js
 *@version 1.0
 */
public class MysqlGenerator {

    public static void main(String[] args) {

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/service-driver-user?characterEncoding=utf-8&serverTimezone=Asia/Shanghai",
                "root", "hsp")
                .globalConfig(builder -> {
                    builder.author("js").fileOverride().outputDir("D:\\java\\gittest\\online-taxi-public\\service-driver-user\\src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.mashibing.serviceDriverUser").pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                            "D:\\java\\gittest\\online-taxi-public\\service-driver-user\\src\\main\\java\\com\\mashibing\\serviceDriverUser\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("driver_user_work_status");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
