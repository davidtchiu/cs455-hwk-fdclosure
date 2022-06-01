import java.util.Set;
import java.util.TreeSet;
import java.util.List;

/**
 * This class represents a functional dependency
 * 
 * @author David
 * @version 5/18/2022
 */
public class FD implements Comparable<FD> {

  private Set<String> left;
  private Set<String> right;

  /**
   * Creation of an empty functional dependency
   */
  public FD() {
    this.left = new TreeSet<>();
    this.right = new TreeSet<>();
  }

  /**
   * Creation of a functional dependency
   * 
   * @param left  An attribute set on the left
   * @param right An attribute set on the right
   */
  public FD(Set<String> left, Set<String> right) {
    this.left = new TreeSet<>(left);
    this.right = new TreeSet<>(right);
  }

  /**
   * Creation of a functional dependency
   * 
   * @param left  A list of attributes on the left
   * @param right A list of attributes on the right
   */
  public FD(List<String> left, List<String> right) {
    this.left = new TreeSet<>(left);
    this.right = new TreeSet<>(right);
  }

  /**
   * @return the attribute set on the left hand side of the FD
   */
  public Set<String> getLeft() {
    return this.left;
  }

  /**
   * @return the attribute set on the right hand side of the FD
   */
  public Set<String> getRight() {
    return this.right;
  }

  /**
   * Adds a set of attributes to the left-hand side
   * 
   * @param attrs Set of attributes
   */
  public void addToLeft(Set<String> attrs) {
    this.left.addAll(attrs);
  }

  /**
   * Adds a set of attributes to the right-hand side
   * 
   * @param attrs Set of attributes
   */
  public void addToRight(Set<String> attrs) {
    this.right.addAll(attrs);
  }

  /**
   * Tests whether the left-hand side contains the given set of attributes
   * 
   * @param attrs Set of attributes
   * @return true if all atributes are contained on the left
   */
  public boolean leftContains(Set<String> attrs) {
    return this.left.containsAll(attrs);
  }

  /**
   * Tests whether the right-hand side contains the given set of attributes
   * 
   * @param attrs Set of attributes
   * @return true if all atributes are contained on the right
   */
  public boolean rightContains(Set<String> attrs) {
    return this.right.containsAll(attrs);
  }

  /**
   * Tests whether this FD is trivial
   * 
   * @return true if all attributes on right are contained in left
   */
  public boolean isTrivial() {
    return this.left.containsAll(this.right);
  }

  /**
   * @return a deep copy of this functional dependency
   */
  @Override
  @SuppressWarnings("unchecked")
  public Object clone() {
    Set<String> leftCpy = (TreeSet<String>) ((TreeSet<String>) this.left).clone();
    Set<String> rightCpy = (TreeSet<String>) ((TreeSet<String>) this.right).clone();
    return new FD(leftCpy, rightCpy);
  }

  /**
   * Tests whether two FDs are equal
   */
  @Override
  public boolean equals(Object other) {
    return 0 == this.compareTo((FD) other);
  }

  /**
   * @return a string representaation of this FD
   */
  @Override
  public String toString() {
    return this.left.toString() + " --> " + this.right.toString();
  }

  /**
   * Compares two functional dependencies for prettier printing
   * 
   * @param other
   * @return Value < 0 if size of left-hand side of this FD is smaller, otherwise,
   */
  @Override
  public int compareTo(FD other) {
    // first, sort by left set size
    int diffL = this.left.size() - other.left.size();
    if (0 != diffL) {
      return diffL;
    }

    // left set size are the same, attempt to sort left lexicographically
    int diffL2 = this.left.toString().compareTo(other.left.toString());
    if (0 != diffL2) {
      return diffL2;
    }

    // left hand sides are equal, sort right lexicographically
    int diffR = this.right.size() - other.right.size();
    if (0 != diffR) {
      return diffR;
    }
    return this.right.toString().compareTo(other.right.toString());
  }
}