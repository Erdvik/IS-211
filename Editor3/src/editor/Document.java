/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.util.LinkedList;

import editor.display.CharacterDisplay;

/**
 * This class represents the document being edited. Using a 2d array to hold the
 * document content is probably not a very good choice. Fixing this class is the
 * main focus of the exercise. In addition to designing a better data model, you
 * must add methods to do at least basic editing: write and delete text, and
 * moving the cursor
 *
 * @author evenal
 */
public class Document {

    private CharacterDisplay display;
    private int cursorRow;
    private int cursorCol;
    LinkedList<Character> cCol = new LinkedList<>();
    LinkedList<Character> cRow = new LinkedList<>();

    public Document(CharacterDisplay display) {
        this.display = display;
        cursorCol = cursorRow = 0;
    // Fill the list to avoid IndexOutOfBoundsException
        int i = 0;
        int j = 0;
         while (i <= 1000) {
            cRow.add(' ');
            i++;
          }

          while (j <= 1000) {
              cCol.add(' ');
              j++;
          }
    }

    public void insertChar(char c) {

        cRow.add(cursorRow, c);
        cCol.add(cursorCol, c);
        display.displayChar(c, cursorRow, cursorCol);
        display.displayCursor(' ',cursorRow, cursorCol);

        cursorCol++;
        if (cursorCol >= CharacterDisplay.WIDTH) {
            cursorCol = 0;
            cursorRow++;
        }
            
    }

    public void deleteChar(char c) {
        cursorCol--;
        display.displayChar(' ', cursorRow, cursorCol);
        display.displayCursor(' ',cursorRow, cursorCol);    
    }

    public void moveUp() {
        cursorRow--;
        display.displayCursor(' ', cursorRow, cursorCol);
    }

    public void moveDown() {
        cursorRow++;
        display.displayCursor(' ', cursorRow, cursorCol);
    }

    public void moveRight() {
        cursorCol++;
        display.displayCursor(' ', cursorRow, cursorCol);
    }

    public void moveLeft() {
        cursorCol--;
        display.displayCursor(' ', cursorRow, cursorCol);
    }

}

