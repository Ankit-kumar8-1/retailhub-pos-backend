package in.ankitsaahariya.retailhub_pos.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    private  String email;
    private String password;
}
