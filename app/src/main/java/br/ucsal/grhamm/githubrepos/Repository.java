package br.ucsal.grhamm.githubrepos;

import br.ucsal.grhamm.githubrepos.persistence.UserDAO;

public class Repository {
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Repository(UserDAO userDAO){
        this.userDAO = userDAO;
    }
}
