package jogamp.opengl.glu.nurbs;

/**
 * Class replacing C language pointer
 *
 * @author Tomas Hrasky
 *
 */
public class CArrayOfArcs {
  /**
   * Underlaying array
   */
  private Arc[] array;

  /**
   * Pointer to array member
   */
  private int pointer;

  /**
   * Don't check for array borders?
   */
  private boolean noCheck = true;

  /**
   * Makes new CArray
   *
   * @param array
   *            underlaying array
   * @param pointer
   *            pointer (index) to array
   */
  public CArrayOfArcs(Arc[] array, int pointer) {
    this.array = array;
    // this.pointer=pointer;
    setPointer(pointer);
  }

  /**
   * Makes new CArray from other CArray
   *
   * @param carray
   *            reference array
   */
  public CArrayOfArcs(CArrayOfArcs carray) {
    this.array = carray.array;
    // this.pointer=carray.pointer;
    setPointer(carray.pointer);
  }

  /**
   * Makes new CArray with pointer set to 0
   *
   * @param ctlarray
   *            underlaying array
   */
  public CArrayOfArcs(Arc[] ctlarray) {
    this.array = ctlarray;
    this.pointer = 0;
  }

  /**
   * Returns element at pointer
   *
   * @return element at pointer
   */
  public Arc get() {
    return array[pointer];
  }

  /**
   * Increases pointer by one (++)
   */
  public void pp() {
    // pointer++;
    setPointer(pointer + 1);
  }

  /**
   * Sets element at pointer
   *
   * @param f
   *            desired value
   */
  public void set(Arc f) {
    array[pointer] = f;

  }

  /**
   * Returns array element at specified index
   *
   * @param i
   *            array index
   * @return element at index
   */
  public Arc get(int i) {
    return array[i];
  }

  /**
   * Returns array element at specified index relatively to pointer
   *
   * @param i
   *            relative index
   * @return element at relative index
   */
  public Arc getRelative(int i) {
    return array[pointer + i];
  }

  /**
   * Sets value of element at specified index relatively to pointer
   *
   * @param i
   *            relative index
   * @param value
   *            value to be set
   */
  public void setRelative(int i, Arc value) {
    array[pointer + i] = value;
  }

  /**
   * Lessens pointer by value
   *
   * @param i
   *            lessen by
   */
  public void lessenPointerBy(int i) {
    // pointer-=i;
    setPointer(pointer - i);
  }

  /**
   * Returns pointer value
   *
   * @return pointer value
   */
  public int getPointer() {
    return pointer;
  }

  /**
   * Sets ponter value
   *
   * @param pointer
   *            pointer value to be set
   */
  public void setPointer(int pointer) {
    if (!noCheck && pointer > array.length)
      throw new IllegalArgumentException("Pointer " + pointer
                                         + " out of bounds " + array.length);
    this.pointer = pointer;
  }

  /**
   * Raises pointer by value
   *
   * @param i
   *            raise by
   */
  public void raisePointerBy(int i) {
    // pointer+=i;
    setPointer(pointer + i);
  }

  /**
   * Lessens ponter by one (--)
   */
  public void mm() {
    // pointer--;
    setPointer(pointer - 1);
  }

  /**
   * Returns underlaying array
   *
   * @return underlaying array
   */
  public Arc[] getArray() {
    return array;
  }

  /**
   * Sets underlaying array
   *
   * @param array
   *            underlaying array
   */
  public void setArray(Arc[] array) {
    this.array = array;
  }
}
