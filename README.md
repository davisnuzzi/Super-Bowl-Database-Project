# Super Bowl Database Project

A console-based Java application for exploring Super Bowl history and maintaining a small dataset.
Users can browse scores, winners, MVPs, and other details or append new information to the dataset.

## Project Structure

```
├── README.md
├── Super_Bowl_Project_Test.java  # JUnit tests (requires JUnit 5)
└── SB_Database_Project/
    └── Super_Bowl_Database_Mini_Project/
        ├── Driver.java              # Application entry point
        ├── startMenu.java           # Menu-driven interface
        ├── pageOne.java ... pageEight.java  # Menu pages
        ├── AddSuperBowl.java        # Add new Super Bowl data
        ├── FileInput.java           # Load data from text files
        ├── roman_to_integer.java    # Roman numeral conversion
        ├── superbowl-information.txt # Super Bowl dataset
        └── teams.txt                # List of teams
```

## Getting Started

### Requirements

- Java Development Kit (JDK) 8 or later
- JUnit 5 (optional, for running tests)

### Downloading

```bash
git clone https://github.com/<your-username>/SB-Project-Version1.0.git
cd SB-Project-Version1.0
```

### Building and Running

```bash
javac SB_Database_Project/Super_Bowl_Database_Mini_Project/*.java
cd SB_Database_Project/Super_Bowl_Database_Mini_Project
java Driver
```

The program opens an interactive menu. Enter the number of the topic you want to explore. Option 9 allows you to append new information to the dataset.

## Tests

The repository includes a JUnit test suite (`Super_Bowl_Project_Test.java`). To compile and run the tests you'll need JUnit 5 in your classpath:

```bash
javac -cp .:junit-platform-console-standalone.jar Super_Bowl_Project_Test.java
java  -cp .:junit-platform-console-standalone.jar Super_Bowl_Project_Test
```

## Future Work

This is an early version of the project. Planned improvements include richer UI, persistent storage, and expanded dataset.
