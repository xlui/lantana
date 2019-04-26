# lantana

![GitHub](https://img.shields.io/github/license/xlui/lantana.svg?style=flat)
[![Build Status](https://travis-ci.org/xlui/lantana.svg?branch=master)](https://travis-ci.org/xlui/lantana)

A tool suite in Java.

As this is just a simple tool suite and have not been completed, I have not publish it to maven center repository. Instead, I have built the latest snapshot version under folder `mvn-repo`. In order to use it, you need add this repository in your `pom.xml`:

```xml
<repositories>
    <repository>
        <id>lantana-mvn-repo</id>
        <url>https://raw.githubusercontent.com/xlui/lantana/master/mvn-repo/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>app.xlui</groupId>
        <artifactId>lantana</artifactId>
        <version>0.1-SNAPSHOT</version>
    </dependency>
</dependencies>
```

And then use it!
