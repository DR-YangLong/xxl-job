echo "close all container"
docker-compose -f docker-compose-openresty.yml down
docker-compose -f docker-compose-admin.yml down
docker-compose -f docker-compose-mysql.yml down
echo "remove network"
docker network remove job_net
echo "all jod done,bye bye!"