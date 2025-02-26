[JAVA_BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white

<h1 align="center" style="font-weight: bold;">Unipapers Requests 💻</h1>

![java][JAVA_BADGE]
![spring][SPRING_BADGE]

<p align="center">
 <a href="#started">Getting Started</a> • 
  <a href="#routes">API Endpoints</a> •
 <a href="#colab">Collaborators</a> •
 <a href="#contribute">Contribute</a>
</p>

<p align="center">
  <b>
    This project is an API developed using Java, Spring Boot, and MySQL, 
    designed to support a Flutter application created for a university 
    project. It serves as the backend foundation, enabling seamless 
    integration and reliable data management for the application.
  </b>
</p>

<h2 id="started">🚀 Getting started</h2>

The project is running with Spring and configurations in Maven, the easiest way to run
this project is by using the IntelliJ IDEA IDE, with all the plugins necessary to run
the Spring app

<h3>Prerequisites</h3>

[//]: # (Here you list all prerequisites necessary for running your project.  )

[//]: # (For example:)

- [Git](https://git-scm.com/downloads)
- [JDK Java 17](https://www.oracle.com/br/java/technologies/downloads/#java17-windows)
- [Maven](https://maven.apache.org/)
- [MySQL](https://dev.mysql.com/downloads/installer/)

<h3>Cloning</h3>

[//]: # (How to clone your project)

```bash
git clone https://github.com/LuizVieira11/unipapers-requests.git
```

<h3> Environment Variables</h3>

Use the `application-example.properties` or `application-example.yml` as reference to create your configuration file `application.properties` with your database Credentials

_**Properties**_ 

```properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_name
spring.datasource.username=username
spring.datasource.password=password

spring.jpa.show-sql=false
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=false
```

_**Yml**_

```yml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_name
    username: username
    password: password

  jpa:
    show-sql: false

    hibernate:
      ddl-auto: update

    properties:
      hibernate:
        format_sql: false
```

<h3>Starting</h3>

[//]: # (How to start your project)

```bash
cd project-directory\unipapers-requests
mvn clean install
cd target
java -jar file-name.jar
```


<h2 id="routes">📍 API Endpoints</h2>

[//]: # (Here you can list the main routes of your API, and what are their expected request bodies.)

| route                                | description                                                                                                          |
|--------------------------------------|----------------------------------------------------------------------------------------------------------------------|
| <kbd>GET /api/readers</kbd>          | retrieves **all readers** info see [response details](#get-all-readers-detail)                                       |
| <kbd>GET /api/readers/{id}</kbd>     | retrieves **specified reader** info see [response details](#get-reader-detail)                                       |
| <kbd>GET /api/readers/email</kbd>    | retrieves **reader by email** info see [response details](#get-reader-email-detail)                                  |
| <kbd>GET /api/writers</kbd>          | retrieves **all writers** info see [response details](#get-all-writers-detail)                                       |
| <kbd>GET /api/writers/{id}</kbd>     | retrieves **specified writers** info see [response details](#get-writers-detail)                                     |
| <kbd>GET /api/writers/email</kbd>    | retrieves **writer by email** info see [response details](#get-writer-email-detail)                                  |
| <kbd>GET /api/writers/name</kbd>     | retrieves **writer by name** info see [response details](#get-writer-name-detail)                                    |
| <kbd>GET /api/researches/</kbd>      | retrieves **all researches** info see [response details](#get-all-researches-detail)                                 |
| <kbd>GET /api/researches/{id}</kbd>  | retrieves **specified researches** info see [response details](#get-researches-detail)                               |
| <kbd>GET /api/researches/name</kbd>  | retrieves **researches by the title or name of the author** info see [response details](#get-researches-name-detail) |
| <kbd>POST /api/readers</kbd>         | insert **reader** info see [request details](#post-reader-detail)                                                    |
| <kbd>POST /api/writers</kbd>         | insert **writer** info see [request details](#post-writer-detail)                                                    |
| <kbd>POST /api/researches</kbd>      | insert **research** info see [request details](#post-research-detail)                                                |
| <kbd>PUT /api/readers/{id}</kbd>     | update **reader** info see [request details](#update-reader-detail)                                                  |
| <kbd>PUT /api/writers/{id}</kbd>     | update **writer** info see [request details](#update-writer-detail)                                                  |

<h3 id="get-all-readers-detail">GET /api/readers</h3>

**RESPONSE**
```json
[
  {
    "id": 1,
    "name": "Luiz Vieira",
    "phone": "(11) 99999-9999",
    "email": "his-email@email.com",
    "password": "password123"
  }
]
```

---

<h3 id="get-reader-detail">GET /api/readers/{id}</h3>

**RESPONSE**
```json
{
    "id": 1,
    "name": "Luiz Vieira",
    "phone": "(11) 99999-9999",
    "email": "his-email@email.com",
    "password": "password123"
}
```

---

<h3 id="get-reader-email-detail">GET /api/readers/email?email=his-email@email.com</h3>

**RESPONSE**
```json
{
    "id": 1,
    "name": "Luiz Vieira",
    "phone": "(11) 99999-9999",
    "email": "his-email@email.com",
    "password": "password123"
}
```

---

<h3 id="get-all-writers-detail">GET /api/writers</h3>

**RESPONSE**
```json
[
  {
    "id": 1,
    "name": "Luiz Vieira",
    "phone": "(11) 99999-9999",
    "email": "his-email@email.com",
    "password": "password123",
    "course": "Computer Engineering",
    "ra": "00119999"
  }
]
```

---

<h3 id="get-writer-detail">GET /api/writers/{id}</h3>

**RESPONSE**
```json
{
  "id": 1,
  "name": "Luiz Vieira",
  "phone": "(11) 99999-9999",
  "email": "his-email@email.com",
  "password": "password123",
  "course": "Computer Engineering",
  "ra": "00119999"
}
```

---

<h3 id="get-writer-email-detail">GET /api/writers/email?email=his-email@email.com</h3>

**RESPONSE**
```json
{
  "id": 1,
  "name": "Luiz Vieira",
  "phone": "(11) 99999-9999",
  "email": "his-email@email.com",
  "password": "password123",
  "course": "Computer Engineering",
  "ra": "00119999"
}
```

---

<h3 id="get-writer-name-detail">GET /api/writers/name?name=lu</h3>

**RESPONSE**
```json
[
    {
      "id": 1,
      "name": "Luiz Vieira",
      "phone": "(11) 99999-9999",
      "email": "his-email@email.com",
      "password": "password123",
      "course": "Computer Engineering",
      "ra": "00119999"
    }
]
```

---

<h3 id="get-all-researches-detail">GET /api/researches/</h3>

**RESPONSE**
```json
[
  {
    "id": 1,
    "name": "Research Title",
    "description": "Research Description",
    "blobFile": "[blobText]",
    "writer": {
        "id": 1,
        "name": "Luiz Vieira",
        "phone": "(11) 99999-9999",
        "email": "his-email@email.com",
        "password": "password123",
        "course": "Computer Engineering",
        "ra": "00119999"
    },
    "collaborators": "Name of collabs"
  }
]
```

---

<h3 id="get-researches-detail">GET /api/researches/1</h3>

**RESPONSE**
```json
{
    "id": 1,
    "name": "Research Title",
    "description": "Research Description",
    "blobFile": "[blobText]",
    "writer": {
        "id": 1,
        "name": "Luiz Vieira",
        "phone": "(11) 99999-9999",
        "email": "his-email@email.com",
        "password": "password123",
        "course": "Computer Engineering",
        "ra": "00119999"
    },
    "collaborators": "Name of collabs"
}
```

---

<h3 id="get-researches-name-detail">GET /api/researches/name?name=lu</h3>

**RESPONSE**
```json
[
  {
    "id": 1,
    "name": "Research Title",
    "description": "Research Description",
    "blobFile": "[blobText]",
    "writer": {
      "id": 1,
      "name": "Luiz Vieira",
      "phone": "(11) 99999-9999",
      "email": "his-email@email.com",
      "password": "password123",
      "course": "Computer Engineering",
      "ra": "00119999"
    },
    "collaborators": "Name of collabs"
  }
]
```

---

<h3 id="post-reader-detail">POST /api/readers</h3>

**REQUEST**
```json
{
  "name": "Luiz Vieira",
  "phone": "(11) 99999-9999",
  "email": "his-email@email.com",
  "password": "password123"
}
```

**RESPONSE**
```json
{
  "id": 1,
  "name": "Luiz Vieira",
  "phone": "(11) 99999-9999",
  "email": "his-email@email.com",
  "password": "password123"
}
```

---

<h3 id="post-writer-detail">POST /api/writers</h3>

**REQUEST**
```json
{
  "name": "Luiz Vieira",
  "phone": "(11) 99999-9999",
  "email": "his-email@email.com",
  "password": "password123",
  "course": "Computer Engineering",
  "ra": "00119999"
}
```

**RESPONSE**
```json
{
  "id": 1,
  "name": "Luiz Vieira",
  "phone": "(11) 99999-9999",
  "email": "his-email@email.com",
  "password": "password123",
  "course": "Computer Engineering",
  "ra": "00119999"
}
```

---

<h3 id="post-research-detail">POST /api/researches</h3>

**REQUEST**
```json
{
  "name": "Research Test",
  "description": "Description Test",
  "textFileName": "[blobText]",
  "writer": {
    "id": "1"
  },
  "collaborators": "Name of collabs"
}

```

**RESPONSE**
```json
{
  "id": 2,
  "name": "Research Test",
  "description": "Description Test",
  "blobFile": "[blobText]",
  "writer": {
    "id": 1,
    "name": "Luiz Vieira",
    "phone": "(11) 99999-9999",
    "email": "his-email@email.com",
    "password": "password123",
    "course": "Computer Engineering",
    "ra": "00119999"
  },
  "collaborators": "Name of collabs"
}
```

---

<h3 id="update-reader-detail">PUT /api/readers/{id}</h3>

**REQUEST**
```json
{
  "name": "Luiz Vieira",
  "phone": "(11) 99999-9999",
  "email": "updated-email@email.com",
  "password": "password123"
}
```

---

<h3 id="update-writer-detail">PUT /api/readers/{id}</h3>

**REQUEST**
```json
{
  "name": "Luiz Vieira",
  "phone": "(11) 99999-9999",
  "email": "updated-email@email.com",
  "password": "password123",
  "course": "Computer Engineering",
  "ra": "00119999"
}
```

<h2 id="colab">🤝 Collaborators</h2>

Special thank you for all people that contributed for this project.

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/LuizVieira11">
        <img src="https://avatars.githubusercontent.com/u/134332698?v=4" width="100px;" alt="Luiz Vieira Profile Picture"/><br>
        <sub>
          <b>Luiz Vieira</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/RafaSanDev">
        <img src="https://avatars.githubusercontent.com/u/101602882?v=4" width="100px;" alt="Rafael Santos Profile Picture"/><br>
        <sub>
          <b>Rafael Santos</b>
        </sub>
      </a>
    </td>
  </tr>
</table>