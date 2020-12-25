package sample;

public class player {
    String id;
    String name;
    int totalpoints = 0;
    int age;
    int stars = 0;
    double ballypos = 700;
    int ballstar = 0;
    String ballcol = "";

    public double getBallypos() {
        return ballypos;
    }

    public void setBallypos(double ballypos) {
        this.ballypos = ballypos;
    }

    public int getBallstar() {
        return ballstar;
    }

    public void setBallstar(int ballstar) {
        this.ballstar = ballstar;
    }

    public void savefunc(double y, int s){
        this.ballypos = y;
        this.ballstar = s;
    }

    player(String NAME , int AGE){
        this.name = NAME;
        this.age = AGE;
        idmaker();
    }

    public void idmaker(){
        String ID = getName() + Integer.toString(getAge()) + Integer.toString(database.currentnum);
        database.currentnum++;
        this.id = ID;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int bullets) {
        this.stars = stars;
    }

    public int getTotalpoints() {
        return totalpoints;
    }

    public void setTotalpoints(int totalpoints) {
        this.totalpoints = totalpoints;
    }

}
