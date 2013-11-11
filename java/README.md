Java Enumerable
----

This is a project to implement .NET style enumerable functions on deferred lazy collections using Java.

The goal, to provide

- Map
- Filter
- FlatMap
- OrderBy
- Take
- TakeWhile
- Skip
- SkipWhile

Functionality that can serve as a general base for functional programming in Java (using JDK 8 with lambdas).

Example
---

Currently you can already do this using the following example:

```java
List<String> strings = asList("oooo", "ba", "baz", "booo");            
                                                                       
Enumerable<String, String> items = Enumerable.init(strings)            
                                             .orderBy(i -> i.length());
                                                                       
for(String x : items){                                                 
    System.out.println(x);                                             
}                                                                      
```

And stuff like

```java
List<Integer> items = Enumerable.init(strings)            
                                .orderBy(i -> i.length()) 
                                .map(i -> i.length())     
                                .toList();                
```
