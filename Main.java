import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    // One FD Set = A --> B, AB --> C
    FD f1 = new FD(Arrays.asList("A"), Arrays.asList("B")); // A --> B
    FD f2 = new FD(Arrays.asList("A", "B"), Arrays.asList("C")); // AB --> C
    FDSet fdset = new FDSet(f1, f2);
    System.out.println(FDUtil.fdSetClosure(fdset));

    // Another FD set: AB --> B, A --> BC, AB --> C
    FD g1 = new FD(Arrays.asList("A", "B"), Arrays.asList("B")); // AB --> B
    FD g2 = new FD(Arrays.asList("A"), Arrays.asList("C", "B")); // A --> BC
    FD g3 = new FD(Arrays.asList("A", "B"), Arrays.asList("C")); // AB --> C
    FDSet gdset = new FDSet(g1, g2, g3);
    System.out.println(FDUtil.fdSetClosure(gdset));

    // Test FD equality: fdset and gdset are equal iff their closures are equal
    System.out.println("Equals? " + (fdset.equals(gdset)));
  }
}
