# Kotlin Sample With GSON

[![Kotlin](https://github.com/paulocoutinhox/kotlin-gson-sample/actions/workflows/kotlin.yml/badge.svg)](https://github.com/paulocoutinhox/kotlin-gson-sample/actions/workflows/kotlin.yml)

Im trying to decode a JSON string with reitified type passed to a serializer interface.

The expected return value is the expected type passed as generic.

The error is when decode happen, GSON library convert it to `LinkedTreeMap` instead of the type passed.

The main file with sample is here: [src/main/kotlin/Main.kt](src/main/kotlin/Main.kt)

The error:

```bash
> Task :run FAILED
Exception in thread "main" java.lang.ClassCastException: class com.google.gson.internal.LinkedTreeMap cannot be cast to class Request (com.google.gson.internal.LinkedTreeMap and Request are in unnamed module of loader 'app')
        at MainKt.main(Main.kt:36)
        at MainKt.main(Main.kt)
```

The code:

```kotlin
val finalValue = callSerializer<Request<String>>("{\"r\": \"test\"}")
println("Decoded data is: $finalValue")
```

How to run:

```bash
make run
```
