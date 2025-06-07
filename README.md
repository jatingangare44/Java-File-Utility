# Java File Handling Utility

## 📋 Description
This Java application allows users to perform **file handling operations** such as writing, reading, and modifying text files through a console-based menu interface.

## 🚀 Features
- ✅ Write content to a text file (append or overwrite)
- 📄 Read file content with line numbers
- ✏️ Modify specific words in a file
- 🗂️ Automatically creates a backup before modifying
- 🧾 Easy-to-navigate user menu with helpful prompts

## 🛠️ Technologies Used
- Java SE (Standard Edition)
- Java I/O (BufferedReader, BufferedWriter, FileReader, FileWriter)
- `java.util.Scanner` for user input

## 📦 How to Run
1. Save the file as `FileUtility.java` inside a package named `task_1`.
2. Compile the file:
    ```bash
    javac task_1/FileUtility.java
    ```
3. Run the program:
    ```bash
    java task_1.FileUtility
    ```

## 📄 Function Descriptions

### `writeFile(String filePath, String content, boolean append)`
Writes content to the specified file. Supports appending if `append` is set to true.

### `readFile(String filePath)`
Reads and prints file content with line numbers. Checks for file existence.

### `modifyFile(String filePath, String target, String replacement)`
Replaces all occurrences of `target` with `replacement`. Creates a `.bak` backup file before modifying.

### `main(String[] args)`
Runs an interactive console menu for choosing operations (write, read, modify, or exit).

## 🥇 Output
![Image](https://github.com/user-attachments/assets/cc576252-bc37-49d2-98d3-64dc9921f7a9)

## 🧑‍💻 Author
Developed by **Jatin Gangare**

## 📜 License
This project is licensed for educational use.
