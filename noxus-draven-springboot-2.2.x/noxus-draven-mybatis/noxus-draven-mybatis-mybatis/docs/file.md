
[root@JD mysql]# docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=root --privileged=true -v /docker/mysql/data:/var/lib/mysql -v /docker/mysql/conf/my.cnf:/etc/mysql/conf.d/mysql.cnf -d docker.io/mysql:8.0.16




