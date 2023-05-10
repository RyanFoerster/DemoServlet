package be.technifutur.demoservletjava23.services;

import be.technifutur.demoservletjava23.exceptions.InvalidPasswordUserException;
import be.technifutur.demoservletjava23.models.Customiser;
import be.technifutur.demoservletjava23.repositories.CustomiserRepository;
import be.technifutur.demoservletjava23.repositories.CustomiserRepositoryImpl;
import org.mindrot.jbcrypt.BCrypt;

public class CustomiserServiceImpl {

    private final CustomiserRepository customiserRepository;

    public CustomiserServiceImpl() {

        this.customiserRepository = new CustomiserRepositoryImpl();
    }

    public Customiser register(Customiser customiser) {

        if (customiser.getLogin().trim().equalsIgnoreCase("")) {
            throw new RuntimeException();
        }

        if (customiser.getPassword().trim().equalsIgnoreCase("")) {
            throw new RuntimeException();
        }
        customiser.setPassword(BCrypt.hashpw(customiser.getPassword(), BCrypt.gensalt()));

        return customiserRepository.add(customiser);
    }

    public Customiser findByLogin(String login, String password) {

        Customiser customiser = customiserRepository.findByLogin(login, password);

        if (customiser == null) {
            throw new RuntimeException();
        }

        if (!BCrypt.checkpw(password, customiser.getPassword())) {
            throw new InvalidPasswordUserException();
        }

        return customiser;

    }
}
