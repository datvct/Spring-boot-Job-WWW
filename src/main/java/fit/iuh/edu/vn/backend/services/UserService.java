package fit.iuh.edu.vn.backend.services;

import fit.iuh.edu.vn.backend.models.User;
import fit.iuh.edu.vn.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;  // Inject PasswordEncoder

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        // Mã hóa mật khẩu khi tải từ database, nếu mật khẩu chưa mã hóa
        if (!passwordEncoder.matches(user.getPassword(), user.getPassword())) {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);  // Lưu lại mật khẩu đã mã hóa
            userRepository.save(user);  // Cập nhật lại mật khẩu mã hóa
        }

        UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
        builder.password(user.getPassword());
        builder.roles("USER");

        return builder.build();
    }

    // Phương thức tạo người dùng mới với mật khẩu đã mã hóa
    public void createUser(String username, String plainPassword) {
        String encodedPassword = passwordEncoder.encode(plainPassword);  // Mã hóa mật khẩu
        User user = new User(username, encodedPassword, true);  // Tạo người dùng với mật khẩu mã hóa
        userRepository.save(user);  // Lưu người dùng vào cơ sở dữ liệu
    }
}
