public class IDCreator {
  public static void main(String[] args) {
    OptionProcessor op = new OptionProcessor();
    op.add(new StringOption("-n", "Full Name", ""));
    op.add(new StringOption("-u", "userID", ""));
    op.add(new StringOption("-g", "G#", ""));
    op.add(new StringOption("-lec", "Lecture section", ""));
    op.add(new StringOption("-lab", "Lab section", ""));
    op.process(args);
    System.out.println(op);
  }
}