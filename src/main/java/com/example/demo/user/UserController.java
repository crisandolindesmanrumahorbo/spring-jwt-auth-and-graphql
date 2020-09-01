package com.example.demo.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUserDto> fetch(
            @RequestHeader(value = "Authorization") String authorization,
                                                                    @PathVariable int userId) {
        User foundUser = this.userService.fetchById(userId);
        ModelMapper modelMapper = new ModelMapper();
        ResponseUserDto responseUserDto = modelMapper.map(foundUser, ResponseUserDto.class);
        return new ResponseEntity<>(responseUserDto, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUserDto> add(@RequestHeader(value = "Authorization") String authorization,
                                                                  @RequestBody @Valid RequestUserDto userDto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDto, User.class);
        User addedUser = this.userService.add(user);
        ResponseUserDto responseUserDto = modelMapper.map(addedUser, ResponseUserDto.class);
        return new ResponseEntity<>(responseUserDto, HttpStatus.CREATED);
    }

//    @PutMapping("/users/{userId}")
//    public ResponseEntity<com.btpn.chip.user.ResponseUserDto> update(@RequestHeader(value = "Authorization") String authorization,
//                                                                     @PathVariable int userId,
//                                                                     @RequestBody com.btpn.chip.user.RequestUserDto requestUserDto) {
//        com.btpn.chip.user.User user = requestUserDto.convertTo(com.btpn.chip.user.User.class);
//        com.btpn.chip.user.User updatedUser = this.userService.update(userId, user);
//        com.btpn.chip.user.ResponseUserDto responseUserDto = updatedUser.convertTo(com.btpn.chip.user.ResponseUserDto.class);
//        return new ResponseEntity<>(responseUserDto, HttpStatus.OK);
//    }
}
