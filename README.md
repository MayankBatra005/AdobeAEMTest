# AdobeAEMTest

### Problem Statement
To build us a web service that takes in a number and outputs a Roman numeral.
- <b>Extension 1:</b> with a resource integer (permitted range as 1 - 255)
- <b>Extension 2:</b> using mutlithreading to generate multiple roman numeral for a range of values.

### Technology Stack 
- Programming language: JAVA 8
- Frameworks used :<br>
  - Springboot for developing restful webservice,<br>
  - Project lombok for removing boylerplate code (Like getters, setters, constructor)<br>
  - Logging is done using SLF4j (Simple Logging Facade for Java)<br>
  - Junit for Unit testing<br>  

- Build Tool: Maven 

### Project Structure 
```src
├───── Main
|	├── com.adobe.aem  
|		├── Controllers
│		|   └── RomanNumeral Controller
│         	└── Exceptions
│         	│   └── Custom Exception Handler 
│         	│   └── Exception Response 
│         	├── Models
│         	│   └── Conversions
│         	├── Service
│         	│   └── Roman Convertor Service 
│         	├── Utilities
│         	│   └── Rules Interface
│         	│   └── Rules Implementation 
│         	└── Adobe AEM Application 
│
├───── Test 
|	├── com.adobe.aem
|		├── Controllers
│		|   └── RomanNumeral Controller Test
```

### WebService End points
- Integer End point
- Range End point 

### Integer End Point 
```
Curl 
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/romannumeral?integer={integer}'

Request URL
http://localhost:8080/romannumeral?integer={integer}

Request Headers
{
  "Accept": "*/*"
}

Model Schema 
[
  {
    "input": "string",
    "output": "string"
  }
]

Sample Response Body for integer 1
{
input: "1",
output: "I"
}

```

### Range End point
```
Curl 
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/romannumeral?min=1&max=10'

Request URL
http://localhost:8080/romannumeral?min={integer}&max={integer}

Request Headers
{
  "Accept": "*/*"
}

Model Schema 
[
  {
    "input": "string",
    "output": "string"
  }
]

Sample Response Body for range 1-2
[
  {
    "input": "1",
    "output": "I"
  },
  {
    "input": "2",
    "output": "II"
  }
]


```

### How to Run the project
There are two ways to run the webservices:
- Running via importing the project using pom.xml 
- Running the project by downloading the jar from releases folder

### System Requirements
- JAVA 8 or higher installed in the system
- IntelliJ installed in the system with support for Maven.

### Running the project via importing the project using POM.xml.

- Download the project code from [Git Repo](https://github.com/MayankBatra005/AdobeAEMTest)
- Import the project in IntelliJ using the pom.xml
- Let the dependencies being build by maven 
- Once dependencies are build, run the project using the <b>AdobeAemApplication.java</b> class

### Running the project by downloading the jar from [releases folder](https://github.com/MayankBatra005/AdobeAEMTest/tree/main/Releases)

- Download the jar 
- Open the terminal in Mac or Command prompt in Windows
- Execute the following command
```
java -jar aem-0.0.1-SNAPSHOT.jar 
```

The server would turn up on port 8080 by default. If port 8080 is unavailable please run the following command:

```
java -jar -d server.port=<Any Available Port> aem-0.0.1-SNAPSHOT.jar 

example 

java -jar -d server.port=8001 aem-0.0.1-SNAPSHOT.jar 

```

### Running Junit Test Cases 
Junit test cases can be executed by following steps:
- Download the project code from [Git Repo](https://github.com/MayankBatra005/AdobeAEMTest)
- Import the project in IntelliJ using the pom.xml
- Let the dependencies being build by maven 
- Once dependencies are build, run the Junit test cases using the <b>RomanNumeralTest</b> class
- Right click and run as RomanNumeralTest.
