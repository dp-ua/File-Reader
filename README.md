
# Project "File Reader"
## Take informations about file and save it to JDBC
## Show in web all saved data

### Realization: 
* using Spring Boot for web
* using hibernate for MySql base
* Project builder Maven
* Testing with JUnit
* start console app: MainConsole.class in ~.console package
* start web app: Application.class in ~.web package

### web mapping:
#### /json 
* get info abount all files in base if JSON
#### /
* show info abount all files in base
#### /fileinfo?fileID
* show info about selected file. 
* request param: fileID
#### /fileinfojson?fileID
* show info about selected file in JSON. 
* request param: fileID

