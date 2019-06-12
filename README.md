# Potential kaocha --watch regression from versions 367 to 389

I experience `kaocha --watch` working with version 0.0-367, but not working with
version 389. This might be a regression, or I may be doing something wrong.

## Steps to reproduce

1. Set kaocha version in `deps.edn` to "0.0-389"
2. Run `bin/kaocha --watch` from the project root

## Expected behavior

Kaocha starts in watch mode.

```bash
# As observed with version 0.0-367
$ bin/kaocha --watch
Picked up _JAVA_OPTIONS: -Xmx2g
Picked up _JAVA_OPTIONS: -Xmx2g
Randomized with --seed 1631914331
[(..)]
2 tests, 2 assertions, 0 failures.
```

... and reloads and re-runs when I update files. Starts quite quickly.

## Observed behavior

Kaocha script hangs, not producing any output.

```
# As observed with version 0.0-389
$ bin/kaocha --watch
Picked up _JAVA_OPTIONS: -Xmx2g
Picked up _JAVA_OPTIONS: -Xmx2g
```

No observable effect after a minute of waiting. Hangs?

## System information

Running on Ubuntu Linux 18.04 LTS, window manager i3.

Java:

```
$ java -version
Picked up _JAVA_OPTIONS: -Xmx2g
openjdk version "1.8.0_212"
OpenJDK Runtime Environment (build 1.8.0_212-8u212-b03-0ubuntu1.18.04.1-b03)
OpenJDK 64-Bit Server VM (build 25.212-b03, mixed mode)
```
