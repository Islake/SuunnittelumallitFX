package command;

public class TogglePixelCommand implements Command {
    private Editor editor;

    public TogglePixelCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.togglePixel();
    }

    @Override
    public void undo() {
        editor.togglePixel();
    }

    @Override
    public void redo() {
        execute();
    }
}