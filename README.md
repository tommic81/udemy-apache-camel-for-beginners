# Apache Camel for beginners

#### Simple Camel route

- Everything is a route
  - URI: `file:data/input?noop=true`
  - Part 1: `file->component` 
  - Part 2: `data/input->context path`
  - Part 3: `? -> Options`

```
from("file:data/input?noop=true")
```

##### Logging

- [https://camel.apache.org/components/latest/log-component.html](https://camel.apache.org/components/latest/log-component.html)
- Logging is enabled by adding one more destination with the log component.

```
from("file:data/input?noop=true")
.to("log:?level=INFO&showBody=true&showHeaders=true")
.to("file:data/output");
```

##### Exchange object

- `org.apache.camel.Exchange`
  - Exchange ID
  - Message Exchange Pattern (InOnly or InOut)
  - Exception
  - Properties
  - Message
- `org.apache.camel.Message`
  - Headers
  - Attachments
  - Body

##### Consumers and Producers

- Consumers wrap the payload and creates the exchange
- Event Driven Consumers
  - Reacts to events. Asynchronous consumers.
  - Jms, kafka
- Polling Consumer
  - Polls and reads the content from a source on a regular interval. Synchronous.
  - Polling a directory on a regular interval in a ftp server.
- Producer is an entity which can create and send a message to an endpoint 
- Producers convert the exchange according to the endpoint behind the scenes

##### Camel Architecture

- Camel Context
  - Route Engine - n number of routes
  - Components - jms, file, jdbc, kafka
  - Message Based Processors - used to transform and manipulate messages

#### Testing the Camel Route

- Dependency

```xml
<!--Test Dependencies-->

<dependency>
	<groupId>org.apache.camel</groupId>
    <artifactId>camel-test</artifactId>
    <version>2.20.1</version>
    <scope>test</scope>
 </dependency>
```

#### Why Camel

- [https://camel.apache.org/manual/latest/dsl.html](https://camel.apache.org/manual/latest/dsl.html)

#### Handling Errors

- Recoverable errors

  - Scheduled maintenance Activity
  - Some Temporary Network issues. 

- InRecoverable errors

  - Trying to connect to a data base which does not even exist.

  - Invalid Server - abc.db.com
  - Trying to make an api call to a Rest Endpoint which does not even exists

#### Apache ActiveMQ

Apache ActiveMQ is the most popular and powerful open source messaging server.

Step 1: Download Active MQ.

```
http://activemq.apache.org/activemq-5145-release.html
```

Step 2: Navigate to the bin directory and run the following command.

```
./activemq console
```

Step 3: Below link has the steps to run Active MQ in your machine.

```
http://activemq.apache.org/getting-started.html#GettingStarted-StartingActiveMQStartingActiveMQ
```

Step 4:

Console URL:

```
http://127.0.0.1:8161/admin/
```