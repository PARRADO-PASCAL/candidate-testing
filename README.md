# Candidate Spring boot test

## Run projet
1. install docker and docker compose if not already installed
2. run docker-compose up -d
3. Launch spring boot application
4. You're ready to go

## Context
### 🗺️ Départements

| Département             | Code | Latitude  | Longitude |
|------------------------|------|-----------|-----------|
| Paris                  | 75   | 48.8566   | 2.3522    |
| Hauts-de-Seine         | 92   | 48.8101   | 2.2419    |
| Rhône                  | 69   | 45.7485   | 4.8467    |
| Bouches-du-Rhône       | 13   | 43.2965   | 5.3698    |

### 🗺️ Départements, villes voisines

| Département             | Ville voisine        | Latitude  | Longitude |
|-------------------------|----------------------|-----------|-----------|
| Paris (75)              | Montreuil            | 48.8594   | 2.4400    |
| Hauts-de-Seine (92)     | Nanterre             | 48.8922   | 2.2113    |
| Rhône (69)              | Villeurbanne         | 45.7666   | 4.8909    |
| Bouches-du-Rhône (13)   | Aix-en-Provence      | 43.5297   | 5.4474    |


## What is in this project
### Controller
[DepartmentController.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2FSpringbootpractice%2FController%2FDepartmentController.java)
### Entity
[Department.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2FSpringbootpractice%2FEntity%2FDepartment.java)
### Repository
[DepartmentRepository.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2FSpringbootpractice%2FRepository%2FDepartmentRepository.java)
### Service
[DepartmentService.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2FSpringbootpractice%2FService%2FDepartmentService.java)

## What is required for this test
- Add the latitude and longitude fields to the Department entity
- Insert the departments into the database
- Create a "/search" endpoint that takes the latitude and longitude of a city as parameters <br><br> The expected return value is the closest department to the sent coordinates within a 20 km radius
- Create a unit test for the DepartmentService service
- Create an integration test for the DepartmentController controller