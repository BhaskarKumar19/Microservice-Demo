# Demonstrating mysql service bind on PCF

## Application is configured to run on local as well as on pcf and attach to a db without any code change.


- when app is run without any profile on local, it will connect to local mysql db.
- when app is pushed to pcf it will use **h2** if any db instance is not bound. **SPRING_PROFILES_ACTIVE** is set to **h2** in manifest file.
- when app is pushed to pcf it will use db instace if any db instance is bound.

## command to create db instace on pcf:
- cf marketplace  [ To locate all services available ]
- cf marketplace -s cleardb  [ to know the plan to use ]
- cf create-service cleardb spark mysql-instance  [ creates an instace with name mysql-instance ]



----------------------------------------------------------------------------------------------------------------------------------------

