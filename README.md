sudo apt-get install postgresql
/etc/init.d/postgresql status # check if postgresql has been installed
sudo -u postgres createuser --interactive --password technocrats

Shall the new role be a superuser? (y/n) n
Shall the new role be allowed to create databases? (y/n) y
Shall the new role be allowed to create more new roles? (y/n) n
Password: C8BxprLB

sudo -u postgres createdb moviesdb -O technocrats
sudo vim /etc/postgresql/10/main/pg_hba.conf
sudo service postgresql restart
psql -U technocrats -d moviesdb -W
