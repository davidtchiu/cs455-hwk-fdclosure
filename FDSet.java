import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class represents a set of functional dependencies
 * 
 * @author David
 * @version 5/18/2022
 */
public class FDSet implements Iterable<FD> {
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
   * Copy constructor creates a deep copy (clone) of the given FD Set
   * 
   * @param original an FD Set to copy
   */
  public FDSet(FDSet original) {
    this.fdset = new TreeSet<>(original.getSet());
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
    this.fdset.addAll(other.fdset);
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
   * The default string representation is to have each FD appear on a separate
   * line.
   * 
   * @return a string representation of this FD set. One FD per line.
   */
  @Override
  public String toString() {
    return this.toString(true);
  }

  /**
   * Returns a string representation of this FD set. If line separated is desired,
   * each FD will be on its own line, tabbed over for prettier formatting:
   * [
   * fd1
   * fd2
   * ...
   * ]
   * 
   * Otherwise, the format will be: [fd1, fd2, ...]
   * 
   * @param linesep whether the FDs should be separated one per line
   * @return
   */
  public String toString(boolean linesep) {
    final String SEP = (linesep) ? "\n" : ", ";
    StringBuilder str = new StringBuilder();
    for (FD fd : this.fdset) {
      if (linesep) {
        str.append("\t");
      }
      str.append(fd);
      str.append(SEP);
    }
    if (str.length() > 0) {
      str.delete(str.length() - SEP.length(), str.length());
    }
    str.append((linesep) ? "\n]" : "]");
    str.insert(0, (linesep) ? "[\n" : "[");
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

  /**
   * For a for-each loop to be used
   * 
   * @return an iterator for the FD Set elements
   */
  @Override
  public Iterator<FD> iterator() {
    return this.fdset.iterator();
  }
}
