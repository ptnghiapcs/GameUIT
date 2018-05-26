package apcs.gameuit;

public class DairyEntry {
    String dairyname;
    int res;
    String dairydate;

    DairyEntry(String name, String date, int res)
    {
        dairydate=name;
        dairydate=date;
        this.res=res;
    }

    public int getRes() {
        return res;
    }

    public String getDairydate() {
        return dairydate;
    }

    public String getDairyname() {
        return dairyname;
    }
}
