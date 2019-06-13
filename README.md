# voteSystem

Меню заполнено с 10.06.2019 по 15.06.2019

### curl samples (application deployed in application context `votesystem`).
> For windows use `Git Bash`

#### get Menu on date
curl -X GET \
  'http://localhost:8080/votesystem/rest/menus?date=2019-06-13' \
  -H 'Accept: */*' \
  -H 'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: 38a9bde7-0ad2-407f-98c3-10a34bec0bf0,23f874ca-cb2d-4168-bdae-623547798f8f' \
  -H 'User-Agent: PostmanRuntime/7.11.0' \
  -H 'accept-encoding: gzip, deflate' \
  -H 'cache-control: no-cache'

#### get Vote on date
curl -X GET \
  'http://localhost:8080/votesystem/rest/votes?date=2019-06-13' \
  -H 'Accept: */*' \
  -H 'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: 43000cca-4ceb-435f-bb4f-b6f8a70ab4c4,4e25e23f-123c-4f7d-b391-cacb7a1903bd' \
  -H 'User-Agent: PostmanRuntime/7.11.0' \
  -H 'accept-encoding: gzip, deflate' \
  -H 'cache-control: no-cache'

#### get Vote with Error
curl -X GET \
  'http://localhost:8080/votesystem/rest/votes?date=2019-06-20' \
  -H 'Accept: */*' \
  -H 'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: 43000cca-4ceb-435f-bb4f-b6f8a70ab4c4,4e25e23f-123c-4f7d-b391-cacb7a1903bd' \
  -H 'User-Agent: PostmanRuntime/7.11.0' \
  -H 'accept-encoding: gzip, deflate' \
  -H 'cache-control: no-cache'

### create Vote
curl -X POST \
  http://localhost:8080/votesystem/rest/votes \
  -H 'Accept: */*' \
  -H 'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Content-Type: application/json' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: 0b66861e-d4ff-47cc-9e8d-4d118b883788,4c55e604-382a-4142-ba26-1955203f5aef' \
  -H 'User-Agent: PostmanRuntime/7.11.0' \
  -H 'accept-encoding: gzip, deflate' \
  -H 'cache-control: no-cache' \
  -H 'content-length: 15' \
  -d '{"id":"100003"}'

### create User
curl -X POST \
  http://localhost:8080/votesystem/rest/admin/users \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 507d27ed-5847-4926-b084-d61ef7aba422' \
  -H 'cache-control: no-cache' \
  -d '{"name":"Vasya","email":"test2@gmail.com","password":"password","roles":["ROLE_USER"]}'
  
### get allUser
curl -X GET \
  http://localhost:8080/votesystem/rest/admin/users \
  -H 'Accept: */*' \
  -H 'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: fd2bdefe-76c1-4474-8b2c-7b3290f42ab6,099dfc83-7042-4846-b967-b9afb4503ef2' \
  -H 'User-Agent: PostmanRuntime/7.11.0' \
  -H 'accept-encoding: gzip, deflate' \
  -H 'cache-control: no-cache' \
  -H 'cookie: JSESSIONID=8896FB6BB637DDA040E6232A1CDF171E' \
  -b JSESSIONID=8896FB6BB637DDA040E6232A1CDF171E
  
### get User by email
curl -X GET \
  'http://localhost:8080/votesystem/rest/admin/users/by?email=user@yandex.ru' \
  -H 'Accept: */*' \
  -H 'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: 9b6e2a6b-ae31-44a4-8b96-2be1df2873c7,d1704c66-1390-4a40-846c-bb68d26ff660' \
  -H 'User-Agent: PostmanRuntime/7.11.0' \
  -H 'accept-encoding: gzip, deflate' \
  -H 'cache-control: no-cache' \
  -H 'cookie: JSESSIONID=8896FB6BB637DDA040E6232A1CDF171E' \
  -b JSESSIONID=8896FB6BB637DDA040E6232A1CDF171E
  
  ### delete User by Id
  curl -X DELETE \
  http://localhost:8080/votesystem/rest/admin/users/100000 \
  -H 'Accept: */*' \
  -H 'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: b0a71406-2ce9-4f22-9480-3b960e7b7a73,98258ff3-e4f3-4010-a9ba-0b817eb092b0' \
  -H 'User-Agent: PostmanRuntime/7.11.0' \
  -H 'accept-encoding: gzip, deflate' \
  -H 'cache-control: no-cache' \
  -H 'content-length: ' \
  -H 'cookie: JSESSIONID=8896FB6BB637DDA040E6232A1CDF171E' \
  -b JSESSIONID=8896FB6BB637DDA040E6232A1CDF171E
  
  ### update User by Id
  curl -X PUT \
  http://localhost:8080/votesystem/rest/admin/users/100000 \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 99d1d692-7e64-4a9b-b75b-0a8f6059b84d' \
  -H 'cache-control: no-cache' \
  -d '{"name":"UpdatedName","email":"user1@yandex.ru","password":"testtt","roles":["ROLE_ADMIN"]}'
  
  ### get User by Id
  curl -X GET \
  http://localhost:8080/votesystem/rest/admin/users/100001 \
  -H 'Accept: */*' \
  -H 'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' \
  -H 'Cache-Control: no-cache' \
  -H 'Connection: keep-alive' \
  -H 'Host: localhost:8080' \
  -H 'Postman-Token: 4497637c-8d8a-419f-bf01-b006ea4da47a,24fc2bf9-954d-4732-99b3-9c1e02e86275' \
  -H 'User-Agent: PostmanRuntime/7.11.0' \
  -H 'accept-encoding: gzip, deflate' \
  -H 'cache-control: no-cache' \
  -H 'cookie: JSESSIONID=8896FB6BB637DDA040E6232A1CDF171E' \
  -b JSESSIONID=8896FB6BB637DDA040E6232A1CDF171E
