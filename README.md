# Spring Hello World.

## Initial Setup



https://spring.io/quickstart


Download JDK and add path to enviroment variable.

```bash
ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation.
```

https://www.oracle.com/java/technologies/downloads/



```bash
# mac
./gradlew bootRun

# windows
.\gradlew.bat bootRun

# status
.\gradlew.bat --status

# stop
.\gradlew.bat --stop

# after updating dependency
./gradlew build


./gradlew dependencies
.\gradlew.bat --dependencies
```




```bash
F:\code\web\hello-spring\hello>.\gradlew.bat bootRun

Welcome to Gradle 8.11.1!

Here are the highlights of this release:
 - Parallel load and store for Configuration Cache
 - Java compilation errors at the end of the build output
 - Consolidated report for warnings and deprecations

For more details see https://docs.gradle.org/8.11.1/release-notes.html

Starting a Gradle Daemon, 1 incompatible Daemon could not be reused, use --status for details

FAILURE: Build failed with an exception.

* What went wrong:
Could not determine the dependencies of task ':bootRun'.
> Could not resolve all dependencies for configuration ':runtimeClasspath'.
   > Failed to calculate the value of task ':compileJava' property 'javaCompiler'.
      > Cannot find a Java installation on your machine matching this tasks requirements: {languageVersion=17, vendor=any vendor, implementation=vendor-specific} for WINDOWS on x86_64.
         > No locally installed toolchains match and toolchain download repositories have not been configured.

* Try:
> Learn more about toolchain auto-detection at https://docs.gradle.org/8.11.1/userguide/toolchains.html#sec:auto_detection.
> Learn more about toolchain repositories at https://docs.gradle.org/8.11.1/userguide/toolchains.html#sub:download_repositories.
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
> Get more help at https://help.gradle.org.

BUILD FAILED in 7s
```


```bash
java -version
java version "23.0.1" 2024-10-15
Java(TM) SE Runtime Environment (build 23.0.1+11-39)
Java HotSpot(TM) 64-Bit Server VM (build 23.0.1+11-39, mixed mode, sharing)
```



```bash
F:\code\web\hello-spring\hello>.\gradlew.bat bootRun
Starting a Gradle Daemon, 1 busy and 2 incompatible and 2 stopped Daemons could not be reused, use --status for details
<-------------> 0% CONFIGURING [3s]
> root project > Resolve files of configuration 'classpath'

















> Task :compileJava
F:\code\web\hello-spring\hello\src\main\java\mm\com\software100\springhello\hello\HelloApplication.java:14: error: cannot find symbol
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
                         ^
  symbol:   class RequestParam
  location: class HelloApplication
F:\code\web\hello-spring\hello\src\main\java\mm\com\software100\springhello\hello\HelloApplication.java:13: error: cannot find symbol
        @GetMapping("/hello")
         ^
  symbol:   class GetMapping
  location: class HelloApplication
2 errors

> Task :compileJava FAILED
[Incubating] Problems report is available at: file:///F:/code/web/hello-spring/hello/build/reports/problems/problems-report.html

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':compileJava'.
> Compilation failed; see the compiler output below.
  F:\code\web\hello-spring\hello\src\main\java\mm\com\software100\springhello\hello\HelloApplication.java:14: error: cannot find symbol
      public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
                           ^
    symbol:   class RequestParam
    location: class HelloApplication
  F:\code\web\hello-spring\hello\src\main\java\mm\com\software100\springhello\hello\HelloApplication.java:13: error: cannot find symbol
        @GetMapping("/hello")
         ^
    symbol:   class GetMapping
    location: class HelloApplication
  2 errors

* Try:
> Check your code and dependencies to fix the compilation error(s)
> Run with --scan to get full insights.

BUILD FAILED in 10s
1 actionable task: 1 executed
```

## 2025-01-03 Spring Basic

- [x] Basic API 
- [x] Basic CRUD API
- [x] Basic Data Structure
- [x] Basic html template rendering
- [x] Basic Database and ORM
- [ ] User authentication
- [ ] User authorization
- [ ] Layered architecture for RESTFul Webservices ( Middleware, Routing, Request Validation, Controller, Services, ORM, )


*** Dependency တွေ ပြင်ပြီးသွားရင် gradle stop လုပ်ပြီးမှ ပြန် run သင့်တယ် ***


### Layerd Architecture

- Controller Layer: Manages HTTP requests and responses.
- Service Layer: Contains business logic.
- Repository Layer: Handles data access and database interactions.


User authentication အတွက် ဘာတွေ လုပ်ကြမလဲ?

- [x] User Entity
- [x] User Repository
- [x] User Service
- [ ] User Controller


that's all for basic operations.

and then 
- [ ] JWT Dependency
- [ ] Configure Spring Security
- [ ] Create JWT Utility Class
- [ ] Create a JWT Filter
- [ ] Register the JWT Filter
- [ ] Test the Authentication


basic endpoints

- [ ] register -> POST
- [ ] login -> POST
- [ ] profile -> GET
- [ ] update user -> PUT
- [ ] delete user -> DELETE



security config ချဖို့ တိုင်ပတ်နေတယ်။
Official ရေးထုံးကိုလည်း မတွေ့ဘူး ဖြစ်နေတယ်။


```bash
Description:

Field bCryptPasswordEncoder in mm.com.software100.springhello.hello.services.UserService required a bean of type 'org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder' that could not be found.

The injection point has the following annotations:
        - @org.springframework.beans.factory.annotation.Autowired(required=true)


Action:

Consider defining a bean of type 'org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder' in your configuration.
```
