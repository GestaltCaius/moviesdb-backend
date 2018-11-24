# Getting started on Ubuntu

Install postgresql
```sh
sudo apt-get install postgresql
```

check if postgresql has been installed
```
/etc/init.d/postgresql status
```

create *technocrats* user
```
sudo -u postgres createuser --interactive --password technocrats

Shall the new role be a superuser? (y/n) n
Shall the new role be allowed to create databases? (y/n) y
Shall the new role be allowed to create more new roles? (y/n) n
Password: C8BxprLB
```

Create moviesdb database owned by technocrats user.

```
sudo -u postgres createdb moviesdb -O technocrats
```


```
sudo vim /etc/postgresql/10/main/pg_hba.conf
sudo service postgresql restart
psql -U technocrats -d moviesdb -W
```
