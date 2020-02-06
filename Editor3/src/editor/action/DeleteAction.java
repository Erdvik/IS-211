package editor.action;

import java.awt.event.ActionEvent;

import editor.Document;
import editor.Editor;

public class DeleteAction extends EditorAction {
    Editor editor;

    public DeleteAction(String name, Editor ed) {
        super(name);
        this.editor = ed;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Document doc = editor.getDocument();
        char ch = ae.getActionCommand().charAt(0);
        doc.deleteChar(ch);
    }
}
