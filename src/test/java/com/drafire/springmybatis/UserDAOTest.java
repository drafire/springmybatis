package com.drafire.springmybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDAOTest {

    @Test
    public void getUser() {
        DrafireSqlsession sqlsession = new DrafireSqlsession();
        UserDAO userDAO = sqlsession.getMapper(UserDAO.class);
        User user = userDAO.getUser(1);
        System.out.println(user);
    }
}