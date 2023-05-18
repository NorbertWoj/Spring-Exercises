package app.domain;

import org.springframework.stereotype.Component;

@Component
public class PlayerInformation {


    private int id;

    private String username;

    private String password;

    private boolean enabled;


    public PlayerInformation() {
    }

    public PlayerInformation(String username, String password) {
        this.username = username;
        this.password = password;
        this.enabled = true;
    }

    private int gold = 0;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
