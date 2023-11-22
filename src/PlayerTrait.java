// Bruce

/**
 * A interface to facilitate the creation of arbitrary player traits. All traits
 * must have some value that is set and/or returned. The specifics are
 * irrelevant and all setters and getters should be wrapped by the methods
 * below. PlayerTraits mush also include a public static String KEY to allow for
 * uniform access to the values inside of various data structures.
 * 
 * @param <E> generic type
 */
public interface PlayerTrait<E> {
    public E getTraitValue();

    public void setTraitValue(E value);
}
