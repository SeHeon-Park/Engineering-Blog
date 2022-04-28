(2022-04-24)
- entity, repository, member service 구현
- subject service 구현중 addsubject기능에서 오류 발견(h2버전문제, 해결)

(2022-04-27)
- subject service의 addSubject, findSubject 구현 완료, 테스트코드 작성
- home화면 구현(thymeleaf, bootstrap)

![image](https://user-images.githubusercontent.com/68144687/165510362-96adf80e-cffb-4c30-884b-6b719c0d81d8.png)

- 회원등록 화면 및 기능 구현 

![image](https://user-images.githubusercontent.com/68144687/165510408-0db627a5-6c17-4e4d-9e1e-4cddf87e4581.png)

- 다음과 같은 오류 발생

![image](https://user-images.githubusercontent.com/68144687/165510435-e1e2d6f0-6c46-49c5-9200-8df3fcd38f0d.png)

(1) 클라이언트에서는 content-type default값인 application/x-www-form-urlencoded으로 보냈지만 apiController의 @RequestsBody를 통해 서버에서는 Json혹은 xml형태로 데이터를 받아서 객체에 mapping하려고 했기 때문임

(2)해결 방법으로는 그냥 @RequestBody를 지워서 x-www-form-urlencoded형태로 주고 받으면 되지만 요즘 추세가 view를 분리시킴
(일단 application/x-www-form-urlencoded형태로 주고받는 코드와 json형태로 받는 apiController코드 둘다 짜놓음, 나중에 클라이언트에서 json형태로 데이터를 보내는 코드를 짜야할 필요 있음) 

(2022-04-28)

- 회원 목록 화면 구현 및 css

![image](https://user-images.githubusercontent.com/68144687/165750801-cae51b5f-77ee-484e-8140-341552154c28.png)

![image](https://user-images.githubusercontent.com/68144687/165751008-3ad7e1da-4ef9-4ba8-9aa2-6e1941a142e0.png) 
-------------------------------------------------------------------------
![image](https://user-images.githubusercontent.com/68144687/165751022-739fd67b-1a6c-4501-b882-b069d7a4d7cb.png)

- login: contents를 볼수 있는 페이지로 넘어감, delete: 경고창이 나온 후 삭제됨
- login기능을 구현 할때 view에서 controller로 사용자의 데이터가 넘어가지 않았음, 다음과 같이 해결

![image](https://user-images.githubusercontent.com/68144687/165751159-d8f4b8c4-e1ce-4445-982e-68c17e88d514.png)
![image](https://user-images.githubusercontent.com/68144687/165751172-492f5c17-2663-4feb-9a42-fbbf9cbda98b.png)


