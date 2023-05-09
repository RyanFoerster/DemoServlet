package be.technifutur.demoservletjava23.models;

import lombok.*;

@Builder @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Customiser {

    private Integer id;
    private String login;
    private String password;

    public Customiser(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
