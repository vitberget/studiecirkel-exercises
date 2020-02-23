## Matrix
Given a string representing a matrix of numbers, return the rows and columns of that matrix.

So given a string with embedded newlines like:
```
9 8 7
5 3 2
6 6 7
```
Representing this matrix:
```
    1  2  3
  |---------
1 | 9  8  7
2 | 5  3  2
3 | 6  6  7
```
Your code should be able to spit out:
* A list of the rows, reading each row left-to-right while moving top-to-bottom across the rows.
* A list of the columns, reading each column top-to-bottom while moving from left-to-right.
<!-- things -->
The rows for out example matrix:
* 9, 8, 7
* 5, 3, 2
* 6, 6, 7
<!-- things -->
And it's columns:
* 9, 5, 6
* 8, 3, 6
* 7, 2, 7