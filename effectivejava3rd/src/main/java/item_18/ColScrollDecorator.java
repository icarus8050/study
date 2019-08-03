package item_18;

public class ColScrollDecorator extends DisplayDecorator {

    public ColScrollDecorator(Display decoratedDisplay) {
        super(decoratedDisplay);
    }

    @Override
    public void draw() {
        super.draw();
        drawScroll();
    }

    public void drawScroll() {
        System.out.println("세로 스크롤");
    }
}
