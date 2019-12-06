call install.bat
echo "starting by docker-compose"
echo "create docker network"
docker network create job_net
echo "start mariaDB"
docker-compose -f docker-compose-mysql.yml up -d
timeout /T 20 /NOBREAK
echo "start admin nodes"
docker-compose -f docker-compose-admin.yml up -d
timeout /T 30 /NOBREAK
echo "start openresty"
docker-compose -f docker-compose-openresty.yml up -d
timeout /T 20 /NOBREAK
echo "commands executed"
start  http://127.0.0.1/xxl-job-admin/toLogin
