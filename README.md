# Java Radix Binary Tree Sort and Merge Sort

Radix binary tree sort and merge sort implemented in Java.
Implementations compared to the default Arrays.sort sort run times.
BinaryTree and MergeSort are not optimized in code.
BinaryTree is a map which uses key-value mappings.

Test conditions: 1K/1M/100M random non-negative integers in a flat array.
For binary tree, integers are pre-converted to byte arrays.
```
Test setup: 1K/1M/100M
Arrays.sort: 1ms/323ms/59s
BinaryTree: 3ms/632ms/130s
MergeSort: 1ms/515ms/151s
```
