# Java Radix Binary Hash Tree Map

Hash value of key is used as binary tree radix branch values to store key-value pairs in a map.

Test conditions: 10M random non-negative integers in a flat array.

```
5800X single-thread/auto-vectorization
BinaryTreeMap ADD:  8.5s  1.17Mitems/s
BinaryTreeMap GET:  2.0s  5.09Mitems/s
```
