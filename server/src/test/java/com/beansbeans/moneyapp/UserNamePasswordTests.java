package com.beansbeans.moneyapp;

import com.beansbeans.moneyapp.Services.ValidateUserNamePassword;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

import static com.beansbeans.moneyapp.Services.ValidateUserNamePassword.userValidation.confirmPasswordHash;
import static com.beansbeans.moneyapp.Services.ValidateUserNamePassword.userValidation.makeHash;
import static com.beansbeans.moneyapp.Services.ValidateUserNamePassword.userValidation.isUserNameValid;
import static com.beansbeans.moneyapp.Services.ValidateUserNamePassword.userValidation.isPasswordValid;
import static com.beansbeans.moneyapp.Services.ValidateUserNamePassword.userValidation.isUserNameAvailable;

public class UserNamePasswordTests {


        public UserNamePasswordTests() {

        }

        @Test
        public void userNamePasswordTest01() {
            Boolean ans;

            // Name Good
            // Pass Good

            String name = "ABcd123?";
            String Pass = "Good123?";

            ans = isUserNameValid(name);

            Assert.assertTrue(ans);

        }

        @Test
        public void userNamePasswordTest02() {
            Boolean ans;

            // Name lacks uppercase
            // Pass Good

            String name = "bcdef?9";
            String Pass = "Good123?";

            ans =  isUserNameValid(name);

            Assert.assertFalse(ans);

        }

        @Test
        public void userNamePasswordTest03() {
            Boolean ans;

            // Name lacks lowercase
            // Pass Good

            String name = "ABCDEF?9";
            String Pass = "Good123?";

            ans =  isUserNameValid(name);

            Assert.assertFalse(ans);

        }

        @Test
        public void userNamePasswordTest04() {
            Boolean ans;

            // Name lacks numeral
            // Pass Good

            String name = "abcDEFf?";
            String Pass = "Good123?";

            ans =  isUserNameValid(name);

            Assert.assertFalse(ans);

        }

        @Test
        public void userNamePasswordTest05() {
            Boolean ans;

            // Name has space
            // Pass Good

            String name = "ABCabcdef$ 9";
            String Pass = "Good123?";

            ans =  isUserNameValid(name);

            Assert.assertFalse(ans);

        }


        @Test
        public void userNamePasswordTest06() {
            Boolean ans;

            // Name has triple
            // Pass Good

            String name = "bbbcdXef?9";
            String Pass = "Good123?";

            ans =  isUserNameValid(name);

            Assert.assertFalse(ans);

        }

        @Test
        public void userNamePasswordTest07() {
            Boolean ans;

            // Name is short
            // Pass Good

            String name = "Abcdf?9";
            String Pass = "Good123?";

            ans =  isUserNameValid(name);

            Assert.assertFalse(ans);

        }

        @Test
        public void userNamePasswordTest08() {
            Boolean ans;

            // Name is long
            // Pass Good

            String name = "HHHHgtabchhhhhhhhhdXef?9";
            String Pass = "Good123?";

            ans =  isUserNameValid(name);

            Assert.assertFalse(ans);

        }

        @Test
        public void userNamePasswordTest09() {
            Boolean ans;

            // Name is good
            // Pass lacks uppercase letter

            String name = "ABcd123?";
            String Pass = "good123$";

            ans =  isPasswordValid(Pass);

            Assert.assertFalse(ans);

        }

        @Test
        public void userNamePasswordTest10() {
            Boolean ans;

            // Name is good
            // Pass lacks lowercase letter

            String name = "ABcd123?";
            String Pass = "GOOD123$";

            ans =  isPasswordValid(Pass);

            Assert.assertFalse(ans);

        }

        @Test
        public void userNamePasswordTest11() {
            Boolean ans;

            // Name is good
            // Pass lacks numeric

            String name = "ABcd123?";
            String Pass = "Goodeee$";

            ans =  isPasswordValid(Pass);

            Assert.assertFalse(ans);

        }

        @Test
        public void userNamePasswordTest12() {
            Boolean ans;

            // Name is good
            // Pass has triple

            String name = "ABcd123?";
            String Pass = "Goodaaa123$";

            ans =  isPasswordValid(Pass);

            Assert.assertFalse(ans);

        }

        @Test
        public void userNamePasswordTest13() {
            Boolean ans;

            // Name is good
            // Pass has space

            String name = "ABcd123?";
            String Pass = "Gooda a123$";

            ans =  isPasswordValid(Pass);

            Assert.assertFalse(ans);

        }

        @Test
        public void userNamePasswordTest14() {
            Boolean ans;

            // Name is good
            // Pass lacks special character

            String name = "ABcd123?";
            String Pass = "Goodaa12345";

            ans =  isPasswordValid(Pass);

            Assert.assertFalse(ans);

        }

//        @Test
//        public void userNamePasswordTest15() {
//            Boolean ans;
//
//            // Name is good
//            // Pass contains Name
//
//            String name = "ABcd123?";
//            String Pass = "GoodabXABcd123?34";
//
//            ans =  isPasswordValid(Pass);
//
//            Assert.assertFalse(ans);
//
//
//        }

        @Test
        public void userNamePasswordTest16() {
            Boolean ans;

            // Name is good
            // Pass AND

            String name = "ABcd123?";
            String Pass = "GoodANDf?94";

            ans =  isPasswordValid(Pass);

            Assert.assertFalse(ans);

        }

        @Test
        public void userNamePasswordTest17() {
            Boolean ans;

            // Name is good
            // Pass NOT

            String name = "ABcd123?";
            String Pass = "GoodNOTf?94";

            ans =  isPasswordValid(Pass);

            Assert.assertFalse(ans);

        }

    @Test
    public void makeHashTest01() {

        String passWord = "AlexanderBrown1234!";

        String hash =  makeHash(passWord);

        Assert.assertTrue(BCrypt.checkpw(passWord, hash));
    }

    @Test
    public void confirmPasswordHashTest02() {

        String passWord = "AlexanderBrown1234!";

        String hash =  makeHash(passWord);

        Assert.assertTrue(confirmPasswordHash(passWord, hash));
    }

    @Test
    public void isUserNameAvailableTest01() {

        String inputName = "Alex";

        Assert.assertFalse(isUserNameAvailable(inputName));
    }

//    @Test
//    public void isUserNameAvailableTest02() {
//
//        String inputName = "Alex2";
//
//        Assert.assertTrue(isUserNameAvailable(inputName));
//    }



}
