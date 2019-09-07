package item_33;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FavoritesMain {

    public static void main(String[] args) {
        Favorites favorites = new Favorites();

        favorites.putFavorite(String.class, "Java");
        favorites.putFavorite(Integer.class, 123);
        favorites.putFavorite(Class.class, Favorites.class);

        String favoriteString = favorites.getFavorite(String.class);
        int favoriteInt = favorites.getFavorite(Integer.class);
        Class<?> favoriteClass = favorites.getFavorite(Class.class);

        System.out.printf("%s %d %s%n", favoriteString, favoriteInt, favoriteClass.getName());
    }
}
