package pl.training.shop.shop.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.training.shop.shop.model.ResultPage;
import pl.training.shop.shop.model.User;
import pl.training.shop.shop.repository.UsersRepository;


@RequiredArgsConstructor
@Service
public class UsersService {

    @NonNull
    private UsersRepository usersRepository;

    public void addUser(User user) {

        usersRepository.saveAndFlush(user);
    }

    public ResultPage<User> getUsers(int pageNumber, int pageSize) {
        Page<User> usersPage = usersRepository.findAll(PageRequest.of(pageNumber, pageSize));

        return new ResultPage<>(usersPage.getContent(), usersPage.getNumber(), usersPage.getTotalPages());
    }

}
