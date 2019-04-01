public interface Loadable {
  public boolean matches(int[] data);
  public Loadable load(int[] data) throws LoadException;
}