package item_28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * T가 무슨 타입인지 알 수 없으니 컴파일러가 이 형변환이 런타임에도 안전할지 알 수 없다는 메시지가 생긴다.
 * 제네릭은 실체화 불가 타입이므로 런타임에서는 타입에 대한 정보가 소거되기 떄문이다.
 *
 * @param <T>
 */
public class Chooser<T> {
    private final T[] choiceArray;

    public Chooser(Collection<T> choices) {
        choiceArray = (T[]) choices.toArray();
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
