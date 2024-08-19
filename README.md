# SQL Injection SAST Puzzle

The project is a simple Java application that demonstrates a SQL Injection vulnerability. Manual review of the source
code will reveal the vulnerability; however, at the time of publication multiple SAST tools have been unable to identify
the vulnerability.

The project is being published as a puzzle to test your SAST tooling. The project is built with Gradle:

```bash
./gradlew build --info
```

## Demonstrating the Issue

The source code contains two entry points, one for a command line application and one for a web application. The command
line application is the easiest way to demonstrate the SQL Injection vulnerability. The command line application takes
a query string that is used to build a SQL Query. The query string is not sanitized, and the SQL Query is built by
concatenating the `where` clause in the query string into a SQL Statement. 

While it is easy to trace the code in a debugger (see [AppTest.java](https://github.com/jeremylong/sast-puzzle/blob/main/app/src/test/java/org/sample/app/AppTest.java)), it is also possible
to see that SQL Injection occurs by running the command:

```bash
./gradle build
java -cp app/build/libs/app.jar org.sample.app.App 'Name=users&Where=field%20like%20%27%25%27'
```
