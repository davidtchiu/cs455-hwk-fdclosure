import java.util.Set;
import java.util.TreeSet;

/**
 * This class represents a set of functional dependencies
 * 
 * @author David
 * @version 5/18/2022
 */
public class FDSet {
  private Set<FD> fdset;

  /**
   * Constructs an empty functional dependency set
   * 
   * @param fds a variable list of FDs
   */
  public FDSet(FD... fds) {
    // we use a TreeSet to ensure FDs are sorted when printed
    this.fdset = new TreeSet<>();
    for (FD f : fds) {
      this.fdset.add(f);
    }
  }

  /**
   * Adds a functional dependency to the set
   * 
   * @param fd Reference to a functional dependency
   */
  public void add(FD fd) {
    this.fdset.add(fd);
  }

  /**
   * Unions this FD set with another
   * 
   * @param fdset Reference to another FD set
   */
  public void addAll(FDSet other) {
    this.fdset.addAll(other.getSet());
  }

  /**
   * Deletes a functional dependency from the set
   * 
   * @param fd Reference to a functional dependency
   */
  public void remove(FD fd) {
    this.fdset.remove(fd);
  }

  /**
   * @return the Set of functional dependencies
   */
  public Set<FD> getSet() {
    return this.fdset;
  }

  /**
   * @return the number of FDs stored in this set
   */
  public int size() {
    return this.fdset.size();
  }

  /**
   * @return a deep copy of this functional dependency set
   */
  @Override
  public Object clone() {
    FDSet clone = new FDSet();
    for (FD fd : this.fdset) {
      clone.add((FD) fd.clone());
    }
    return clone;
  }

  /**
   * @return a string representation of this FD set
   */
  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    for (Object f : this.fdset) {
      str.append(f + "\n");
    }
    return str.toString();
  }

  /**
   * Two FDs are logically equivalent iff their closures are equal.
   * 
   * @param other Reference to another FD set
   * @return true if logically equivalent to the given FDset
   */
  @Override
  public boolean equals(Object other) {
    FDSet otherFDset = (FDSet) other;
    return FDUtil.fdSetClosure(this).getSet().equals(FDUtil.fdSetClosure(otherFDset).getSet());
  }
}
