# iota.lib.scala

[![Build Status](https://travis-ci.org/ahab94/iota.lib.scala.svg?branch=dev)](https://travis-ci.org/ahab94/iota.lib.scala)
[![codecov](https://codecov.io/gh/ahab94/iota.lib.scala/branch/master/graph/badge.svg)](https://codecov.io/gh/ahab94/iota.lib.scala)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

This is the Scala library for the [IOTA Core APIs](https://iota.readme.io/reference). It's a simple scala wrapper around IOTA and allows to connect to a local or a remote IOTA node easily using it's Scala API interface.

The Scala wrapper around IOTA is designed to be thread-safe and kept as simple as possible in order to be easily maintainable, accordingly with the ongoing natural evolution of IOTA’s API. It provides the flexability to choose between API backends like `OkHTTP`, `Akka HTTP` and other native `STTP` syncronous and asyncronous API Backends depending on the concurrency needs of the Application. This unlocks the world of scala for IOTA Core.

It should be noted that the Scala Library as it stands right now is an early release. There might be some unexpected results.
Please let us know [here](https://github.com/ahab94/iota.lib.scala/issues).

## Installation

The IOTA Java library is available on [**jitpack.io**][jitpack].

### SBT Dependency

To use the IOTA Java library in your Maven build add this to your root `pom.xml` file:
```SCALA
resolvers += "jitpack" at "https://jitpack.io"
```

Add this in your module `pom.xml` file:
```SCALA
libraryDependencies += "com.github.ahab94" % "iota.lib.scala" % "0.3"	
```


# Getting Started

After you've successfully installed the library dependency, it is fairly easy to get started by simply creating a new IotaClient instance.

```SCALA
val iotaClient = new IotaClient() //This will hit http://localhost:14625
```

Connecting to your device's local node with the default settings and fetching the node info is quite easy...

```SCALA
val iotaCore = new IotaClient(IotaClientConfig(protocol = "http", host = "localhost", port = 14265))
val nodeInfo = iotaCore.getNodeInfo
```

For Asynchronous API calls

```SCALA
val iotaAsyncClient = new IotaAsyncClient()
val nodeInfo: Future[GetNodeInfoResponse] = iotaAsyncClient.getNodeInfo
``` 
Specifying `host`, `protocol` and `port` is done in similar fashion.
```SCALA
val iotaAsyncClient = new IotaAsyncClient(IotaClientConfig(protocol = "http", host = "localhost", port = 14265))
val nodeInfo: Future[GetNodeInfoResponse] = iotaAsyncClient.getNodeInfo
```

# Custom API Backends

This Iota Client Library supports the flexibility of using different API Backends of varying concurrency needs of different Applications.

Supported API Backends are listed below

Custom-Backend | Type | Class | Response wrapper	
--- | --- |  --- | --- 
Akka-Http | Async | `AkkaHttpBackend()` | `scala.concurrent.Future`
OkHttp-Future-Backend | Async  | `OkHttpFutureBackend()` | `scala.concurrent.Future	`
OkHttp-Backend | Sync  | `OkHttpBackend()` | None (Id)

## Using a Custom API Backend

Using a custom api backend is very simple...

Lets say you want to use OkHttp Async Backend

```SCALA
import com.softwaremill.sttp.okhttp.OkHttpFutureBackend
val iotaAsyncClient = new IotaAsyncClient(asyncApiBackend = Some(OkHttpFutureBackend()))
```

or Akka-Http Async Backend

```SCALA
import com.softwaremill.sttp.akkahttp.AkkaHttpBackend
val iotaAsyncClient = new IotaAsyncClient(asyncApiBackend = Some(AkkaHttpBackend()))
```

or OkHttp Sync Backend

```SCALA
import com.softwaremill.sttp.okhttp.OkHttpBackend
val iotaClient = new IotaClient(customApiBackend = Some(OkHttpBackend()))
```

Switching API Backends is that simple...

---
