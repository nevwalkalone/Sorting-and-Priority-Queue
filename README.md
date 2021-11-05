# Sorting Algorithms and Priority Queue Implementation

This project was completed for the Data Structures course of the [Department of Computer Science of the Athens University of Economics and Business](https://www.dept.aueb.gr/el/cs), during the Fall semester of 2019-2020.

The goal of this assignment was to get acquainted with **sorting algorithms and priority queues**. It consists of 5 Parts.

More specifically, this project addresses issues encountered in optimization problems regarding the allocation of memory resources for storing large volumes of data.
Suppose you want to place all contents of a
set of N folders and files on hard disks with a capacity of a 1 TB each (consider, for example,
creating backups to a file management system). Assume that all folders are between 0 and
1,000,000 MB (1 TB) in size. The restriction we have is that each folder must be saved entirely
on one disk. Ideally, the best solution would be to use as few hard drives as possible. This
problem is an example of the well-known “Bin Packing” problem, for which we do not yet know
if there is an efficient algorithm that can always find the best solution. However, we can design
efficient methods of approaching the optimal solution.

## Useful Reads

For a full overview it is highly suggested that you read:

- [Project Assignment](assignment-report/project2-assignment.pdf), that contains all the details about the data types implementation and the application.
- [Project Report](assignment-report/project2-report.pdf), that contains the analysis of the code.

## Dependencies

- [Java (jdk13)](https://www.oracle.com/java/technologies/javase/jdk13-archive-downloads.html)

## Summary

### <ins>Part A</ins>

In this part 2 Abstract Data Types were implemented.

- [Disk](src/Disk.java) ADT that will represent a 1 TB size disk.
- [Priority Queue](src/MaxPQ.java) ADT.

### <ins> Part B</ins>

In this part the following storage algorithm, called Greedy, was implemented.

Process the folders one by one in the order in which they appear. If a
folder fits on one of the disks you have already used so far, save it to the disk with the most free
space. Otherwise, if it does not fit on anyone, use a new disk and save the file there.

[Greedy.java](src/Greedy.java) program will contain a main method which will first read the file sizes from a
txt file in order to be able to execute the algorithm. Each line of the file will represent the size of
a folder in MB, so it needs to be an integer between 0 and 1,000,000. This algorithm must make use of the Priority Queue that was created in Part A.

For more, check [Useful Reads](#Useful-Reads).

### <ins> Part C</ins>

It is important to note that the solution of the Greedy algorithm is not always optimal. In this part a 2nd algorithm, called **Greedy-Decreasing**, is implemented.

This algorithm is implemented by arranging the folders in descending order and then applying the Greedy algorithm. Mergesort was used as as sorting method, found in [Sort.java](src/Sort.java).

### <ins> Part D</ins>

In this part a little experimental evaluation is done to determine which
algorithm is best in practice. [RandomInput.java](src/RandomInput.java) is used to randomly generate input data for at least 3 different values of the number of folders. [AlgorithmComp.java](src/AlgorithmComp.java) compares the two algorithms based on this input data.

### <ins> Part E</ins>

A [Report](assignment-report/project2-report.pdf) was also prepared, in order to explain how each of the Parts A-D was completed.

## Usage

- Firstly, clone this repository.

  ```console
  git clone https://github.com/nevwalkalone/Sorting-and-Priority-Queues.git
  ```

- Change Directory to src

  ```console
  cd src
  ```

- To run the Greedy program, compile it and execute it

  ```console
  javac Greedy.java
  java Greedy path_to_file\filename
  ```

- To compare Greedy and Greedy Decreasing algorithms, run RandomInput.java to randomly generate input data, and then run AlgorithmComp.java.

  ```console
  javac RandomInput.java
  java RandomInput
  javac AlgorithmComp.java
  java AlgorithmComp
  ```
