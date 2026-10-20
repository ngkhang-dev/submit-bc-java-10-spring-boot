# BC Java - Assignment 10 - Spring Boot

![Status](https://img.shields.io/badge/status-completed-brightgreen)
![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?logo=intellij-idea&logoColor=white)

<!-- TOC -->

* [BC Java - Assignment 10 - Spring Boot](#bc-java---assignment-10---spring-boot)
    * [Requirements](#requirements)
        * [Question 1: Path + Query](#question-1-path--query)
        * [Question 2: POST + Query + Body](#question-2-post--query--body)
        * [Question 3: Header + Path](#question-3-header--path)
        * [Question 4: Query Param có default](#question-4-query-param-có-default)
        * [Question 5: Nhận danh sách Query](#question-5-nhận-danh-sách-query)
        * [Question 6: Query Map động](#question-6-query-map-động)
        * [Question 7: Form URL Encoded](#question-7-form-url-encoded)
        * [Question 8: Multipart + nhiều tham số](#question-8-multipart--nhiều-tham-số)
        * [Question 9: PUT cập nhật từng phần](#question-9-put-cập-nhật-từng-phần)
        * [Question 10: DELETE + Header xác thực](#question-10-delete--header-xác-thực)
    * [Prerequisites](#prerequisites)
        * [Project Structure](#project-structure)
        * [Environment](#environment)
    * [Author](#author)

<!-- TOC -->

## Requirements

### Question 1: Path + Query

- Requirement:
    - API:
        - GET `/orders/{orderId}?currency=VND`
    - Trả về:

        ```json
        {
            "orderId": 101,
            "currency": "VND"
        }
        ```

    - Dùng `@PathVariable` + `@RequestParam`
- Solution: [Question 1](src/main/java/com/cybersoft/springboot/q1)
- URL: <http://localhost:8080/q1/orders/101?currency=VND>

### Question 2: POST + Query + Body

- Requirement:
    - API:
        - POST `/comments?postId=5`
            - Body:

                ```json
                {
                  "content": "Bài viết hay quá!"
                }
                ```

    - Dùng `@RequestParam` + `@RequestBody`
- Solution: [Question 2](src/main/java/com/cybersoft/springboot/q2)
- URL:
    - POST: <http://localhost:8080/q2/comments?postId=5>
        - Body:

            ```json
            {
              "content": "Bài viết hay quá!"
            }
            ```

### Question 3: Header + Path

- Requirement:
    - API:
        - GET `/users/{id}`
        - Header: `X-Client-Version: 1.2.0`
    - Dùng `@RequestHeader` + `@PathVariable`

- Solution: [Question 3](src/main/java/com/cybersoft/springboot/q3)
- URL:
    - <http://localhost:8080/q3/users/1>
        - Header: `X-Client-Version: 1.2.0`

### Question 4: Query Param có default

- Requirement:
    - API:
        - GET `/search?keyword=spring`
          Nếu không có page, size → mặc định page=0, size=10
    - Dùng `@RequestParam(defaultValue=...)`
- Solution: [Question 4](src/main/java/com/cybersoft/springboot/q4)
- URL:
    - <http://localhost:8080/q4/search?keyword=spring>
    - <http://localhost:8080/q4/search?keyword=spring&page=5>
    - <http://localhost:8080/q4/search?keyword=spring&page=5&size=20>

### Question 5: Nhận danh sách Query

- Requirement:
    - API:
        - GET `/tags?tags=java,spring,boot`
            - Trả về: `List<String>`
              `["java", "spring", "boot"]`
- Solution: [Question 5](src/main/java/com/cybersoft/springboot/q5)
- URL:
    - <http://localhost:8080/q5/tags?tags=java,spring,boot>

### Question 6: Query Map động

- Requirement:
    - API:
        - GET `/filters?color=red&size=M&brand=Nike`
    - Dùng `@RequestParam Map<String, String>`

- Solution: [Question 6](src/main/java/com/cybersoft/springboot/q6)
- URL:
    - GET: <http://localhost:8080/q6/filters?color=red&size=M&brand=Nike>

### Question 7: Form URL Encoded

- Requirement:
    - API:
        - POST `/login-form`
        - Content-Type: `application/x-www-form-urlencoded`
        - Params: `username=admin&password=123`
    - Dùng `@RequestParam`
- Solution: [Question 7](src/main/java/com/cybersoft/springboot/q7)
- URL: <http://localhost:8080/q7/login-form>

### Question 8: Multipart + nhiều tham số

- Requirement:
    - API:
        - POST `/documents`
        - Nhận:
            - file
            - title
            - description
            - tags (list)
    - Dùng `MultipartFile` + `@RequestParam`
- Solution: [Question 8](src/main/java/com/cybersoft/springboot/q8)
- URL: <http://localhost:8080/q8/documents>
    - Choice "Body" > "form-data"
    - Enter "title", "description", "tags" (String)
    - Enter "file" (File) and select a file

### Question 9: PUT cập nhật từng phần

- Requirement:
    - API:
        - PUT `/users/{id}`
            - Body:

                ```json
                {
                  "email": "new@email.com"
                }
                ```

    - Dùng `@PutMapping` + `@RequestBody` + `@PathVariable`
- Solution: [Question 9](src/main/java/com/cybersoft/springboot/q9)
- URL: PUT <http://localhost:8080/q9/users/1>
    - Body:

      ```json
      {
        "email": "new@email.com"
      }
      ```

### Question 10: DELETE + Header xác thực

- Requirement:
    - API:
        - DELETE `/posts/{id}`
            - Header: `Authorization: Bearer xxx`
    - Dùng `@DeleteMapping` + `@RequestHeader`
- Solution: [Question 10](src/main/java/com/cybersoft/springboot/q10)
- URL: <http://localhost:8080/q10/posts/1>
    - Case success: `Authorization: Bearer abc`
    - Case fail: `Authorization: Bearerabc` or miss `Authorization`

## Prerequisites

### Project Structure

```text
./
│   .gitattributes
│   .gitignore
│   mvnw
│   mvnw.cmd
│   pom.xml
│   README.md
│
├───.mvn
│   └───wrapper
│           maven-wrapper.properties
│
└───src
    └───main
        ├───java
        │   └───com
        │       └───cybersoft
        │           └───springboot
        │               │   SubmitBcJava10SpringBootApplication.java
        │               │
        │               ├───q1
        │               │       Q1OrderController.java
        │               │       Q1OrderService.java
        │               │       Q1ResponseDTO.java
        │               │
        │               ├───q2
        │               │       Q2Controller.java
        │               │       Q2CreateDTO.java
        │               │       Q2Service.java
        │               │
        │               ├───q3
        │               │       Q3Controller.java
        │               │
        │               ├───q4
        │               │       Q4Controller.java
        │               │       Q4ResponseDTO.java
        │               │
        │               ├───q5
        │               │       Q5Controller.java
        │               │       Q5Service.java
        │               │
        │               ├───q6
        │               │       Q6Controller.java
        │               │
        │               ├───q7
        │               │       Q7Controller.java
        │               │
        │               ├───q8
        │               │       Q8Controller.java
        │               │       Q8Response.java
        │               │       Q8Service.java
        │               │       Q8UploadFileDTO.java
        │               │
        │               ├───q9
        │               │       Q9Controller.java
        │               │       Q9Service.java
        │               │       Q9UpdateDTO.java
        │               │       User.java
        │               └───q10
        │                       Q10Controller.java
        │
        └───resources
            └───application.properties
```

### Environment

- IDE: IntelliJ
- Java 21

## Author

Khang Nguyen
