# Reverse K-Group Linked List

An iterative Java implementation that reverses a singly linked list in consecutive groups of **k** nodes while preserving the order of any remaining nodes.

## Overview

Given a singly linked list and an integer `k`, the program reverses the links of each complete group of `k` nodes.

- Only node links are changed; node values are not modified.
- If the final group contains fewer than `k` nodes, it remains unchanged.
- The implementation uses an iterative pointer-based approach.

## Features

- Reverses nodes in groups of a configurable size.
- Keeps an incomplete final group in its original order.
- Handles `k = 1` without changing the list.
- Uses constant auxiliary space for the reversal operation.
- Accepts input from the command line.

## Requirements

- Java Development Kit (JDK) installed.
- A terminal or command prompt.

Check your Java installation:

```bash
java -version
javac -version
```

## Getting Started

Clone the repository:

```bash
git clone https://github.com/iamsayanmanna/Reverse-K-Group-Linked-List.git
cd Reverse-K-Group-Linked-List
```

Compile and run:

```bash
javac Main.java
java Main
```

## Input Format

Enter the values in this order:

1. Number of nodes.
2. The node values, separated by spaces.
3. The group size `k`.

The program accepts:
- Number of nodes: `1` to `5000`
- Node values: `0` to `1000`
- Group size: `1` to the number of nodes

## Example

**Input**

```text
5
1 2 3 4 5
2
```

**Output**

```text
Enter number of nodes: Enter 5 node values:
Enter k: Original Linked List:
1 -> 2 -> 3 -> 4 -> 5
Linked List after reversing in groups of 2:
2 -> 1 -> 4 -> 3 -> 5
```

## Algorithm

The reversal is performed group by group:

1. Use a dummy node to simplify handling changes to the head.
2. Locate the kth node from the node before the current group.
3. If a complete group of k nodes is unavailable, stop.
4. Reverse the current group's links.
5. Connect the reversed group to the preceding and following parts of the list.
6. Continue with the next group.

## Complexity Analysis

Let `n` be the number of nodes.

| Measure | Complexity |
| --- | --- |
| Time | `O(n)` |
| Auxiliary space | `O(1)` |

Each node is visited a constant number of times, and the reversal uses a fixed number of pointer variables.

## Project Structure

```text
Reverse-K-Group-Linked-List/
├── Main.java
└── README.md
```

## License

No license has currently been specified for this repository.
