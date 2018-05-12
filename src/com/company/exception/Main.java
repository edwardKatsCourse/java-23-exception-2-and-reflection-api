package com.company.exception;

import java.io.IOException;

public class Main {

    /**
     * I. Registration flow
     * 1. Enter first name, last name, email
     * 1.1. Input first name ....
     *
     * 2. Save to database (to array in out case)
     * 2.1. Check first name length
     * 2.2. Check last name length
     * 2.3. Check email length
     * 2.4. Check email format (abc@site)
     * 2.5. Check email does not exist in the system yet
     * 2.6. Save to DB
     *
     * 3. Return successful answer!
     *
     * II. Login flow
     * 1. login
     * 1.1. Menu
     *
     */


    /**
     * Exception Handling
     * 1. Validate input data
     * 2. Recovery from an error
     */

    /**
     *
     * Exception vs RuntimeException
     * (checked)      (unchecked)
     */
    public static void main(String[] args) {
        try {
            unchecked();
            emailNotUnique();
        } catch (GeneralAPIException e) {

            System.out.println("User's fault!");
        } catch (Exception e) {

            System.out.println("Unexpected error. " +
                    "Please, reload the page or try again later");
        }

//        checked(0, "bbb");
    }

    public static void checked/*ByCompiler*/(int a, String s) throws IOException {
        if (s.equals("aaa") && a != 10 * 100) {

            throw new IOException();
        }
    }

    public static void unchecked() {
        throw new InputException();
    }

    public static void emailNotUnique() {
        throw new EmailNotUniqueException();
    }

}


class GeneralAPIException extends RuntimeException {}

class InputException extends GeneralAPIException {}

class EmailNotUniqueException extends GeneralAPIException {}



class InputTooLongException extends InputException {}

