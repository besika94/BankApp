# Project Name

## Build and Run the Project

### Clean and package the project, skipping tests:
```sh
./mvnw clean package -DskipTests
```
### Build the Docker image:
```sh
docker build -t project .
```
### Start the application using Docker Compose:
```sh
docker-compose up --build 
```
### Api methods :
### create Customer
#### path:
```sh
/api/customers 
```
#### method: post
- create just a customer with no account:
```sh
			{
				"name": "John",
				"lastName": "doe"
			}
```
- create customer with new account
```sh
			{
				"name": "John",
				"lastName": "doe",
				"account": {
					"accountNumber": "PT59 24332 2982 23243",
					"balance": 600
				}
			}
```
- create customer and assign already existing account
```sh
			{
				"id": "customerId"
				"name": "John",
				"lastName": "doe",
				"account": {
					"id": "",	
				}
			}
```
### get customer
#### method get
#### path:
```sh
/api/customers/{id}
```
		
### get all customers
#### method get
#### path: 
```sh
/api/customers
```
			
### create account with innitial ballance 
#### method: post
#### path:
```sh
/api/accounts
```
#### body:
```sh
			{
				"accountNumber": "PT72 24363 2343 23212",
				"balance": 500
			}
```
			
### get all account
#### method: get
#### path: 
```sh
/api/accounts
```
		
### deposit money
#### method: post
#### path:
```sh
/api/accounts/{accounId}/deposit
```
#### body: 
```sh
			{
				"amount": 300.0
			}
```

### withdraw money
#### method: post
#### path:
```sh
/api/accounts/{accounId}/withdraw
```
#### body:
```sh
			{
				"amount": 300.0
			}
```
### see transactions related to account
#### method: get
#### path:
```sh
/api/accounts/{accountId}
```





























