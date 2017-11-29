## Location Microservice

Location microservice helps us to 
		add, 
		delete and 
		search a location inorder to place an order of the product.

## URL's and function

Use Any Rest clients(REST API CLIENT,POSTMAN CLIENT etc) to access the REST end points of the application 
1.http://localhost:8080/api/location/ and POST Request method helps you to add a new location and persist the data in mysql db
    For example your Json input should as 
    
    REQUEST BODY:		
{	
	"locationName":"IN_CH",
}

2. http://localhost:8080/api/location/{locationid} and GET Request method helps to fetch the persisted data from mysql db with respect to id
  	For example the response body :
  			{
				"locationId": 2,
				"locationName":"IN_CH"
			}
			
	  		
3. http://localhost:8080/api/location/updateByLocationById and PUT Request method helps to update the data
	
	 	REQUEST BODY:		
	{	
		"locationId":2
		"locationName":"IN_MD",
	}
	
	  Response body:
	  		Product updated	
	  		
4. http://localhost:8080/api/location/ and GET Request method helps to fetch all the persisted data from mysql db
  	For example the response body :
  			{
				"locationId": 2,
				"locationName":"IN_MD"
			} 	
			
5.http://localhost:8080/api/location/getLocationByName/IN_MD and GET Request method helps to fetch persisted data from mysql db with respect to location name.
  	For example the response body :
  			{
				"locationId": 2,
				"locationName":"IN_MD"
			} 
	  		
When try to fetch or update or delete a data that is not available in the DB you recieve a error message 
	  	  		
	  	{
		"timestamp": 1482213918625,
		"status": 404,
		"error": "Not Found",
		"exception": "com.accn.location.exception.LocationNotFoundException",
		"message": "No such location: 1",
		"path": "/location/1"
		}	
	
	
	
	
## Run MySQL 5.6 in Docker container:

~~~
docker run --name demo-mysql -e MYSQL_ROOT_PASSWORD=sa -d mysql:5.6

# To expose the port 3306
docker run --name comm_mysql -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root mysql:5.7
~~~

Check the log to make sure the server is running OK:
~~~
docker logs demo-mysql
~~~

# To access the mysql db instance running in docker to run queries connect using the following:
docker exec -it test-mysql bash

mysql -uroot -psa -h 172.17.0.20 -P 3306

~~~

Run demo application in Docker container and link to demo-mysql:

~~~
docker run -p 8080:8080 --name demo-app --link demo-mysql:mysql -d pes/location
~~~

You can check the log by
~~~
docker logs demo-app

## Command to Run the Application with Profiles:
mvn spring-boot:run -Dspring.profiles.active="prod"

## CONFIG SERVER

Config server : http://localhost:8888

Config Properties : https://github.com/sreenivasd/microservices/locationservice
		
		
		
		