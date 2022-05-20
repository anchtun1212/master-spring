# Create new PostgreSQL Database and new user

sudo -u postgres psql

postgres=# create database springdb;

postgres=# create user springuser with encrypted password 'springpass';

postgres=# grant all privileges on database springdb to springuser;

# Note:

Please execute those two scripts: `web_schema.sql` and `web_data.sql`

# In this project:

1- Migrate from `spring jdbc` to `spring data jpa`.