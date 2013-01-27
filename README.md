# Pirate Paste

## Introduction

Pirate Paste is a simple web application that allows users to share snippets of text with other users of the site. It was built to be used as an introduction to web development using Java and the Stripesframework. 

The intent was to create a self contained, easy to work with project that can be used in a Java or web development class. 

If the student understands the full stack here and what is going on than they will be in good shape for moving to a larger code base or a different web stack. 

A few things to highlight:

*  [Stripes](http://stripesframework.org) uses Java Server Pages so this will fit within any course using the [Java EE Tutorial](http://docs.oracle.com/javaee/6/tutorial/doc/)
*  Dependency injection is achieved through using [Google Guice](https://code.google.com/p/google-guice/)
*  Database access is done using [Hibernate](http://www.hibernate.org/)
* [Maven](http://maven.apache.org/) is used for the build system

## Quick Start

Pirate Paste uses Maven, so starting it up locally is as easy as opening up a shell in the root of the application and typing

    $ mvn jetty:run

Open up a browser and navigate to `http://localhost:8080` to get started.


## Authors

* [@CaseyDunham](https://twitter.com/Caseydunham)
