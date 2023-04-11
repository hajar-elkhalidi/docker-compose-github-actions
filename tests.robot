*** Settings ***
Library    RPA.Browser.Selenium
Library    OperatingSystem

*** Test Cases ***
Hello, World!
    Open Available Browser
    ...    http://localhost:8080/api/v1/hello
    ...    options=add_argument("--ignore-certificate-errors")
    ...    headless=true
    Page Should Contain    Hello, world!
Get Clients
    Open Available Browser
    ...    http://localhost:8080/api/v1/clients
    ...    options=add_argument("--ignore-certificate-errors")
    ...    headless=true
    Page Should Contain    "id":1
Add Client
    Run
    ...    curl -X POST -H "Content-Type: application/json" -d '{"id": 516, "firstName": "test", "lastName": "test", "email": "test@etsy.com", "gender": "Female", "ipAddress": "94.166.118.50"}' http://localhost:8080/api/v1/clients
    Open Available Browser
    ...    http://localhost:8080/api/v1/clients/516
    ...    options=add_argument("--ignore-certificate-errors")
    ...    headless=true
    Page Should Contain    "id":516
Update Client
    Run
    ...    curl -X PUT -H "Content-Type: application/json" -d '{"id": 516, "firstName": "new", "lastName": "test", "email": "test@etsy.com", "gender": "Female", "ipAddress": "94.166.118.50"}' http://localhost:8080/api/v1/clients/516
    Open Available Browser
    ...    http://localhost:8080/api/v1/clients/516
    ...    options=add_argument("--ignore-certificate-errors")
    ...    headless=true
    Page Should Contain    new
Delete Client
    Run    curl -X DELETE http://localhost:8080/api/v1/clients/1 > /dev/null
    Open Available Browser
    ...    http://localhost:8080/api/v1/clients/1
    ...    options=add_argument("--ignore-certificate-errors")
    ...    headless=true
    Page Should Contain    Error