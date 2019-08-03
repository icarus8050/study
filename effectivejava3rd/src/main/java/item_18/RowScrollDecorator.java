package item_18;

public class RowScrollDecorator extends DisplayDecorator {

    public RowScrollDecorator(Display decoratedDisplay) {
        super(decoratedDisplay);
    }

    @Override
    public void draw() {
        super.draw();
        drawScroll();
    }

    public void drawScroll() {
        System.out.println("가로 스크롤");
    }
}
