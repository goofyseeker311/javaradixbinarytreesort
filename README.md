# Java Radix Binary Hash Tree Map

Hash value of key is used as binary tree radix branch values to store key-value pairs in a map.

Test conditions: 30M random non-negative integers in a flat array.

```
5800X single-thread/auto-vectorization
BinaryTreeMap PUT:  32.2s  0.93Mitems/s
BinaryTreeMap GET:   5.9s  5.09Mitems/s
```
