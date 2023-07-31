# navigationSystem
Simple navigation system api

## Database
### Base Station
1. id numeric
2. name: varchar(255)
3. x_coordinate: float
4. y_coordinate float
5. detection_radius: float

### Mobile Station
1. id numeric
2. last_known_x_coordinate: float
3. last_known_y_coordinate float

### Reports
1. id numeric
2. mobile_station_id: float
3. base_station_id float
4. distance float
5. log_time timestamp
- This Api uses h2 in-memory database
- Base Station and Mobile Station tables are populated on initialisation

## Endpoints
### Scan
Goes trough all the base stations and scans for mobile stations in range. Creates a report for when ever a base station discoveres a mobile station.

### Reports
Generates an overview of all the base stations and reports made by those stations.

### Location
Takes an id of a mobile station as a parameter and returns the data of the given station.

## Tests 

- Basic unit tests to cover helper methods
- Endpoint tests to cover Response codes
- Endpoint tests require the api to be running to work.
