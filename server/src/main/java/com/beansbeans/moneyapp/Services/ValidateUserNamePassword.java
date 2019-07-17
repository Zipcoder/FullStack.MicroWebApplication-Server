package com.beansbeans.moneyapp.Services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;
import org.springframework.security.crypto.bcrypt.BCrypt;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;
import java.sql.SQLException;



public class ValidateUserNamePassword {


    public static class userValidation {
        String userName;
        String userPassword;


        public userValidation() {
        }

/*      Methods:

            1)  isUserNamePasswordValid(String inputName, String inputPassword)

                Returns "true" if UserName and Password are valid and UserName is
                not already in use (to be implemented).



            2)  makeHash(String inputPassword)

                Hash is mutable with same password.  DO NOT USE AS UNIQUE ID !!!

                Returns String (hash) created by hashing inputPassword.  Use makeHash
                to encode client's password and place the hash in the database.
                When the client returns, use makeHash to encode the password and
                compare with database version. DO NOT CHANGE "salt" !!!



            3)  confirmPasswordHash(String passWord, String hash)

                Returns "true" if passWord matches stored hash.  Hash will change
                everytime makeHash is called, so we match the passWord with the original hash.
*/



        public static Boolean isUserNamePasswordValid(String inputName, String inputPassword) {
/*
        User Name must contain be at least 8 characters
                                  and 20 characters maximum
                                  an uppercase letter
                                  a lowercase letter
                                  a numeric (0 to 9)
                                  a non alpha-numeric
                                  and no 3 same characters in a row
                                  and no spaces
                                  and none of the following characters = ; : * / + ( ) [ ]  { } \ | ,


        Password must contain be  at least 8 characters
                                  and 20 characters maximum
                                  an uppercase letter
                                  a lowercase letter
                                  a numeric (0 to 9)
                                  a non alpha-numeric
                                  and no 3 same characters in a row
                                  and no spaces
                                  and none of the following characters = ; : * / + ( ) [ ]  { } \ | ,
                                  cannot contain the User Name


 Check User Name first


*/

            // Name is at least 8 characters
            if (inputName.length() < 8) {return false;}

            // Name is less than 21 characters
            if (inputName.length() >20) {return false;}

            // Name contains an uppercase character
            if (inputName.equals(inputName.toLowerCase())) {return false;}

            // Name contains a lowercase character
            if (inputName.equals(inputName.toUpperCase())) {return false;}

            // Check for forbidden characters
            if (inputName.contains(" ")) {return false;}
            if (inputName.contains("=")) {return false;}
            if (inputName.contains(";")) {return false;}
            if (inputName.contains(":")) {return false;}
            if (inputName.contains("*")) {return false;}
            if (inputName.contains("/")) {return false;}
            if (inputName.contains("+")) {return false;}
            if (inputName.contains("(")) {return false;}
            if (inputName.contains(")")) {return false;}
            if (inputName.contains("^")) {return false;}
            if (inputName.contains("[")) {return false;}
            if (inputName.contains("]")) {return false;}
            if (inputName.contains("{")) {return false;}
            if (inputName.contains("}")) {return false;}
            if (inputName.contains("\\")) {return false;}
            if (inputName.contains("|")) {return false;}
            if (inputName.contains(",")) {return false;}

            //Checks at least one char that is numeric
            if (!inputName.matches(".*[0-9].*")) {return false;}

            //Checks at least one char that is not alpha-numeric
            if (inputName.matches("[A-Za-z0-9 ]*")) {return false;}

            // Check for 3 identical characters in a row
            final String ps = ".*(?:([a-z0-9])\\1{2,}).*";
            final Pattern p1 = Pattern.compile(ps);
            final Matcher m1 = p1.matcher(inputName);
            if (m1.matches()) {return false;}


// Check Password second


            // Name is at least 8 characters
            if (inputPassword.length() < 8) {return false;}

            // Name is less than 21 characters
            if (inputPassword.length() >20) {return false;}

            // Name contains an uppercase character
            if (inputPassword.equals(inputPassword.toLowerCase())) {return false;}

            // Name contains a lowercase character
            if (inputPassword.equals(inputPassword.toUpperCase())) {return false;}

            //Check that it doesn't contain AND
            if (inputPassword.contains("AND")) {return false;}

            //Check that it doesn't contain NOT
            if (inputPassword.contains("NOT")) {return false;}

            // Check for forbidden characters
            if (inputPassword.contains(" ")) {return false;}
            if (inputPassword.contains("=")) {return false;}
            if (inputPassword.contains(";")) {return false;}
            if (inputPassword.contains(":")) {return false;}
            if (inputPassword.contains("*")) {return false;}
            if (inputPassword.contains("/")) {return false;}
            if (inputPassword.contains("+")) {return false;}
            if (inputPassword.contains("(")) {return false;}
            if (inputPassword.contains(")")) {return false;}
            if (inputPassword.contains("^")) {return false;}
            if (inputPassword.contains("[")) {return false;}
            if (inputPassword.contains("]")) {return false;}
            if (inputPassword.contains("{")) {return false;}
            if (inputPassword.contains("}")) {return false;}
            if (inputPassword.contains("\\")) {return false;}
            if (inputPassword.contains("|")) {return false;}
            if (inputPassword.contains(" ")) {return false;}
            if (inputPassword.contains(",")) {return false;}

            //Checks at least one char is numeric
            if (!inputPassword.matches(".*[0-9].*")) {return false;}

            //Checks at least one char is not alpha numeric
            if (inputPassword.matches("[A-Za-z0-9 ]*")) {return false;}

            // Check for 3 identical characters in a row
            final Pattern p2 = Pattern.compile(ps);
            final Matcher m2 = p2.matcher(inputPassword);
            if (m2.matches()) {return false;}

            // Password cannot contain User Name
            if (inputPassword.contains(inputName)) {return false;}

            return true;
        }


        public static String makeHash(String inputPassword) {

            String salt = BCrypt.gensalt(10);

            String hash = BCrypt.hashpw(inputPassword, salt);

            return hash;

        }


        public static Boolean confirmPasswordHash(String passWord, String hash) {

            return (BCrypt.checkpw(passWord, hash));

        }


        public static Boolean isUserNameAvailable(String inputName) {

            return false;
        }

    }

}
