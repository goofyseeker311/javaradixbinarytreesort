# Java Radix Binary Hash Tree Map

Hash value of key is used as binary tree radix branch values to store key-value pairs in a map.

Test conditions: 10M random non-negative integers in a flat array.

```
5800X single-thread/auto-vectorization
BinaryTreeMap ADD:   8.4s   1.19Mitems/s
BinaryTreeMap GET:   7.6s   1.32Mitems/s
BinaryTreeMap ALL:   2.1s   4.84Mitems/s
HashTable     ADD:   2.3s   4.40Mitems/s
HashTable     GET:   0.8s  13.05Mitems/s
HashTable     ALL:   0.8s  13.12Mitems/s
TreeMap       ADD:  12.8s   0.78Mitems/s
TreeMap       GET:  11.0s   0.91Mitems/s
TreeMap       ALL:   0.6s  17.59Mitems/s
```
