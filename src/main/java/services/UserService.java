package services;

import domain.models.Member;

import java.util.UUID;

public interface UserService {

    Member findById(UUID id);

    Member findByEmail(String email);
}
