/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor.action;

import editor.Document;
import editor.Editor;
import java.awt.event.ActionEvent;

/**
 * This is an example of an action class. You will have to add more. They should
 * call one of the editing methods in the document.
 *
 * @author evenal
 */
public class MoveAction extends EditorAction {

    Editor editor;
    String direction;

    public MoveAction(String name, String dir, Editor ed) {
        super(name);
        this.editor = ed;
        this.direction = dir;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Document doc = editor.getDocument();
        switch(direction) {

            case "LEFT": doc.moveLeft();
            break;

            case "RIGHT": doc.moveRight();
            break;

            case "UP": doc.moveUp();
                break;

            case "DOWN": doc.moveDown();
                break;
        }
    }
}