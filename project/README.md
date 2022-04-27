(2022-04-24)
- entity, repository, member service 구현
- subject service 구현중 addsubject기능에서 오류 발견(h2버전문제, 해결)

(2022-04-27)
- subject service의 addSubject, findSubject 구현 완료, 테스트코드 작성
- home화면 구현(thymeleaf, bootstrap)

![image](https://user-images.githubusercontent.com/68144687/165510362-96adf80e-cffb-4c30-884b-6b719c0d81d8.png)

- 회원등록 화면 및 기능 구현 

![image](https://user-images.githubusercontent.com/68144687/165510408-0db627a5-6c17-4e4d-9e1e-4cddf87e4581.png)

-다음과 같은 오류 발생

![image](https://user-images.githubusercontent.com/68144687/165510435-e1e2d6f0-6c46-49c5-9200-8df3fcd38f0d.png)

(1) 클라이언트의 header의 content-type이 default값인 application/x-www-form-urlencoded으로 보냈지만 apiController의 @RequestsBody를 통해 서버에서는 Json혹은 xml형태로 데이터를 받아서 자바객체에 mapping하려고 했기 때문임
(2)해결 방법으로는 그냥 @RequestBody를 지워서 x-www-form-urlencoded형태로 주고 받으면 되지만 요즘 추세가 view를 분리시켜서..(일단 두 코드 분리시켜놓음, 나중에 클라이언트에서 json형태로 데이터를 보내는 코드를 짜야할 필요 있음)
 
