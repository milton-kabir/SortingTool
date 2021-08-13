# Sorting tool

In the modern world, data has become so abundant that processing it is no easy business. How can anyone make sense of all these words and numbers? This program processes textual and numeric data and sorts it. This program will be able to determine the biggest or most frequent pieces of data and perform the necessary calculations on them. Data is waiting to be sorted!

Let's also add a new sorting type that is often rather useful: sorting by count, a type of sorting that arranges the elements by number of occurrences.

We will use the universal -`sortingType` argument.

The result of sorting by count should be pairs `(count, dataEntry)` sorted by the count value.

Command-line arguments to support the sorting type definition:

1. if the -sortingType argument is provided, it should be followed by natural or byCount, which defines the sorting type.
2. if the argument is not provided, then consider natural to be the default sorting type.

`Note: for strings (words and lines), natural order is lexicographic order, for numbers it is numeric order.`

Add exception handling for possible errors and output error messages to the console:

1. if the -sortingType argument is provided but the type is not, print a message No sorting type defined!
2. if the -dataType argument is provided but the type is not, print No data type defined!
3. if unknown command-line arguments are provided, print "-arg" is not a valid parameter. It will be skipped. for each unknown argument -arg;
4. if there are strings in the input, but the data type is defined as long, print "abc" is not a long. It will be skipped. for each string abc from the input.

Sometimes it's useful to read data that is from a file, rather than from the standard input, and write the result to another file instead of printing it to the console.

Command-line arguments parsing to support the -inputFile and -outputFile arguments.

1.  If -inputFile is provided followed by the file name, read the input data from the file.

2.  If -outputFile is provided followed by the file name, output only the error messages to the console and print the results to the file.

## Example

Example 1, for sorting longs by count:

    > 1 -2   33 4
    > 42
    > 1                 1

    Total numbers: 7.
    -2: 1 time(s), 14%
    4: 1 time(s), 14%
    33: 1 time(s), 14%
    42: 1 time(s), 14%
    1: 3 time(s), 43%

Example 2, for sorting numbers naturally:

    > 1 -2   33 4
    > 42
    > 1                 1

    Total numbers: 7.
    Sorted data: -2 1 1 1 4 33 42

Example 3, for sorting words naturally:

    > 1 -2   33 4
    > 42
    > 1                 1

    Total words: 7.
    Sorted data: -2 1 1 1 33 4 42

Example 4, for sorting lines naturally:

    > 1 -2   33 4
    > 42
    > 1                 1

    Total lines: 3
    Sorted data:
    1                 1
    1 -2   33 4
    42
Example 5: sorting numbers naturally without errors

    $> java SortingTool -sortingType natural -dataType long
    > 1 -2   33 4
    > 42
    > 1                 1

    Total numbers: 7.
    Sorted data: -2 1 1 1 4 42 333

Example 6: sorting numbers by count without errors

    $> java SortingTool -sortingType byCount -dataType long
    > 1 -2   33 4
    > 42
    > 1                 1

    Total numbers: 7.
    -2: 1 time(s), 14%
    4: 1 time(s), 14%
    33: 1 time(s), 14%
    42: 1 time(s), 14%
    1: 3 time(s), 43%

Example 7: missing sorting type

    $> java SortingTool -sortingType

    No sorting type defined!

Example 8: missing data type

    $> java SortingTool -dataType

    No data type defined!

Example 9: invalid arguments and input value

    $> java SortingTool -dataType long -sortingType natural -abc -def
    "-abc" is not a valid parameter. It will be skipped.
    "-def" isn not a valid parameter. It will be skipped.
    > a 2 -42
    "a" is not a long. It will be skipped.

    Total numbers: 2.
    Sorted data: -42 2

Example 10: input file is defined

    java SortingTool -sortingType byCount -inputFile input.txt

Example 11: input and output files are defined

    java SortingTool -sortingType byCount -inputFile data.dat -outputFile out.txt