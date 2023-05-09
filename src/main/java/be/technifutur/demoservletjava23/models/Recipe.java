package be.technifutur.demoservletjava23.models;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Recipe {

    private Integer id;
    private String name;
    private String ingredient;

    public Recipe(String name, String ingredient) {
        this.name = name;
        this.ingredient = ingredient;
    }
}
