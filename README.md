## Description
Spring Boot + JPA로 구현한 과목별로 내용을 정리 해놓을 수 있는 기술 블로그

## 프로젝트 정보
### URL
http://3.39.184.90:8080/
- aws cpu 크레딧 소진(해결)
- 새로운 인스턴스 생성하여 프로젝트 연결

### 개발 스택
- Spring Boot
- Spring Security
- JPA
- MySql
- Thymleaf

### 코드 정리
https://velog.io/@qtwe153/series/Make-Blog 

## 프로젝트 결과물

### 메인페이지
![image](https://user-images.githubusercontent.com/68144687/175265333-775c9241-327f-453e-b12a-562966f17eb6.png)
![image](https://user-images.githubusercontent.com/68144687/175265454-8f809e28-8ae7-47b0-84a6-c50caf9783e3.png)
   
- 로그인 전 페이지, 로그인 후 페이지
### 회원가입 및 로그인 
![ezgif com-gif-maker (3)](https://user-images.githubusercontent.com/68144687/170073038-f69f6bb3-8e58-4167-8d3d-a86dd405eb73.gif)
![ezgif com-gif-maker (4)](https://user-images.githubusercontent.com/68144687/170073368-ad6e80a5-d11b-497d-a736-cbf9e36cdc3c.gif)
- 이름, 아이디, 비밀번호는 필수 입력이며, 아이디 중복되면 안됨
- 비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용
### 과목별 리스트 및 과목 추가 기능
![ezgif com-gif-maker (5)](https://user-images.githubusercontent.com/68144687/170074541-d42ce91f-a105-4b5b-88fc-9488499ee9fb.gif)
- 과목명과 요일을 만족하는 과목 리스트 검색
- 과목명과 요일 하나만 선택해서 검색 가능
- 과목 추가, 검색 
### 게시판 형태의 글 기록
![ezgif com-gif-maker (6)](https://user-images.githubusercontent.com/68144687/170183309-c6a796a2-6cc4-4313-88d4-1de27637a657.gif)
- 게시판 형태의 내용 기록
- 글쓰기, 수정, 삭제 기능

## update!
### 게시글 작성 시 마크다운 적용
<img src = "https://user-images.githubusercontent.com/68144687/170991956-615ae356-39fa-4f55-895a-2b528eaff2f3.png"  width="50%" height="50%"> <img src = "https://user-images.githubusercontent.com/68144687/170991977-185c6297-8943-41f4-bc75-93c6908196ad.png" width="50%" height="50%">
- 마크다운 문법 사용 가능
### 현재 게시글에서 바로 이전, 다음 게시글로 넘어가는 기능
![ezgif com-gif-maker (7)](https://user-images.githubusercontent.com/68144687/171387648-bd5e477d-23a1-4468-b748-69d1f1f4f2d3.gif)
### 로그인 실패시 오류메시지 출력
<img src = "https://user-images.githubusercontent.com/68144687/171633191-c86e32c8-196c-45a6-955a-d6ac86d482d6.png"  width="50%" height="50%">

### 기타
- 과목 요일 검색 라디오 버튼 체크 해제 기능
- 리뷰리스트 페이지에서 과목 선택 페이지로 넘어가는 기능







