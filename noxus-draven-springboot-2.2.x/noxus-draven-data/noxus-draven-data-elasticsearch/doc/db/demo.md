# Elasticsearch

Head

IK分词

SpringDataElasticsearch

logstash完成mysql与Elasticsearch的同步工作









# FQA

```shell
failed to load elasticsearch nodes : org.elasticsearch.client.transport.NoNodeAvailableException: None of the configured nodes are available: [{#transport#-1}{PC0IP_QrRg2v1Q6zsCQWzQ}{116.196.77.250}{116.196.77.250:9300}]
```





```
cluster.name: "elasticsearch"
network.host: 0.0.0.0
network.bind_host: 0.0.0.0
network.publish_host: localhost
# http.port: 9200
# transport.tcp.port: 9300
http.cors.enabled: true
http.cors.allow-origin: "*"
node.master: true
node.data: true
```







首先先下载Kibana镜像（一定要对应的es版本）

```
docker pull docker.io/kibana:6.7.0
```

然后我们新建一个配置文件用来存储配置文件

```
mkdir -p /docker/kibana/conf
vim /docker/kibana/conf/kibana.yml
```

然后添加以下内容，下面的hosts地址修改为es地址

```
server.name: kibana
server.host: "0"
elasticsearch.hosts: [ "http://111.67.196.127:9200" ]
xpack.monitoring.ui.container.elasticsearch.enabled: true
```



```shell
docker run -d \
--name kibana6.8 \
-p 15601:5601 \
-v /docker/kibana/conf/kibana.yml:/usr/share/kibana/config/kibana.yml \
-e ELASTICSEARCH_URL=http://116.196.77.250:9200 docker.io/kibana:6.8.5




docker run -d \
--name kibana6.8 \
-p 5601:5601 \
docker.io/kibana:6.8.5
```











```
elasticsearch-plugin install https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v6.8.5/elasticsearch-analysis-ik-6.8.5.zip
```







```
http://111.67.196.127:9200/articleindex/
```









```shell
# 
docker pull docker.io/logstash:6.8.5

# 
docker pull docker.io/mysql:5.7.4




docker run -d --name logstash6.8 -v /docker/logstash/:/etc/logstash/pipeline/ docker.io/logstash:6.8.5

docker run -d --name logstash6.8 -v /docker/logstash/:/usr/share/logstash/pipeline/ docker.io/logstash:6.8.5

docker logs -f --tail=30 logstash6.8

docker exec -it logstash6.8 /bin/bash
bin/logstash-plugin install logstash-input-jdbc

bin/logstash-plugin install logstash-output-elasticsearch


/usr/share/logstash/pipeline

/usr/share/logstash/pipeline/logstash.conf

    input {
      beats {
        port => 5044
      }
    }

    output {
      stdout {
        codec => rubydebug
      }
    }
    
    
    
    
    
    
    
    
    
input {
 stdin { }
    jdbc {
        #注意mysql连接地址一定要用ip，不能使用localhost等
        jdbc_connection_string => "jdbc:mysql://116.196.77.250:3306/user"
        jdbc_user => "root"
        jdbc_password => "root"
        #这个jar包的地址是容器内的地址
        jdbc_driver_library => "/etc/logstash/pipeline/mysql-connector-java-8.0.15.jar
"
        jdbc_driver_class => "com.mysql.cj.jdbc.Driver"
        jdbc_paging_enabled => "true"
        jdbc_page_size => "50000"
        statement => "SELECT * FROM user"
        schedule => "* * * * *"
    }
 }
  
 output {
     stdout {
        codec => json_lines
    }
    elasticsearch {
        #注意mysql连接地址一定要用ip，不能使用localhost等
        hosts => "116.196.77.250:9200"
        index => "user"
        document_type => "_doc"
        document_id => "%{id}"
    }
}    

```



```
scp mysql-connector-java-8.0.15.jar root@116.196.77.250:/docker/logstash


/etc/logstash/pipeline/logstash.conf
```



































