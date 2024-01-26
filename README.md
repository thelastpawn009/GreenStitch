﻿# GreenStitchAssignment

Assignment as per doc -https://docs.google.com/document/d/1zk9BBu3AwYgB5Hlv7SEaZVjBcZ7CeSMOPPOST22_bTM/edit

Just run the application after installing dependencies.

H2 is implemented in memory. To access H2 database console - http://localhost:8080/h2-console/ 
username- sa
password - 

Endpoints:
* To signUp - 

          curl --location --request POST 'http://localhost:8080/auth/signUp' \
          --header 'Content-Type: application/json' \
                    --data-raw '{
              "email":"amrit009anand@gmail.com",
              "password":"anand"
          }'
          Expected response - SignUp successful.

* To login -
        curl --location --request POST 'http://localhost:8080/auth/login' \
        --header 'Content-Type: application/json' \
        --data-raw '{
            "email":"amrit009anand@gmail.com",
            "password":"anand"
        }'

        Expected Response- 
        "jwtToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJEVVJHRVNIIiwiaWF0IjoxNzA2MjU5OTIyLCJleHAiOjE3MDYyNzc5MjJ9.MNPmIgYDS41oxR_oNYWnewmu6EohAM6lCesC17xJGA9bZcORcFxQOoJkX-uBUeDJewZP2a0kKAA6nBiLtgfqWw",
        "email": "amrit009anand@gmail.com"

Once token generated -

* the hello endpoint -

curl --location --request GET 'http://localhost:8080/hello' \
--header 'Authorization: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBbXJpdCIsImlhdCI6MTcwNjI1OTQzNiwiZXhwIjoxNzA2Mjc3NDM2fQ.WZ6T1U1enS7PNb3nZ-dHq4A4Z49qT_9qccAH55MpozEoCfT0Fgc_-D_ybW-EZ7nzxrgygP4HNOEfadShzqmsyw' 

Expected response - Hello from GreenStitch


///////////////////////
Dependencies -
SpringWeb
Spring Security
h2database
lombok
spring-boot-starter-data-jpa
io.jsonwebtoken   
