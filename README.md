
| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Yueyihan Qi                |
| Date         | 5/2/2024                   |
| Course       | Spring                     |
| Assignment # | Final Project              |

# Assignment Overview
This project is an exam management system that allows administrators to create and manage exams, and enables students to participate in these exams. The main classes in the system include Exam, Student, Proctor, and QuestionFactory. The Exam class is responsible for creating and managing exam instances, including managing exam status, adding and removing questions, and grading student answers. The Student class represents students participating in exams, which can receive notifications about exam status changes. The Proctor class is the manager of exams, responsible for starting and ending exams, and can receive notifications about exam status changes, as well as save and restore exam states. The QuestionFactory interface and its implementation class, ConcreteQuestionFactory, are used to create different types of questions, such as single-choice, multiple-choice, fill-in-the-blank, and essay questions. The entire system uses the observer pattern to implement notifications and updates of exam statuses. With this system, administrators can easily create and manage exams, students can participate in exams and receive corresponding feedback, and proctors can effectively manage the exam process.

# GitHub Repository Link:
https://github.com/{YOUR_USERNAME}/cs-665-assignment-{ASSIGNMENT_NUMBER}

# Implementation Description 


For each assignment, please answer the following:

- Explain the level of flexibility in your implementation, including how new object types can
be easily added or removed in the future.

The implementation exhibits a high level of flexibility. New object types, such as new question types, can be easily added by creating a new class implementing the `QuestionProduct` interface and updating the `ConcreteQuestionFactory` class to create instances of the new question type. Similarly, existing object types can be removed by simply removing their corresponding classes and updating the factory accordingly. This modular approach allows for seamless extension and modification of the system without affecting existing code.

- Discuss the simplicity and understandability of your implementation, ensuring that it is
easy for others to read and maintain.

The implementation prioritizes simplicity and understandability to ensure that it is easy for others to read and maintain. Classes and methods are named descriptively, following standard Java naming conventions. Design decisions are documented in comments throughout the codebase, providing clear explanations of functionality and rationale behind implementation choices. Additionally, the separation of concerns, such as having distinct classes for exam management, student management, and question creation, contributes to the clarity and comprehensibility of the codebase.

- Describe how you have avoided duplicated code and why it is important.

Duplicated code is avoided through the use of abstraction and encapsulation. For example, the `QuestionFactory` interface and its implementation classes centralize the creation of question objects, eliminating the need to duplicate creation logic across multiple classes. This not only improves code maintainability but also reduces the risk of introducing inconsistencies and errors when making changes.

- If applicable, mention any design patterns you have used and explain why they were
chosen.

Factory Method Pattern: Employed in the creation of exam questions using the QuestionFactory interface and its implementations (ConcreteQuestionFactory). This pattern decouples the creation of question objects from their usage, allowing for easy extension with new question types.

Memento Pattern: Utilized for the storage and restoration of exam states in the Exam class. This pattern enables the system to revert to previous configurations of exams, providing a mechanism for managing exam status.

Decorator Pattern: Utilized for tracking time during exam sessions using the TimerDecorator class. This pattern adds functionality to the Exam class dynamically, allowing for the management of exam time.

Observer Pattern: Implemented for notification of exam status changes to all observers, including students and proctors. This pattern facilitates communication between objects in the system, ensuring that relevant entities are notified about changes in exam status.


# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/) on your system. 

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains information about the project, such as its dependencies, the build configuration, and the plugins used for building and packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports, and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile
Type on the command line: 

```bash
mvn clean compile
```



## JUnit Tests
JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:
```bash
mvn clean test
```


## Spotbugs 

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


## Checkstyle 

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on any issues or violations of the coding standards defined in its configuration. This includes issues like code style, code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices, making it easier for other developers to read and maintain. It can also help to identify potential issues before the code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser. 

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`




