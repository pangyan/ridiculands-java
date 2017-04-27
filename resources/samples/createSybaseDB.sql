/* IMPORTANT: READ THIS FIRST                                         */
/* This is a sample Sybase create DB script                           */
/* NOT FOR PRODUCTION USE                                             */
/* Change DB name ($NEWDB) as required                                */
/* Change file location paths as required                             */
/* Change the size of the database and devices as per the requirement */
/* save to a file called createdb.sql and run from shell or DOS       */
/* i.e.  isql -Usa -P -S[myserver] -i createSybaseDB.sql                    */
/*                                                                    */
/* Create physical devices....                                        */

disk init
name="data_$NEWDB",
physname="/opt/sybase/data/data_$NEWDB.dat",
size="600M"
go
disk init
name="log_$NEWDB",
physname="/opt/sybase/data/log_$NEWDB.dat",
size="120M"
go

/*******************************************************/
/* Create the database  */

create database $NEWDB
on data_$NEWDB= "600M"
log on log_$NEWDB="120M"
go
/*******************************************************/
/* Create the login login.passwd,defaultdb */

exec sp_addlogin $login, $password
go
/* use the database */
use $NEWDB
go
/* Create the user login,username */
exec sp_changedbowner "calypso"
go
/* Grant the permission to the user */
grant all to calypso
go
sp_configure 'lock scheme', 0,'datarows'
go
/* set some global options */
USE master
go
sp_configure "max memory", 175000
go
sp_dboption $NEWDB,"trunc log on chkpt", true
go
sp_dboption $NEWDB, "select into/bulkcopy", true
go
sp_dboption $NEWDB, "ddl in tran", true
go
/***** the following parameters are suggested by Calypso however the value needs to be change
according to the requirement of the database transcations and volume of the database */

sp_configure "number of locks", 10000
go
sp_configure "number of open indexes", 5000
go
sp_configure "number of open objects", 2000
go
sp_configure "statement cache size", 10000
go
sp_configure "user log cache size", 8192
go
sp_configure "number of open partitions", 10000
go
sp_configure "procedure cache",25600
go
sp_cacheconfig "default data cache","100M"
go
sp_configure "number of devices" , 70
go
disk resize name = 'sysprocsdev' , size = '20.0M'
go
disk resize name = 'systemdbdev' , size = '20.0M'
go
disk resize name = 'master' , size = '350.0M'
go
alter database master on master = 100
go
alter database tempdb on master = 100
go

