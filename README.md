
# Hangman Game

This project is a **text-based Hangman game** developed in **Java**, as part of a course assignment to demonstrate object-oriented programming concepts.

The game runs in the terminal and follows the **classic Hangman rules**, including a final chance to guess the full word when no attempts remain.

---

## Game Rules

1. At the start of the game, a random word is selected from a text file.
2. The word is hidden and displayed using underscores (`_`) to represent unknown letters.
3. The player guesses one letter at a time.
4. If the guessed letter is correct, all its occurrences are revealed in the word.
5. If the guessed letter is incorrect, the player loses one attempt.
6. The player cannot guess the same letter more than once.
7. The game ends when:
   - the player reveals all letters of the word (**win**), or
   - the player runs out of attempts.
8. When no attempts remain and the word is not complete, the player is given **one final chance** to guess the entire word.
   - If the final guess is correct, the player wins.
   - Otherwise, the player loses and the correct word is revealed.

---

## Project Structure

HangmanGame/
- exception/      # Custom exceptions
- game/           # Game logic and state
- model/          # Domain model (Player, Word, WordProvider, etc.)
- util/           # Input utilities
- resources/      # Text files (word list)
- Main.java       # Application entry point
- README.md

---

## Object-Oriented Concepts Used

This project demonstrates the following concepts studied in class:

- **Packages** to organize the code
- **Interfaces** (`WordProvider`) to define contracts
- **Abstract classes** (`AbstractPlayer`) for shared behavior
- **Inheritance** and **polymorphism**
- **Encapsulation** and separation of responsibilities
- **Custom exceptions** for input validation

---

## How to Compile and Run

### Recommended method (keeps the source directory clean)

Compile all source files and place the generated `.class` files in a separate output directory:

If you have a SO which is one of these (Linux, macOS, WSL), run this:

```bash
javac -d out $(find . -name "*.java")
````
If you have a SO which is Windows, run this:

```bash
javac -d out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
````

Run the game (for all SO's):

```bash
java -cp out Main
```

## Notes

* The project must be run from the **root directory** so the game can access the word list located in `resources/words.txt`.
* Compiled `.class` files are **not included** in the repository, in accordance with the assignment requirements.
* Development was done on the `develop` branch.

---

## Author

* Maria Isabel Nicolau
* Henrique Kenji Matsusaki
* Eduardo Barros Guimarães
