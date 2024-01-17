package turing;

/**
 * Represents a Turing machine tape using a doubly-linked list of cells.
 * Each cell holds a character and has pointers to the next and previous cells.
 */
public class Tape {
    private Cell currentCell;

    /**
     * Constructs a tape with a single cell initially containing a blank space.
     * Sets the current cell pointer to point to this initial cell.
     */
    public Tape() {
        currentCell = new Cell();
        currentCell.content = ' ';
        currentCell.next = null;
        currentCell.prev = null;
    }

    /**
     * Returns the pointer that points to the current cell.
     *
     * @return The current cell pointer.
     */
    public Cell getCurrentCell() {
        return currentCell;
    }

    /**
     * Returns the character from the current cell.
     *
     * @return The character in the current cell.
     */
    public char getContent() {
        return currentCell.content;
    }

    /**
     * Changes the character in the current cell to the specified value.
     *
     * @param ch The character to set in the current cell.
     */
    public void setContent(char ch) {
        currentCell.content = ch;
    }

    /**
     * Moves the current cell one position to the left along the tape.
     * If the current cell is the leftmost cell that exists, adds a new cell to the left.
     * The content of the new cell is a blank space.
     */
    public void moveLeft() {
        if (currentCell.prev == null) {
            Cell newCell = new Cell();
            newCell.content = ' ';
            newCell.prev = null;
            newCell.next = currentCell;
            currentCell.prev = newCell;
        }
        currentCell = currentCell.prev;
    }

    /**
     * Moves the current cell one position to the right along the tape.
     * If the current cell is the rightmost cell that exists, adds a new cell to the right.
     * The content of the new cell is a blank space.
     */
    public void moveRight() {
        if (currentCell.next == null) {
            Cell newCell = new Cell();
            newCell.content = ' ';
            newCell.next = null;
            newCell.prev = currentCell;
            currentCell.next = newCell;
        }
        currentCell = currentCell.next;
    }

    /**
     * Returns a String consisting of the characters from all cells on the tape,
     * read from left to right, excluding leading or trailing blank characters.
     * The current cell pointer remains unchanged after this method is called.
     *
     * @return The tape contents as a String.
     */
    public String getTapeContents() {
        Cell temp = currentCell;
        while (temp.prev != null) {
            temp = temp.prev;
        }
        StringBuilder tapeContents = new StringBuilder();
        boolean leadingBlank = true;

        while (temp != null) {
            if (temp.content != ' ') {
                leadingBlank = false;
                tapeContents.append(temp.content);
            } else if (!leadingBlank || temp.next == null) {
                // If not a leading blank or it's the last cell, include the space
                tapeContents.append(temp.content);
            }
            temp = temp.next;
        }
        return tapeContents.toString();
    }
}

