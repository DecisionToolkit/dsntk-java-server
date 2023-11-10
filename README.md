**DSNTK** | Java RPC server

# Java RPC server for Decision Toolkit

[![MIT licensed][mit-badge]][mit-url]
[![Apache 2.0 licensed][apache-badge]][apache-url]
[![Contributor Covenant][cc-badge]][cc-url]

[mit-badge]: https://img.shields.io/badge/License-MIT-blue.svg
[mit-url]: https://github.com/dsntk/dsntk-java-server/blob/main/LICENSE-MIT
[apache-badge]: https://img.shields.io/badge/License-Apache%202.0-blue.svg
[apache-url]: https://github.com/dsntk/dsntk-java-server/blob/main/LICENSE-APACHE
[cc-badge]: https://img.shields.io/badge/Contributor%20Covenant-2.1-4baaaa.svg
[cc-url]: https://github.com/dsntk/dsntk-java-server/blob/main/CODE_OF_CONDUCT.md

## Overview

[DMN™](https://www.omg.org/dmn) specification defines functionality that allows to call
external functions written in Java. Details can be found in the document
**Decision Model and Notation Version 1.4** on pages 117-118 (externally-defined functions).

While [Decision Toolkit](https://github.com/dsntk/dsntk.rs) (**DSNTK**)
is written in [Rust](https://www.rust-lang.org), then calling Java functions requires
an RPC (Remote Procedure Call) server. This project is a Java implementation of such server.

## Installation

Java RPC server can be downloaded from [releases](https://github.com/dsntk/dsntk-java-server/releases)
built from source or run in Docker container.

## Building from source

1. Clone this repository.
2. Install Java 17 or newer.
3. Install Maven.
4. Build:

```shell
$ mvn package
```

The **server-0.0.1.jar** can be found in **./target** directory

## Starting the server

```shell
$ java -jar server-0.0.1.jar
```

## Docker container

Docker container can be built and run using prepared script file:

```shell
$ ./container.sh
```

After building, the new container is started and ready to accept requests, try:

```shell
$ curl http://127.0.0.1:22023/api/rest/v1/system/info
```

The output should look like this:

```shell
{"data": {"name": "Java RPC server for Decision Toolkit","version": "0.0.1"}}
```

## Endpoints

- **GET** http://127.0.0.1:22023/api/rest/v1/system/info

  Utility endpoint for checking the connectivity with the running server.

- **POST** http://127.0.0.1:22023/api/rest/v1/rpc/evaluate

  This endpoint is used directly by **Decision Toolkit** to evaluate Java functions.

## License

Licensed under either of

- [MIT license](https://opensource.org/licenses/MIT) ([LICENSE-MIT][mit-url]) or
- [Apache License, Version 2.0](https://www.apache.org/licenses/LICENSE-2.0) ([LICENSE-APACHE][apache-url])

at your option.

## Contribution

Any contributions are greatly appreciated.
If you would like to get involved, please don't hesitate to reach out to us.
All contributions intentionally submitted for inclusion in the work by you,
shall be dual licensed as above, without any additional terms or conditions.
