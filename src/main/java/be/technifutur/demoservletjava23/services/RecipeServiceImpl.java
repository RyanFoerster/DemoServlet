package be.technifutur.demoservletjava23.services;

import be.technifutur.demoservletjava23.models.Recipe;
import be.technifutur.demoservletjava23.repositories.RecipeRepository;
import be.technifutur.demoservletjava23.repositories.RecipeRepositoryImpl;

public class RecipeServiceImpl {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl() {
        this.recipeRepository = new RecipeRepositoryImpl();
    }

    public Recipe create(Recipe recipe){

        return recipeRepository.add(recipe);
    }

    public Recipe getById(Integer id){

        return recipeRepository.getById(id);
    }

    public Boolean update(Integer id, Recipe recipe){

        return recipeRepository.update(id, recipe);
    }
}
