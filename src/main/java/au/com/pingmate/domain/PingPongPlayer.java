package au.com.pingmate.domain;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;

//import org.apache.openelo.Player;
//import org.hibernate.annotations.Type;

//@Entity
//@Table(name ="PINGPONG_PLAYER")
public class PingPongPlayer {// implements Player<Integer> {

//    @Id
//    @Column(name="PLAYER_ID")
//    @GeneratedValue
    private Integer identifier;
    
//    @Column(name = "PLAYER_NAME")
    private String name;
    
//    @Column(name = "PLAYER_RANKING")
    private double ranking;
    
//    @Column(name = "RESIGNED_FLAG")
//    @Type(type = "yes_no")
    private boolean resigned;

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRanking() {
        return ranking;
    }

//    @Override
    public void updateRanking(Double aDouble) {
        setRanking(aDouble);
    }

    public void setRanking(double ranking) {
        this.ranking = ranking;
    }

    public boolean isResigned() {
        return resigned;
    }

    public void setResigned(boolean resigned) {
        this.resigned = resigned;
    }
}
