package be.technifutur.demoservletjava23.dtos;

import be.technifutur.demoservletjava23.models.Customiser;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConnectedCustomiserDto {

    private Integer id;
    private String login;

    public static ConnectedCustomiserDto fromEntity(Customiser customiser){

        return ConnectedCustomiserDto.builder().id(customiser.getId()).login(customiser.getLogin()).build();
    }

}
