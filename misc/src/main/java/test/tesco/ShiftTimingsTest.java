package test.tesco;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShiftTimingsTest {


  @Test
  public void testShifts(){

    ShiftTimings st = new ShiftTimings();

    System.currentTimeMillis();


    st.addShifts(new Shift(8,12));
    st.addShifts(new Shift(6,13));
    st.addShifts(new Shift(14,19));
    st.addShifts(new Shift(23,7));
    st.addShifts(new Shift(2, 5));


    //2-4, 6-13, 8-12

    List<Shift> expectedList = new ArrayList<>();

    expectedList.add(new Shift(2,4));
    expectedList.add(new Shift(6,13));
    expectedList.add(new Shift(14,19));
    expectedList.add(new Shift(8,10));

    List<Shift> actualResult = st.getCollapsedShifts();

    System.out.println(actualResult);

    System.out.println(actualResult.equals(expectedList));

    Assert.assertTrue(actualResult.equals(expectedList));

  }


  public void testShifts1(){

    ShiftTimings st = new ShiftTimings();


    st.addShifts(new Shift(8,10));
    st.addShifts(new Shift(10,12));
    st.addShifts(new Shift(11,13));
    st.addShifts(new Shift(14,19));

    List<Shift> expectedList = new ArrayList<>();

    expectedList.add(new Shift(8,13));
    expectedList.add(new Shift(14,19));

    List<Shift> actualResult = st.getCollapsedShifts();

    System.out.println(actualResult.equals(expectedList));

    Assert.assertTrue(actualResult.equals(expectedList));

  }

}
