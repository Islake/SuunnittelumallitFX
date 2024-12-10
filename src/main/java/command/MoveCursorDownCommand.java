package command;

public class MoveCursorDownCommand implements Command {
    private Editor editor;

    public MoveCursorDownCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursor(0, 1);
    }

    @Override
    public void undo() {
        editor.moveCursor(0, -1);
    }

    @Override
    public void redo() {
        execute();
    }
}