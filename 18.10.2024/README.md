# Simple SBT project for Scala 3

## Running the "main program"

There code of a sample "main program" can be found in the `src/scala/Main.scala` file. To run them from the SBT command prompt issue one of the following command:

```
run
```

## Scalafmt

The project also contains a configuration for the [`Scalafmt`](https://scalameta.org/scalafmt/) tool, which can be used to automatically format the source code.

To check wheather the code requires any adjustments, from the SBT commandline, issue the following command:

```
scalafmtCheck
```

To actually apply the needed changes invoke:

```
scalafmt
```


