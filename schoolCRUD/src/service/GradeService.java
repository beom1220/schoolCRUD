package service;

import information.Grade;
import user.Student;
import viewer.DefaultViewer;
import viewer.StudentViewer;
import viewer.TeacherViewer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradeService {
    private DefaultService ds = new DefaultService();
    public void manageGrade(Student student) {
        ListStudentManageService lsm = ListStudentManageService.getInstance();
        switch (DefaultService.tryIntException()) {
            case 0:
                break;
            case 1:
                // 열람
                int season = lsm.selectSeason(student);
                if (season == 0) {
                    break;
                }
                StudentViewer.inquiryGrade(lsm.seasonToString(season), student, season-1);
                break;
            case 2:
                // 등록
                lsm.addGrade(student, newGrade());
                break;
            case 3:
                // 수정
                season = lsm.selectSeason(student);
                if (season == 0) {
                    break;
                }
                changeGrade(student.getGradeList().get(season-1));
                break;
            case 4:
                // 삭제
                season = lsm.selectSeason(student);
                if (season == 0) {
                    break;
                }
                deleteGrade(student, season-1);
                //student.getGradeList().remove(season-1);
                break;
            default:
                DefaultViewer.failFunctionMessage();
                break;
        }
    } // 학생 성적 관리 선택창.
    public void deleteGrade(Student student, int season) {
        Grade empty = new Grade(0, 0, 0,0,0,0);
        student.getGradeList().set(season, empty);
    } // 학생 성적 삭제. 근데 아예 지워버리면 나중에 시기 확인 같은 거 할 때 문제 생길 수 있어서 전부 0인 거 만들어서 넣음.

    public void changeGrade(Grade grade) {
        TeacherViewer.selectChangeGradeSubjectFunction();
        int sub = DefaultService.tryIntException() - 1;
        int score;
        do {
            inputGrade(sub);
            score = DefaultService.tryIntException();
        } while (!(score >= 0 && score <= 100));
        switch (sub) {
            case 0: //국수영사과역
                grade.setKor(score);
                break;
            case 1:
                grade.setMath(score);
                break;
            case 2:
                grade.setEng(score);
                break;
            case 3:
                grade.setSociety(score);
                break;
            case 4:
                grade.setScience(score);
                break;
            case 5:
                grade.setHistory(score);
                break;
            default:
                DefaultViewer.errorMessage();
                break;
        }
    } // 성적 수정. 고른 시기에서 고른 과목 성적을 변경할 수 있음.
    public void inputGrade(int sub) {
        List<String> subNames = new ArrayList<>(Arrays.asList("국어", "수학", "영어", "사회", "과학", "역사"));
        TeacherViewer.inputGradeMessage(subNames.get(sub));
    }
    public Grade newGrade() {
        List<Integer> grades = new ArrayList<>();
        for (int sub = 0; sub < 6; sub++) {
            inputGrade(sub);
            grades.add(inputScore());
        }
        Grade grade = new Grade(grades.get(0), grades.get(1), grades.get(2), grades.get(3), grades.get(4), grades.get(5));
        return grade;
    }
    public int inputScore() {
        while (true) {
            int score = DefaultService.tryIntException();
            if (score >= 0 && score <=100) {
                return score;
            } else {
                DefaultViewer.errorMessage();
            }
        }
    }
}
