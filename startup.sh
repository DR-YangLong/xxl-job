#!/bin/bash -f
echo "starting by docker-compose"
echo "package project"
mvn clean install
echo "create docker network"
docker network create job_net
echo "start mariaDB"
docker-compose -f docker-compose-mysql.yml up -d
sleep 20
echo "start admin nodes"
docker-compose -f docker-compose-admin.yml up -d
sleep 15
echo "start openresty"
docker-compose -f docker-compose-openresty.yml up -d
sleep 10
echo "commands executed,please visit 127.0.0.1/xxl-job-admin"