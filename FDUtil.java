import java.util.Set;
import java.util.HashSet;

/**
 * This utility class is not meant to be instantitated, and just provides some
 * useful methods on FD sets.
 * 
 * @author <<YOUR NAME>>
 * @version <<DATE>>
 */
public final class FDUtil {

  /**
   * Resolves all trivial FDs in the given set of FDs
   * 
   * @param fdset (Immutable) FD Set
   * @return a set of trivial FDs with respect to the given FDSet
   */
  public static FDSet trivial(final FDSet fdset) {
    // TODO: Obtain the power set of each FD's left-hand attributes. For each
    // element in the power set, create a new FD and add it to the a new FDSet.

    return null;
  }

  /**
   * Augments every FD in the given set of FDs with the given attributes
   * 
   * @param fdset FD Set (Immutable)
   * @param attrs a set of attributes with which to augment FDs (Immutable)
   * @return a set of augmented FDs
   */
  public static FDSet augment(final FDSet fdset, final Set<String> attrs) {
    // TODO: Copy each FD in the given set and then union both sides with the given
    // set of attributes, and add this augmented FD to a new FDSet.

    return null;
  }

  /**
   * Exhaustively resolves transitive FDs with respect to the given set of FDs
   * 
   * @param fdset (Immutable) FD Set
   * @return all transitive FDs with respect to the input FD set
   */
  public static FDSet transitive(final FDSet fdset) {
    // TODO: Examine each pair of FDs in the given set. If the transitive property
    // holds on the pair of FDs, then generate the new FD and add it to a new FDSet.
    // Repeat until no new transitive FDs are found.

    return null;
  }

  /**
   * Generates the closure of the given FD Set
   * 
   * @param fdset (Immutable) FD Set
   * @return the closure of the input FD Set
   */
  public static FDSet fdSetClosure(final FDSet fdset) {
    // TODO: Use the FDSet copy constructor to deep copy the given FDSet

    // TODO: Generate new FDs by applying Trivial and Augmentation Rules, followed
    // by Transitivity Rule, and add new FDs to the result.
    // Repeat until no further changes are detected.

    return null;
  }

  /**
   * Generates the power set of the given set (that is, all subsets of
   * the given set of elements)
   * 
   * @param set Any set of elements (Immutable)
   * @return the power set of the input set
   */
  @SuppressWarnings("unchecked")
  public static <E> Set<Set<E>> powerSet(final Set<E> set) {

    // base case: power set of the empty set is the set containing the empty set
    if (set.size() == 0) {
      Set<Set<E>> basePset = new HashSet<>();
      basePset.add(new HashSet<>());
      return basePset;
    }

    // Recursive case

    // TODO: remove the first element from the current input set

    // TODO: recurse and obtain the power set of the reduced set of elements

    // TODO: iterate through all elements of current power set and union with first
    // element, then add all those sets to the power set you just obtained recursively.

    // TODO: Return the power set
    return null;
  }
}