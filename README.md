# Java Radix Binary Hash Tree Map

Hash value of key is used as binary tree radix branch values to store key-value pairs in a map.

Test conditions: 10M random non-negative integers in a flat array.

```
5800X single-thread/auto-vectorization
BinaryTreeMap PUT:   8.6s   1.17Mitems/s
BinaryTreeMap GET:   7.9s   1.26Mitems/s
BinaryTreeMap ALL:   2.1s   4.73Mitems/s
HashTable     PUT:   2.4s   4.14Mitems/s
HashTable     GET:   0.8s  12.70Mitems/s
HashTable     ALL:   0.8s  12.83Mitems/s
TreeMap       PUT:  11.9s   0.84Mitems/s
TreeMap       GET:  10.2s   0.98Mitems/s
TreeMap       ALL:   0.8s  12.41Mitems/s
```
