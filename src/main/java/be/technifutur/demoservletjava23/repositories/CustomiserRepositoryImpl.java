package be.technifutur.demoservletjava23.repositories;

import be.technifutur.demoservletjava23.models.Customiser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomiserRepositoryImpl extends BaseRepositoryImpl<Customiser> implements CustomiserRepository{


    public CustomiserRepositoryImpl() {
        super("customer");
    }

    @Override
    protected Customiser create(ResultSet resultSet) throws SQLException {
        try {
            return Customiser.builder()
                    .id(resultSet.getInt("customer_id"))
                    .login(resultSet.getString("customer_login"))
                    .password(resultSet.getString("customer_password"))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void setParameters(PreparedStatement preparedStatement, Customiser customiser) throws SQLException {
        preparedStatement.setString(1, customiser.getLogin().toLowerCase());
        preparedStatement.setString(2, customiser.getPassword());
    }

    @Override
    protected String getInsertSql() {
        return "INSERT INTO customer (customer_login, customer_password) VALUES (?,?) RETURNING *";
    }

    @Override
    protected String getUpdateSql() {
        return "UPDATE customer SET customer_login = ?, customer_password = ? WHERE customers_id = ?";
    }

    @Override
    protected String getQueryAllInfo() {
        return null;
    }

    @Override
    protected int getCreateParameterCount() {
        return 3;
    }

    public Customiser findByLogin(String login, String password){

        try(Connection connection = connectDB()) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE customer_login = ?");
            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(!resultSet.next()){
                throw new RuntimeException();
            }
            return create(resultSet);

        }catch (SQLException e){
            throw new RuntimeException();
        }

    }

}
