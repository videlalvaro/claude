# claude

A Clojure library designed to ease integration with Cloud Foundry

NOTE: Work In Progress

## Continuous Integration Status

[![Continuous Integration status](https://secure.travis-ci.org/videlalvaro/claude.png)](http://travis-ci.org/videlalvaro/claude)

## Usage

With leiningen add it to your project dependencies like this:

    [claude "0.2.1-SNAPSHOT"]

And with Maven you can do:

```xml
<dependency>
    <groupId>claude</groupId>
    <artifactId>claude</artifactId>
    <version>0.2.1-SNAPSHOT</version>
</dependency>
```

Then on your code you can use it this way:

```clojure
(ns my.namespace
  (require: [claude.core :as cf]
            [claude.mongodb :as cfm]
            [claude.rabbitmq :as cfr]
            [langohr.core  :as lhc]
            [monger.core :as mg]))

(defonce default-url "mongodb://127.0.0.1/mydb")

(defn mongo-connect []
  (if (cf/cloudfoundry?)
    (mg/connect-via-uri! (cfm/url))
    (mg/connect-via-uri! default-url)))

(defn rabbitmq-connect []
  (if (cf/cloudfoundry?)
    (lhc/connect (lhc/settings-from (cfr/url)))
    (lhc/connect)))

(defonce ^Connection conn (rabbitmq-connect))
```

## TODO

- Add a proper `groupId` for the Maven repositories
- Improve Integration with Cloud Foundry services

## Credits

The original version of this library was based on this [blog post](http://sunng.info/blog/2012/01/clojure-on-cloudfoundry/).

## License

Copyright © 2012 Alvaro Videla

See the LICENSE file.
