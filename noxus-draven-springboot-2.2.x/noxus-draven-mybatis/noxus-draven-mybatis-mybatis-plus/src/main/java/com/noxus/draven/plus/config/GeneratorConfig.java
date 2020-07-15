package com.noxus.draven.plus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class GeneratorConfig {
    public static void main(String[] args) {
        getAutoGenerator();
    }


    public static void getAutoGenerator() {

        // 一、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 二、全局配置
        GlobalConfig gc = new GlobalConfig();
        // 全局父路径
        String projectPath = System.getProperty("user.dir");
        // 生成路径(文件输出路径)
        gc.setOutputDir(projectPath + "/src/main/java");
        // 重新生成时文件是否覆盖
        gc.setFileOverride(true);
        // 生成后是否打开资源管理器 方便定位
        gc.setOpen(false);
        // 是否在xml中添加二级缓存配置
        gc.setEnableCache(false);
        //作者信息
        gc.setAuthor("draven");

        // 开启 Kotlin 模式
        gc.setKotlin(false);
        // 开启Swagger2模式
        // gc.setSwagger2(true);
        // 开启ActiveRecord 模式
        gc.setActiveRecord(false);
        // 开启 BaseResultMap
        gc.setBaseResultMap(true);
        //  开启baseColumnList
        gc.setBaseColumnList(true);
        // 间类型对应策略
        // ONLY_DATE,SQL_PACK,TIME_PACK;
        // gc.setDateType();

        // 主键策略
        //gc.setIdType(IdType.ID_WORKER);
        // 设置类命名
        // gc.setEntityName("%sEntity");
        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        // 此配置不生效
        // gc.setServiceName("%sBusinessImpl");
        // gc.setControllerName("%sAction");
        gc.setServiceName("%sService"); //去掉Service接口的首字母I
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        mpg.setGlobalConfig(gc);


        // 三、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        // H2数据库
/*        dsc.setDriverName("org.h2.Driver");
        dsc.setUrl("jdbc:h2:mem:activiti");
        dsc.setDbType(DbType.H2);
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);*/

        // MySQL
        // 8.0
        //dsc.setTypeConvert();
        //dsc.setSchemaName();
        //dsc.setIDbQuery();

        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://116.196.77.250:3306/tensquare_user");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        //7.0
/*      dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);*/


        // 四、包配置
        PackageConfig pc = new PackageConfig();
        // 目录的路径
        pc.setParent("com.noxus.draven");
        // 区分模块名
        pc.setModuleName("plus");
        // web
        pc.setController("controller");
        // entity
        pc.setEntity("entity");
        // service
        pc.setService("service");
        // mapper
        pc.setMapper("mapper");
        // xml包名
        // pc.setXml("");
        // 路径配置信息赋值
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();

        //strategy.isCapitalMode();
        // 数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // setInclude(scanner("表名，多个英文逗号分割").split(","))
        // 只有该表生成
        //strategy.setInclude("user");
        // 只有该表不生成
        strategy.setExclude("permission");

        strategy.setFieldPrefix("info");

        // 生成实体时去掉表前缀
        strategy.setTablePrefix(pc.getModuleName() + "_");
        // 数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setEntityLombokModel(true);
        // restful api风格控制器
        strategy.setRestControllerStyle(true);
        // url中驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        // 是否生成实体时，生成字段注解
        // strategy.entityTableFieldAnnotationEnable(true);
        // 逻辑删除属性名称

        // strategy.setLogicDeleteFieldName("pname");
        mpg.setStrategy(strategy);
        // 若使用了非默认模版
        // mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        // 6、执行
        mpg.execute();
    }
}
