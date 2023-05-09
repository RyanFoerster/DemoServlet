package be.technifutur.demoservletjava23.repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepositoryImpl<T> implements BaseRepository<T>{

        private final String tableName;


        protected BaseRepositoryImpl(String tableName) {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            this.tableName = tableName;
        }

        protected abstract T create(ResultSet resultSet) throws SQLException;

        protected abstract void setParameters(PreparedStatement preparedStatement, T entity) throws SQLException;

        protected String getSelectAllSql(){
            return "SELECT * FROM " + tableName;
        }

        protected abstract String getInsertSql();

        protected abstract String getUpdateSql();

        protected abstract String getQueryAllInfo();

        protected abstract int getCreateParameterCount();

        protected String getDeleteSql(){

            return "DELETE FROM " + tableName + " WHERE " + tableName + "_id = ?";
        }

        protected String getSelectOneSql(){

            return "SELECT * FROM " + tableName + " WHERE " + tableName + "_id = ?";
        }

        public T getById(Integer id) {

            try (Connection connection = connectDB()) {

                PreparedStatement preparedStatement = connection.prepareStatement(getSelectOneSql());

                preparedStatement.setInt(1, id);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (!resultSet.next()) {
                    throw new RuntimeException();
                }

                return create(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public List<T> getAll() {

            List<T> entities = new ArrayList<>();

            try (Connection connection = connectDB()) {

                PreparedStatement preparedStatement = connection.prepareStatement(getSelectAllSql());

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    entities.add(create(resultSet));
                }

            } catch (SQLException e) {

                throw new RuntimeException(e);
            }


            return entities;
        }

        public T add(T entity) {

            return add(entity, connectDB());
        }

        @Override
        public T add(T entity, Connection connection) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(getInsertSql())) {

                setParameters(preparedStatement, entity);

                ResultSet resultSet = preparedStatement.executeQuery();

                if(!resultSet.next()){

                    throw new RuntimeException("FAILED");
                }

                return create(resultSet);

            }catch (SQLException e) {

                throw new RuntimeException(e);
            }
        }

        public Boolean update(int id, T entity) {

            return update(id, entity, connectDB());
        }

        @Override
        public Boolean update(int id, T entity, Connection connection) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(getUpdateSql())) {

                setParameters(preparedStatement, entity);

                preparedStatement.setInt(getCreateParameterCount(), id);

                return preparedStatement.executeUpdate() == 1;

            } catch (SQLException e) {

                throw new RuntimeException(e);
            }
        }

        public Boolean delete(int id) {

            return delete(id, connectDB());
        }

        @Override
        public Boolean delete(int id, Connection connection) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(getDeleteSql())) {

                preparedStatement.setInt(1, id);

                return preparedStatement.executeUpdate() == 1;

            } catch (SQLException e) {

                throw new RuntimeException(e);
            }
        }

        @Override
        public T getAllInfoById(Integer id) {

            try (Connection connection = connectDB()) {

                PreparedStatement preparedStatement = connection.prepareStatement(getQueryAllInfo());

                preparedStatement.setInt(1, id);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (!resultSet.next()) {
                    throw new RuntimeException();
                }

                return create(resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public Connection connectDB() {

            final String url = "jdbc:postgresql://localhost:5432/ServletDB";
            final String user = "postgres";
            final String password = "postgres";

            try {

                return DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {

                throw new RuntimeException(e);
            }
        }

}
