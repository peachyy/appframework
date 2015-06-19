# Overview #

appframework is a java web application framework based [spring-framework](http://www.springsource.org/spring-framework)

appframework is for the Java programming language.

## visit http://appframework.jiucai.org/ for lastest. ##

appframework features:
  * all dao and service class has its parent class
  * all http request param is wrapped in Map
  * provides asynchronous calls of service/dao for http request
  * provides page/data/download/upload interface to light your code
  * provides listeners wrapped for you to filter http request
  * supports html/xml/json result for ajax request
  * provides basic encode and encrypt methods, such as MD5,base64,zip
  * provides wrapped log for log4j and common-logging
  * provides common utils , such as DateTimeUtil, ConfigUtil, IpUtil, EscapeUtil, DomainUtil, SwfUtil ...
  * provides [fusioncharts](http://www.fusioncharts.com/) java bean wrapped classes


# Requirements #

appframework requires:

  * JDK 1.6 or higher
  * spring-framework 4.1.x
  * servlet 3.0+ , tomcat 7+
  * third party jar files defined in pom.xml which stored in the central repository

## Develop Requirements ##

Eclispe 3.6+

[m2eclipse plugins](http://www.eclipse.org/m2e/download/)

# Download and Installation #

Releases are available in the central repository.
The current stable release of appframework: **2.1.0**

#### Download links: ####
source: http://code.google.com/p/appframework/source/browse/

JAR package: http://repo2.maven.org/maven2/org/jiucai/appframework/2.1.0/appframework-2.1.0.jar

Repository: http://search.maven.org/#search|ga|1|org.jiucai


#### Maven project configuration: ####

Edit your project pom.xml and add :

```
<dependency>
    <groupId>org.jiucai</groupId>
    <artifactId>appframework</artifactId>
    <version>2.1.0</version>
</dependency>
```


# Development and bug reports #

You may check out the appframework source code from google [SVN repository](http://code.google.com/p/appframework/source/checkout) or [Git repository](https://github.com/jiucai/appframework)

You may also [browse](http://code.google.com/p/appframework/source/browse/) the appframework source code.

If you find a bug in appframework, please [report a bug](http://code.google.com/p/appframework/issues/entry).

You may review open bugs through [the list of open issues](http://code.google.com/p/appframework/issues/list).


Feel free to improve the [documentation](http://code.google.com/p/appframework/w/list).

# History #

2.1.0 Stable version based spring-framework 4.1.1 (**Recommand upgrade to this version**)

2.0.0 Stable version based spring-framework 4.1.0


# Author and copyright #

The appframework library is developed by the team of developers and it is based on spring framework.

appframework is released under the Apache 2.0 license.