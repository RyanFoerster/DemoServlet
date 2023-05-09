package be.technifutur.demoservletjava23.repositories;


import be.technifutur.demoservletjava23.models.Customiser;

public interface CustomiserRepository extends BaseRepository<Customiser>{

    Customiser findByLogin(String login, String password);
}
