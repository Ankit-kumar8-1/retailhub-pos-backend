package in.ankitsaahariya.retailhub_pos.service;

import in.ankitsaahariya.retailhub_pos.io.UserRequest;
import in.ankitsaahariya.retailhub_pos.io.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest request);

    String getUserRole(String email);

    List<UserResponse> readUsers();

    void deleteUser(String id);
}
