import java.util.StringTokenizer;
import java.util.Calendar;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    //take “mm/dd/yyyy” and create a Date object
    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        String day = st.nextToken();
        this.day = Integer.parseInt(day);
        String month = st.nextToken();
        this.month = Integer.parseInt(month);
        String year = st.nextToken();
        this.day = Integer.parseInt(year);
    }

    //create an object with today’s date (see Calendar class)
    public Date() {
        Calendar now = Calendar.getInstance();
        this.day = now.get(Calendar.DAY_OF_MONTH);
        this.month = now.get(Calendar.MONTH);
        this.year = now.get(Calendar.YEAR);
    }

    public boolean isValid() {
        //Check the month is valid
        if(this.month>12||this.month<1){
            return false;
        }

        //Check the date is valid
        Boolean dayValid = false;
        if(this.month==1||this.month==3||this.month==5||this.month==7||this.month==8||this.month==10||this.month==12){
            if(this.day<=31){
                dayValid=true;
            }
        }
        else if(this.month==4||this.month==6||this.month==9||this.month==11){
            if(this.day<=30){
                dayValid=true;
            }
        }
        else if(this.month==2){
            if(isLeapYear(this.year)){
                if(this.day<=29){
                    dayValid=true;
                }
            }
            else{
                if(this.day<=28){
                    dayValid=true;
                }
            }
        }
        if(!dayValid) {
            return false;
        }
        //Check the year is valid

        //Not too early or late
        Date now = new Date();
        if(this.year<1980||this.year>now.year){
            return false;
        }
        if(this.year==now.year){
            if(this.month>now.month){
                return false;
            }
            if(this.month==now.month){
                if(this.day>now.day){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int compareTo(Date date) {
        int theirDay = date.day;
        int theirMonth = date.month;
        int theirYear = date.year;
        if(theirYear>=this.year){
            if(theirYear>this.year){
                return 1;
            }
            //Same year
            else if (theirYear==this.year){
                if(theirMonth>this.month){
                    return 1;
                }
                else if(theirMonth==this.month){
                    if(theirDay>this.day){
                        return 1;
                    }
                    else if(theirDay==this.day){
                        return 0;
                    }
                }
            }
        }
        return -1;
    }
    private boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        if (year % 400 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[]args){
        //Tests of isValid()
    }

}