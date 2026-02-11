package com.payflow.payflow.repository;

import com.payflow.payflow.model.User;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();
    private final String FILE_PATH = "users.txt";

    public UserRepository() {
        loadUsers();
    }

    public void addUser(User user) throws IOException {
        users.add(user);
        saveUser();
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(UUID id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public User getUserByMail(String mail) {
        return users.stream()
                .filter(user -> user.getEmail().equals(mail))
                .findFirst()
                .orElse(null);
    }

    public void saveUser() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User u : users) {
                writer.write(u.getId() + ";" + u.getName() + ";" + u.getEmail() + ";" + u.getBalance());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadUsers() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    User user = User.builder()
                            .id(UUID.fromString(parts[0]))
                            .name(parts[1])
                            .email(parts[2])
                            .balance(new BigDecimal(parts[3]))
                            .build();
                    users.add(user);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
