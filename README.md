### Who Developed What?

<div>
  <img width="600" src="https://user-images.githubusercontent.com/68374234/118522041-93e1ba00-b776-11eb-976e-8d39271bdcda.png">
</div>



### **Base Structure**

```
#{issue_number} [TYPE] : subject

body(optional)

footer(optional)
```

### **Issue Number**

- 이슈 단위 커밋으로 기능 개발을 관리합니다

- GitHub에서 이슈를 트래킹을 할 수 있게 Issue Number를 커밋 메시지에 넣어줍니다

- 1이슈 1커밋이 좋지만 여러 이슈를 한꺼번에 처리한 경우 위의 구조에서 이슈넘버를 생략하고  그 이슈들을 대표할만한 subject를 작성 후, footer에 이슈 넘버를 모아서 써도 좋습니다.

- ex)

  ```
  subject
  
  - [TYPE] body(이슈1)
  - [TYPE] body(이슈2)
  - [TYPE] body(이슈3)
  
  issue track : #이슈1번호, #이슈2번호, #이슈3번호
  ```

### **TYPE**

- FEAT: 새로운 기능 개발(kotlin 작업)
- FIX: 버그 수정
- UI: 스타일(xml file) 코드 변경
- MODIFY: kotlin 코드 수정
- CHORE: Gradle이나 설정 세팅할 때
- DOC: 문서 작성(ex. README.md)

### **Subject**

- 첫 시작은 대문자로 해야한다
- 마지막에 마침표(.)를 찍으면 안된다
- 어떤 변경점이 있는지 설명한다
- 명령조를 사용한다

### **Body**

- 부연 설명이나 커밋의 이유를 설명할 때만 사용
- Not How, Explain What and Why