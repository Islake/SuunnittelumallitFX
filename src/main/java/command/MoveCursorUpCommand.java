package command;

public class MoveCursorUpCommand implements Command {
    private Editor editor;

    public MoveCursorUpCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursor(0, -1);
    }

    @Override
    public void undo() {
        editor.moveCursor(0, 1);
    }

    @Override
    public void redo() {
        execute();
    }
}