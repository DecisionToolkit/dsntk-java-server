**dsntk** | ÐecisionToolkit

# Java RPC server

[![MIT licensed][mit-badge]][mit-url]
[![Apache 2.0 licensed][apache-badge]][apache-url]
[![Contributor Covenant][cc-badge]][cc-url]

[mit-badge]: https://img.shields.io/badge/License-MIT-blue.svg
[mit-url]: https://opensource.org/licenses/MIT
[mit-license-url]: LICENSE-MIT
[apache-badge]: https://img.shields.io/badge/License-Apache%202.0-blue.svg
[apache-url]: https://www.apache.org/licenses/LICENSE-2.0
[apache-license-url]: LICENSE
[apache-notice-url]: NOTICE
[cc-badge]: https://img.shields.io/badge/Contributor%20Covenant-2.1-4baaaa.svg
[cc-url]: https://github.com/DecisionToolkit/dsntk-java-server/blob/main/CODE_OF_CONDUCT.md
[DMN]: https://www.omg.org/dmn
[ÐecisionToolkit]: https://github.com/DecisionToolkit
[Rust]: https://www.rust-lang.org
[releases]: https://github.com/DecisionToolkit/dsntk-java-server/releases

## Overview

The [DMN]™ specification defines functionality that allows calling externally defined functions,
including those implemented in Java. More details can be found in the official specification under
the chapter _"Externally-defined functions"_. Since [ÐecisionToolkit] is implemented in [Rust],
invoking Java functions requires a Remote Procedure Call (RPC) server.
This project provides a Java implementation of such an RPC server.

## Installation

The RPC server for Java can be downloaded from [releases], built from source or run in Docker container.

## Building from source

1. Install Java 25 or newer.
2. Install Maven.
3. Clone this repository.
4. Build the server:

```shell
mvn package
```

The `server-1.0.0.jar` can be found in `./target` directory

## Starting the server

```shell
java -jar server-1.0.0.jar
```

## Docker container

Docker container can be built and run using prepared script file:

```shell
./scripts/container.sh
```

After building, the new container is started and ready to accept requests. Try:

```shell
curl http://127.0.0.1:22023/api/rest/v1/system/info
```

The output should look like this:

```shell
{"data":{"name":"Java RPC server for ÐecisionToolkit","version":"1.0.0"}}
```

To get a pretty-printed JSON, try:

```shell
curl -s http://127.0.0.1:22023/api/rest/v1/system/info | jq
```

Expected output:

```json
{
  "data": {
    "name": "Java RPC server for ÐecisionToolkit",
    "version": "1.0.0"
  }
}
```

## Endpoints

- **GET** http://127.0.0.1:22023/api/rest/v1/system/info

  Utility endpoint for verifying connectivity with the running server.

- **POST** http://127.0.0.1:22023/api/rest/v1/rpc/evaluate

  Endpoint directly used by **ÐecisionToolkit** to evaluate Java functions in compliance with the DMN specification.

## License

Licensed under either of

- [MIT license][mit-url] (see [LICENSE-MIT][mit-license-url]) or
- [Apache License, Version 2.0][apache-url] (see [LICENSE][apache-license-url] and [NOTICE][apache-notice-url])

at your option.

## Contribution

Any contributions are greatly appreciated. If you would like to get involved,
please don't hesitate to reach out to us. All contributions intentionally submitted
for inclusion in the work by you, shall be dual licensed as above, without any additional
terms or conditions.
