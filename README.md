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
```
src
├── com.adobe.aem  
         ├── Controllers
         │   └── RomanNumeral Controller
         └── Exceptions
         │   └── Custom Exception Handler 
         │   └── Exception Response 
         ├── Models
         │   └── Conversions
         ├── Service
         │   └── Roman Convertor Service 
         ├── Utilities
         │   └── Rules Interface
         │   └── Rules Implementation 
         └── Adobe AEM Application 
```
