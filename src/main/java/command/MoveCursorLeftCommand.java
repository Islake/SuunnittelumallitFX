package command;

public class MoveCursorLeftCommand implements Command {
    private Editor editor;

    public MoveCursorLeftCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursor(-1, 0);
    }

    @Override
    public void undo() {
        editor.moveCursor(1, 0);
    }

    @Override
    public void redo() {
        execute();
    }
}