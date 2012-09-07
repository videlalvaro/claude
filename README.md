# claude

A Clojure library designed to ease integration with Cloud Foundry

NOTE: Work In Progress

## Usage

With leiningen add it to your project dependencies like this:

    [claude "0.1.0-SNAPSHOT"]

And with Maven you can do:

```xml
<dependency>
    <groupId>claude</groupId>
    <artifactId>claude</artifactId>
    <version>0.1.0-SNAPSHOT</version>
</dependency>
```

Then on your code you can use it this way:

```clojure
(ns my.namespace
  (use: [claude.core :as cf]
        [langohr.core  :as lhc]
        [monger.core :as mg]))

(defonce default-url "mongodb://127.0.0.1/mydb)

(defn mongo-connect []
  (if (cf/cloudfoundry?)
    (mg/connect-via-uri! (cf/mongo-url))
    (mg/connect-via-uri! default-url)))

(defn rabbitmq-connect []
  (if (cf/cloudfoundry?)
    (lhc/connect (lhc/settings-from (cf/rabbit-url)))
    (lhc/connect)))

(defonce ^Connection conn (rabbitmq-connect))
```

## TODO

- Add a proper `groupId` for the Maven repositories
- Improve Integration with Cloud Foundry services
- Improve API for obatining services credentials/info

## Credits

The code is based on this [blog post](http://sunng.info/blog/2012/01/clojure-on-cloudfoundry/).

## License

Copyright © 2012 Alvaro Videla

See the LICENSE file.
