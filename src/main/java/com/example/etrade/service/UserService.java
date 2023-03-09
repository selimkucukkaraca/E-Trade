package com.example.etrade.service;

import com.example.etrade.dto.UserDto;
import com.example.etrade.dto.converter.UserConverter;
import com.example.etrade.dto.request.CreateUserRequest;
import com.example.etrade.exception.NotFoundException;
import com.example.etrade.exception.generic.GenericExistException;
import com.example.etrade.model.ConfirmCode;
import com.example.etrade.model.User;
import com.example.etrade.repository.UserRepository;
import com.example.etrade.util.MailSendService;
import org.springframework.stereotype.Service;

import static com.example.etrade.util.MailConstant.CONFIRM_CODE_DESCRIPTION;
import static com.example.etrade.util.MailConstant.CONFIRM_CODE_TITLE;

@Service
public class UserService {

    private final MailSendService mailSendService;
    private final ConfirmCodeService confirmCodeService;
    private final UserConverter userConverter;
    private final UserRepository userRepository;


    public UserService(MailSendService mailSendService, ConfirmCodeService confirmCodeService,
                       UserConverter userConverter, UserRepository userRepository) {
        this.mailSendService = mailSendService;
        this.confirmCodeService = confirmCodeService;
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

    public UserDto save(CreateUserRequest request){
        var saved = userConverter.toEntity(request);
        if (userRepository.existsUserByMail(saved.getMail())){
            throw new GenericExistException("User already exist, mail: " + saved.getMail());
        }
        userRepository.save(saved);
        return userConverter.convert(saved);
    }

    public void delete(String mail){
        var fromUser = getUserByMail(mail);
        userRepository.delete(fromUser);
    }

    public UserDto getByMail(String mail){
        var fromDbUser = userRepository.findUserByMail(mail)
                .orElseThrow(() -> new NotFoundException("Mail not found: " + mail));
        return userConverter.convert(fromDbUser);
    }

    public UserDto activeUser(String mail,int code){
        var user = getUserByMail(mail);

        if (user.getConfirmCode().getCode() != code) {
            return null;

        }

        user.setActive(true);
        confirmCodeService.delete(user.getConfirmCode());
        userRepository.save(user);
        return userConverter.convert(user);
    }

    public UserDto deactivateUser(String mail) {
        var fromDbUser = getUserByMail(mail);
        fromDbUser.setActive(false);
        userRepository.save(fromDbUser);

        return userConverter.convert(fromDbUser);
    }

    public void sendConfirmCode(String mail){
        var user = getUserByMail(mail);

        ConfirmCode confirmCode = new ConfirmCode();
        confirmCodeService.save(confirmCode);
        user.setConfirmCode(confirmCode);
        userRepository.save(user);

        String description = String.format(CONFIRM_CODE_DESCRIPTION, confirmCode.getCode());
        mailSendService.sendMail(user.getMail(),CONFIRM_CODE_TITLE,description);
    }

    protected User getUserByMail(String mail){
        return userRepository.findUserByMail(mail)
                .orElseThrow(() -> new NotFoundException(""));
    }

}