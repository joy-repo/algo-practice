package test.tesco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShiftTimings {

  List<Shift> shiftList = new ArrayList<>() ;

  public ShiftTimings(){}

  public ShiftTimings(List<Shift> shifts){
    shiftList=shifts;
  }

  public void addShifts(Shift shift){
    shiftList.add(shift);
  }




  public static void main(String[] args) {


    List<Shift> shifts = new ArrayList<>();

    shifts.add(new Shift(8,10));
    shifts.add(new Shift(10,12));
    shifts.add(new Shift(11,13));
    shifts.add(new Shift(14,19));

  }

  public  List<Shift> getCollapsedShifts() {
    Collections.sort(shiftList);

    List<Shift> resList = new ArrayList<>();


    int prevEnd = shiftList.get(0).end;
    int prevStart = shiftList.get(0).start;

    for(int i = 1; i < shiftList.size(); i++){

      int currentStart = shiftList.get(i).start;
      if(currentStart<=prevEnd){
        prevEnd= Math.max(prevEnd, shiftList.get(i).end);// >shiftList.get(i).end ? prevEnd : shiftList.get(i).end;

      } else {
       //int end = prevEnd>shiftList.get(i-1).end ? prevEnd : shiftList.get(i-1).end;

        Shift s = new Shift(prevStart, prevEnd);
        resList.add(s);
        prevStart= shiftList.get(i).start;

        prevEnd= shiftList.get(i).end;
        i--;

      }

    }

    Shift s = new Shift(prevStart, prevEnd);
    resList.add(s);
    return resList;
  }
}
