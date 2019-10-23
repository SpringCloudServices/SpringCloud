package pl.training.shop.shop.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.training.shop.shop.dto.PageDto;
import pl.training.shop.shop.dto.UserDto;
import pl.training.shop.shop.model.Mapper;
import pl.training.shop.shop.model.ResultPage;
import pl.training.shop.shop.model.User;
import pl.training.shop.shop.service.UsersService;

import java.net.URI;
import java.util.List;

@RequestMapping(value = "users")
@RestController
@RequiredArgsConstructor
public class UsersController {

    @NonNull
    private UsersService usersService;

    @NonNull
    private Mapper mapper;
    private UriBuilder uriBuilder = new UriBuilder();

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody UserDto userDto) {
        User user = mapper.map(userDto, User.class);
        usersService.addUser(user);
        URI uri = uriBuilder.requestUriWithId(user.getId());
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public PageDto<UserDto> getUsers(
            @RequestParam(required = false, defaultValue = "0", name = "pageNumber") int pageNumber,
            @RequestParam(required = false, defaultValue = "10", name = "pageSize") int pageSize) {
        ResultPage<User> resultPage = usersService.getUsers(pageNumber, pageSize);
        List<UserDto> usersDtos = mapper.map(resultPage.getContent(), UserDto.class);
        return new PageDto<>(usersDtos, resultPage.getPageNumber(), resultPage.getTotalPages());
    }

}
