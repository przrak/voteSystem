# voteSystem

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

### post Vote
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
