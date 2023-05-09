package be.technifutur.demoservletjava23.repositories;

import be.technifutur.demoservletjava23.models.Recipe;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeRepositoryImpl extends BaseRepositoryImpl<Recipe> implements RecipeRepository{


    public RecipeRepositoryImpl() {
        super("Recipe");
    }

    @Override
    protected Recipe create(ResultSet resultSet) throws SQLException {
        return Recipe.builder()
                .id(resultSet.getInt("recipe_id"))
                .name(resultSet.getString("recipe_name"))
                .ingredient(resultSet.getString("recipe_ingredient"))
                .build();
    }

    @Override
    protected void setParameters(PreparedStatement preparedStatement, Recipe recipe) throws SQLException {
        preparedStatement.setString(1,recipe.getName());
        preparedStatement.setString(2, recipe.getIngredient());
    }

    @Override
    protected String getInsertSql() {
        return "INSERT INTO recipe (recipe_name, recipe_ingredient) VALUES (?,?) RETURNING *";
    }

    @Override
    protected String getUpdateSql() {
        return "UPDATE recipe SET recipe_name = ?, recipe_ingredient = ? WHERE recipe_id = ?";
    }

    @Override
    protected String getQueryAllInfo() {
        return null;
    }

    @Override
    protected int getCreateParameterCount() {
        return 3;
    }
}
