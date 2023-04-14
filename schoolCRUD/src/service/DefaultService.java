package service;

import information.Gender;
import information.Grade;
import information.Subject;
import user.Admin;
import viewer.DefaultViewer;
import user.Student;
import user.Teacher;
import viewer.StudentViewer;
import viewer.TeacherViewer;

import java.util.*;

import static information.Gender.FEMALE;
import static information.Gender.MALE;
import static information.Subject.*;

public final class DefaultService {
    private Scanner sc = new Scanner(System.in);
    public boolean selectSign() {
        DefaultViewer.exeMessage();
        return (tryIntException() == 1);
    } //로그인인지 회원가입인지 선택

    public int inputRange(int range) {
        while (true) {
            int input = tryIntException();
            if (input>0 && input<=range) {
                return input;
            } else {
                DefaultViewer.errorMessage();
            }
        }
    }

    public String inputName() {
        while (true) {
            String input = sc.nextLine();
            if (!input.matches("[\\p{L}]+$")) {
                DefaultViewer.errorMessage();
                continue;
            }
            return input;
        }
    }

    public int inputJob() {
        while (true) {
            int input = tryIntException();
            if (input == 1 || input == 2) {
                return input;
            } else {
                DefaultViewer.errorMessage();
            }
        }
    }

    public int inputBirthday() {
        int birth;
        while (true) {
            String input = sc.nextLine();
            if(!input.matches("\\d{8}")) {
                DefaultViewer.errorMessage();
                continue;
            }
            try {
                birth = Integer.parseInt(input);
                break;
            } catch (NumberFormatException nfe) {
                DefaultViewer.errorMessage();
            }
        }
        return birth;
    }
    public Gender inputGender() {
        while (true) {
            switch (tryIntException()) {
                case 1:
                    return MALE;
                case 2:
                    return FEMALE;
                default:
                    DefaultViewer.errorMessage();
                    break;
            }
        }
    }
    public String inputId() {
        RegistrationService rg = new RegistrationService();
        String id;
        do {
            DefaultViewer.inputIdMessage();
            id = sc.nextLine();
        } while (rg.checkRedundancyId(id));
        return id;
    }

    public static int tryIntException() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int num = sc.nextInt();
                sc.nextLine();
                return num;
            } catch (InputMismatchException ime) {
                DefaultViewer.errorMessage();
                sc = new Scanner(System.in);
            }
        }
    }
}
