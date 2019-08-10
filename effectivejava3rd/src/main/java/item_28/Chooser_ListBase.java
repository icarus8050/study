package item_28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Chooser에서 생기는 비검사 형변환 경고를 제거하기 위해서는 아래와 같이 리스트를 사용하면 된다.
 *
 * @param <T>
 */
public class Chooser_ListBase<T> {
    private final List<T> choiceList;

    public Chooser_ListBase(Collection<T>choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
