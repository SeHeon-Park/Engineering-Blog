## Description
Spring Boot + JPA + Thymleaf 로 구현한 과목별로 내용을 정리 해놓을 수 있는 기술 블로그

## 프로젝트 정보

<details markdown="3">
<summary>기술 스택</summary>

- Spring Boot
- Spring Security
- JPA
- MySql
- Thymleaf

</details>

<details markdown="3">
<summary>ERD</summary>

![image](https://user-images.githubusercontent.com/68144687/217150007-68312cf7-6b76-4753-816e-b89aa8cd9012.png)

</details>

### 코드 정리
https://velog.io/@qtwe153/series/Make-Blog 


## 프로젝트 결과물

<details markdown="1">
<summary>메인페이지</summary>

<img src = "https://user-images.githubusercontent.com/68144687/175265333-775c9241-327f-453e-b12a-562966f17eb6.png"  width="50%" height="50%"> 
<img src = "https://user-images.githubusercontent.com/68144687/175265454-8f809e28-8ae7-47b0-84a6-c50caf9783e3.png"  width="50%" height="50%"> 

- 로그인 전 페이지, 로그인 후 페이지
- 최근에 작성된 포스터가 과목별로 두개씩 나온다.

</details>

<details markdown="1">
<summary>회원가입 및 로그인</summary>

![ezgif com-gif-maker (9)](https://user-images.githubusercontent.com/68144687/175268625-5a67212d-812b-459e-bb49-754bb6aa820a.gif)
![ezgif com-gif-maker (10)](https://user-images.githubusercontent.com/68144687/175268836-136d0cc3-bfa0-461f-abc3-629331f98281.gif)
- 이름, 아이디, 비밀번호는 필수 입력이며, 아이디는 중복 X
- 비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자 사용
- 로그인 실패시 오류메시지 출력

</details>

<details markdown="1">
<summary>과목별 리스트 및 과목 추가 기능</summary>

![ezgif com-gif-maker (11)](https://user-images.githubusercontent.com/68144687/175269184-e4bc99d3-f5b1-4308-b274-ceb33e3a7367.gif)
- 과목명과 요일을 만족하는 과목 리스트 검색
- 과목명과 요일 선택해서 검색 가능
- 과목 추가, 검색

</details>

<details markdown="1">
<summary>게시판 형태의 글 기록</summary>

![ezgif com-gif-maker (12)](https://user-images.githubusercontent.com/68144687/175269532-50f2a8ac-df01-4813-a0b2-fbea6bf57feb.gif)
- 게시판 형태의 내용 기록
- 글쓰기, 수정, 삭제 기능
- 게시글 작성 시 마크다운 적용

</details>






