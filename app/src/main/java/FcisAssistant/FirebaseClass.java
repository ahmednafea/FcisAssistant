package FcisAssistant;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class FirebaseClass {
   private static DatabaseReference root= FirebaseDatabase.getInstance().getReference();
   private static FirebaseAuth auth=FirebaseAuth.getInstance();
   private static String TAG= "FCIS";
    public static void AddUser(String id,String email,String password){
        DatabaseReference target=root.child("Users");
        target.child(id).child("Email").setValue(email);
        target.child(id).child("Password").setValue(password);
        target=root.child("Students");
        target.child(id).child("Email").setValue(email);
        target.child(id).child("Password").setValue(password);
    }
     public static void AddStudent(Student student){
         DatabaseReference target=root.child("Students").child(student.getID());
         target.child("Name").setValue(student.getName());
         target.child("Gender").setValue(student.getGender());
         target.child("Email").setValue(student.getEmail());
         target.child("Password").setValue(student.getPassword());
         target.child("Credit_Hours").setValue(student.getCreditHours());
         target.child("Remain_Credit_Hours").setValue(student.getRCreditHours());
         target.child("Academic_Year").setValue(student.getAcademicYear());
         target.child("Department").setValue(student.getDepartment());
         target.child("Cumulative_Gpa").setValue(student.getCumulativeGpa());
         target.child("Total_Credit_Hours").setValue(student.getTotalCreditHours());
         target.child("Remain_Total_Credit_Hours").setValue(student.getRTotalCreditHours());
         if(student.Courselist.size()>=1){
            for(StudentCourse s:student.Courselist){
                target.child("Courses").child(s.getCode()).child("Name").setValue(s.Name);
                target.child("Courses").child(s.getCode()).child("InstructorOfCourse").setValue(s.InstructorofCourse);
                target.child("Courses").child(s.getCode()).child("Code").setValue(s.getCode());
                for (String f:s.TAlist)
                target.child("Courses").child(s.getCode()).child("TAList").child(f).setValue(f);
                target.child("Courses").child(s.getCode()).child("credithours").setValue(s.CreditHours);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("Assignment").setValue(s.CourseGrade.Assignment);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("Midterm").setValue(s.CourseGrade.Midterm);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("Final").setValue(s.CourseGrade.Final);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("Attendance").setValue(s.CourseGrade.Attendance);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("Bounce").setValue(s.CourseGrade.Bounce);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("Quizzes").setValue(s.CourseGrade.Quizzes);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("Practical").setValue(s.CourseGrade.Practical);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("Weight").setValue(s.CourseGrade.Weight);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("TotalGrade").setValue(s.CourseGrade.TotalGrade);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("GPA").setValue(s.CourseGrade.GPA);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("MaxGrade").child("MaxAssignment").setValue(s.CourseGrade.Max.MaxAssignment);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("MaxGrade").child("MaxMidterm").setValue(s.CourseGrade.Max.MaxMidterm);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("MaxGrade").child("MaxFinal").setValue(s.CourseGrade.Max.MaxFinal);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("MaxGrade").child("MaxAttendance").setValue(s.CourseGrade.Max.MaxAttendance);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("MaxGrade").child("MaxBounce").setValue(s.CourseGrade.Max.MaxBounce);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("MaxGrade").child("MaxQuizzes").setValue(s.CourseGrade.Max.MaxQuizzes);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("MaxGrade").child("MaxPractical").setValue(s.CourseGrade.Max.MaxPractical);
                target.child("Courses").child(s.getCode()).child("CourseGrades").child("MaxGrade").child("MaxWeight").setValue(s.CourseGrade.Max.MaxWeight);
            }
         }
     }
    public static Student GetStudentInfo(String id){
        final DatabaseReference target=root.child("Students").child(id);
        final Student student=new Student();
        target.child("Name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setName(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Gender").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setGender(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Email").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setEmail(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Password").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setPassword(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Credit_Hours").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setCreditHours(Objects.requireNonNull(dataSnapshot.getValue(long.class)));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Remain_Credit_Hours").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setRCreditHours((Objects.requireNonNull(dataSnapshot.getValue(Long.class))));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Academic_Year").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setAcademicYear(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Department").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setDepartment(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Cumulative_Gpa").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setCumulativeGpa(Objects.requireNonNull(dataSnapshot.getValue(long.class)));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Total_Credit_Hours").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setTotalCreditHours(Objects.requireNonNull(dataSnapshot.getValue(long.class)));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Remain_Total_Credit_Hours").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                student.setRTotalCreditHours(Objects.requireNonNull(dataSnapshot.getValue(long.class)));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        target.child("Courses")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            StudentCourse studentCourse=new StudentCourse();
                            studentCourse.Name= Objects.requireNonNull(snapshot.child("Name").getValue()).toString();
                            studentCourse.InstructorofCourse= Objects.requireNonNull(snapshot.child("InstructorOfCourse").getValue()).toString();
                            studentCourse.code= Objects.requireNonNull(snapshot.child("Code").getValue()).toString();
                            for (DataSnapshot snapshot1:dataSnapshot.child("TAList").getChildren())
                            studentCourse.TAlist.add(Objects.requireNonNull(snapshot1.getValue()).toString());
                            studentCourse.CreditHours= (long) snapshot.child("credithours").getValue();
                            studentCourse.CourseGrade.Assignment = Float.parseFloat(Objects.requireNonNull(snapshot.child("CourseGrade").child("Assignment").getValue().toString().trim()));
                            studentCourse.CourseGrade.Midterm= Float.parseFloat(Objects.requireNonNull(snapshot.child("CourseGrade").child("Midterm").getValue().toString().trim()));
                            studentCourse.CourseGrade.Final= Float.parseFloat(Objects.requireNonNull(snapshot.child("CourseGrade").child("Final").getValue().toString().trim()));
                            studentCourse.CourseGrade.Attendance= Float.parseFloat(Objects.requireNonNull(snapshot.child("CourseGrade").child("Attendance").getValue().toString().trim()));
                            studentCourse.CourseGrade.Bounce= Float.parseFloat(Objects.requireNonNull(snapshot.child("CourseGrade").child("Bounce").getValue().toString().trim()));
                            studentCourse.CourseGrade.Quizzes= Float.parseFloat(Objects.requireNonNull(snapshot.child("CourseGrade").child("Quizzes").getValue().toString().trim()));
                            studentCourse.CourseGrade.Practical= Float.parseFloat(Objects.requireNonNull(snapshot.child("CourseGrade").child("Practical").getValue().toString().trim()));
                            studentCourse.CourseGrade.Weight= Float.parseFloat(Objects.requireNonNull(snapshot.child("CourseGrade").child("Weight").getValue().toString().trim()));
                            studentCourse.CourseGrade.TotalGrade= Float.parseFloat(Objects.requireNonNull(snapshot.child("CourseGrade").child("TotalGrade").getValue().toString().trim()));
                            studentCourse.CourseGrade.GPA= Objects.requireNonNull(snapshot.child("CourseGrade").child("GPA").getValue().toString().trim());
                            studentCourse.CourseGrade.Max.MaxAssignment= Integer.parseInt((Objects.requireNonNull(snapshot.child("CourseGrade").child("MaxGrade").child("MaxAssignment").getValue().toString().trim())));
                            studentCourse.CourseGrade.Max.MaxMidterm= Integer.parseInt((Objects.requireNonNull(snapshot.child("CourseGrade").child("MaxGrade").child("MaxMidterm").getValue().toString().trim())));
                            studentCourse.CourseGrade.Max.MaxFinal= Integer.parseInt((Objects.requireNonNull(snapshot.child("CourseGrade").child("MaxGrade").child("MaxFinal").getValue().toString().trim())));
                            studentCourse.CourseGrade.Max.MaxAttendance= Integer.parseInt((Objects.requireNonNull(snapshot.child("CourseGrade").child("MaxGrade").child("MaxAttendance").getValue().toString().trim())));
                            studentCourse.CourseGrade.Max.MaxBounce= Integer.parseInt((Objects.requireNonNull(snapshot.child("CourseGrade").child("MaxGrade").child("MaxBounce").getValue().toString().trim())));
                            studentCourse.CourseGrade.Max.MaxQuizzes= Integer.parseInt((Objects.requireNonNull(snapshot.child("CourseGrade").child("MaxGrade").child("MaxQuizzes").getValue().toString().trim())));
                            studentCourse.CourseGrade.Max.MaxPractical= Integer.parseInt((Objects.requireNonNull(snapshot.child("CourseGrade").child("MaxGrade").child("MaxPractical").getValue().toString().trim())));
                            studentCourse.CourseGrade.Max.MaxWeight= Integer.parseInt((Objects.requireNonNull(snapshot.child("CourseGrade").child("MaxGrade").child("MaxWeight").getValue().toString().trim())));
                            student.InsertCourse(studentCourse);
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "Failed to read value.", databaseError.toException());
                    }
                });
       return student;
    }


     public static void AddInstructor(Instructor instructor){
         FirebaseDatabase.getInstance().setPersistenceEnabled(true);
         DatabaseReference target=root.child("Instructors").child(instructor.getID());
         target.child("Name").setValue(instructor.getName());
         target.child("Gender").setValue(instructor.getGender());
         target.child("Email").setValue(instructor.getEmail());
         target.child("Password").setValue(instructor.getPassword());
         target.child("No_of_Evaluators").setValue(instructor.getNoofEvaluators());
         target.child("Total_Evaluation").setValue(instructor.getTotalEvaluation());
         target.child("Office_Hours").setValue(instructor.getOfficeHours());
         if(instructor.Courselist.size()>=1){
            for (InstructorCourse s:instructor.Courselist) {
                target.child("Courses").child(s.code).child("Code").setValue(s.code);
                target.child("Courses").child(s.code).child("Name").setValue(s.Name);
                target.child("Courses").child(s.code).child("InstructorOfCourse").setValue(s.InstructorofCourse);
                for (String f:s.TAlist)
                    target.child("Courses").child(s.getCode()).child("TAList").child(f).setValue(f);
                target.child("Courses").child(s.getCode()).child("credithours").setValue(s.CreditHours);
                for (String f:s.Studentlist)
                    target.child("Courses").child(s.getCode()).child("StudentList").child(f).setValue(f);
            }
         }
     }
     public static Instructor GetInstructorInfo(String id){
         FirebaseDatabase.getInstance().setPersistenceEnabled(true);
         DatabaseReference target=root.child("Instructors").child(id);
         final Instructor instructor=new Instructor();
         target.child("Name").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 instructor.setName(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Gender").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 instructor.setGender(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Email").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 instructor.setEmail(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Password").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 instructor.setPassword(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("No_of_Evaluators").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 instructor.setNoofEvaluators(Integer.parseInt(dataSnapshot.getValue(String.class)));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Total_Evaluation").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 instructor.setTotalEvaluation(Float.parseFloat(dataSnapshot.getValue(String.class)));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Office_Hours").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 instructor.setOfficeHours(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Courses")
                 .addListenerForSingleValueEvent(new ValueEventListener() {
                     @Override
                     public void onDataChange(DataSnapshot dataSnapshot) {
                         for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                             InstructorCourse instructorCourse=new InstructorCourse();
                             instructorCourse.Name= Objects.requireNonNull(snapshot.child("Name").getValue()).toString();
                             instructorCourse.InstructorofCourse= Objects.requireNonNull(snapshot.child("InstructorOfCourse").getValue()).toString();
                             instructorCourse.code= Objects.requireNonNull(snapshot.child("Code").getValue()).toString();
                             for (DataSnapshot snapshot1:dataSnapshot.child("TAList").getChildren())
                                 instructorCourse.TAlist.add(Objects.requireNonNull(snapshot1.getValue()).toString());
                             for (DataSnapshot snapshot1:dataSnapshot.child("StudentList").getChildren())
                                 instructorCourse.TAlist.add(Objects.requireNonNull(snapshot1.getValue()).toString());
                             instructorCourse.CreditHours= (long) snapshot.child("credithours").getValue();
                             instructor.InsertCourse(instructorCourse);
                         }
                     }
                     @Override
                     public void onCancelled(DatabaseError databaseError) {
                         Log.w(TAG, "Failed to read value.", databaseError.toException());
                     }
                 });
         return instructor;
     }
     public static void AddTA(TeacherAssistant teacherAssistant){
         FirebaseDatabase.getInstance().setPersistenceEnabled(true);
         DatabaseReference target=root.child("Teacher_Assistants").child(teacherAssistant.getID());
         target.child("Name").setValue(teacherAssistant.getName());
         target.child("Gender").setValue(teacherAssistant.getGender());
         target.child("Email").setValue(teacherAssistant.getEmail());
         target.child("Password").setValue(teacherAssistant.getPassword());
         target.child("No_of_Evaluators").setValue(teacherAssistant.getNoofEvaluators());
         target.child("Total_Evaluation").setValue(teacherAssistant.getTotalEvaluation());
         target.child("Department").setValue(teacherAssistant.getDepartment());
         target.child("Credit_Hours").setValue(teacherAssistant.getCreditHours());
         target.child("Remain_Credit_Hours").setValue(teacherAssistant.getRCreditHours());
         if(teacherAssistant.Courselist.size()>=1){
             for (TACourse s:teacherAssistant.Courselist) {
                 target.child("Courses").child(s.code).child("Code").setValue(s.code);
                 target.child("Courses").child(s.code).child("Name").setValue(s.Name);
                 target.child("Courses").child(s.code).child("InstructorOfCourse").setValue(s.InstructorofCourse);
                 for (String f:s.TAlist)
                     target.child("Courses").child(s.getCode()).child("TAList").child(f).setValue(f);
                 target.child("Courses").child(s.getCode()).child("credithours").setValue(s.CreditHours);
                 for (String f:s.Studentlist)
                     target.child("Courses").child(s.getCode()).child("StudentList").child(f).setValue(f);
             }
         }
     }
     public static TeacherAssistant GetTAInfo(String id){
         FirebaseDatabase.getInstance().setPersistenceEnabled(true);
         DatabaseReference target=root.child("Teacher_Assistants").child(id);
         final TeacherAssistant teacherAssistant=new TeacherAssistant();
         target.child("Name").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setName(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Gender").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setGender(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Email").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setEmail(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Password").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setPassword(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("No_of_Evaluators").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setNoofEvaluators(Integer.parseInt(Objects.requireNonNull(dataSnapshot.getValue(String.class))));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Total_Evaluation").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setTotalEvaluation(Float.parseFloat(dataSnapshot.getValue(String.class)));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Department").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setDepartment(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Credit_Hours").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setCreditHours(Integer.parseInt(dataSnapshot.getValue(String.class)));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Remain_Credit_Hours").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 teacherAssistant.setRCreditHours(Integer.parseInt(dataSnapshot.getValue(String.class)));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Courses")
                 .addListenerForSingleValueEvent(new ValueEventListener() {
                     @Override
                     public void onDataChange(DataSnapshot dataSnapshot) {
                         for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                             TACourse taCourse=new TACourse();
                             taCourse.Name= Objects.requireNonNull(snapshot.child("Name").getValue()).toString();
                             taCourse.InstructorofCourse= Objects.requireNonNull(snapshot.child("InstructorOfCourse").getValue()).toString();
                             taCourse.code= Objects.requireNonNull(snapshot.child("Code").getValue()).toString();
                             for (DataSnapshot snapshot1:dataSnapshot.child("TAList").getChildren())
                                 taCourse.TAlist.add(Objects.requireNonNull(snapshot1.getValue()).toString());
                             for (DataSnapshot snapshot1:dataSnapshot.child("StudentList").getChildren())
                                 taCourse.TAlist.add(Objects.requireNonNull(snapshot1.getValue()).toString());
                             taCourse.CreditHours= (long) snapshot.child("credithours").getValue();
                             teacherAssistant.InsertCourse(taCourse);
                         }
                     }
                     @Override
                     public void onCancelled(DatabaseError databaseError) {
                         Log.w(TAG, "Failed to read value.", databaseError.toException());
                     }
                 });
         return teacherAssistant;
     }
     public static void AddCourse(Course course){
         FirebaseDatabase.getInstance().setPersistenceEnabled(true);
         DatabaseReference target=root.child("Courses").child(course.getCode());
         target.child("Name").setValue(course.getName());
         target.child("Credit_Hours").setValue(course.getCreditHours());
         target.child("Instructor_of_Course").setValue(course.getInstructorofCourse());
         for (int i=0;i<course.TAlist.size();i++) {
             String indx=String.valueOf(i);
             target.child("Teacher_Assistants").child(indx).setValue(course.TAlist.get(i));
         }
         if (course.TAlist.size()>=1){
            for (String f:course.TAlist)
                     target.child("TAList").child(f).setValue(f);
            target.child("credithours").setValue(course.CreditHours);
         }
     }
     public static Course GetCourseInfo(String Code){
         FirebaseDatabase.getInstance().setPersistenceEnabled(true);
         DatabaseReference target=root.child("Courses").child(Code);
         final Course course=new Course();
         target.child("Name").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 course.setName(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Credit_Hours").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 course.setCreditHours(Integer.parseInt(Objects.requireNonNull(dataSnapshot.getValue(String.class))));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Instructor_of_Course").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 course.setInstructorofCourse(dataSnapshot.getValue(String.class));
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         target.child("Teacher_Assistants")
                 .addListenerForSingleValueEvent(new ValueEventListener() {
                     @Override
                     public void onDataChange(DataSnapshot dataSnapshot) {
                         for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                             course.TAlist.add(snapshot.getValue(String.class));
                         }
                     }
                     @Override
                     public void onCancelled(DatabaseError databaseError) {
                         Log.w(TAG, "Failed to read value.", databaseError.toException());
                     }
                 });
         return course;
     }
    public static boolean ChickStudentID(String id){
        final boolean[] exist = new boolean[1];
        root.child("Students").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                exist[0] = dataSnapshot.exists();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        return exist[0];
    }
     public static boolean ChickStudentEmailandPassword(String id){
         final boolean[] exist = new boolean[1];
         root.child("Users").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 exist[0] = dataSnapshot.exists();
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         return exist[0];
     }
     public static void WritePost(Post post){
         FirebaseDatabase.getInstance().setPersistenceEnabled(true);
         DatabaseReference target=root.child("Posts").child(post.Poster);
         target.child("Post").setValue(post.PostContent);
         target.child("Gender").setValue(post.Gender);
         target.child("Time").setValue(post.PostTime);
     }
     public static ArrayList<Post> ReadPosts(){
         DatabaseReference target=root.child("Posts");
         final  ArrayList<Post>posts = new  ArrayList<>();
         target.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                     Post post=new Post("noone","empty","unknown");
                     post.Poster=dataSnapshot.getKey();
                     post.PostContent= Objects.requireNonNull(dataSnapshot.child("Post").getValue()).toString();
                     post.Gender= Objects.requireNonNull(dataSnapshot.child("Gender").getValue()).toString();
                     post.PostTime= Objects.requireNonNull(dataSnapshot.child("Time").getValue()).toString();
                     posts.add(post);
                 }
             }
             @Override
             public void onCancelled(DatabaseError databaseError) {
                 Log.w(TAG, "Failed to read value.", databaseError.toException());
             }
         });
         return posts;
     }

 }
